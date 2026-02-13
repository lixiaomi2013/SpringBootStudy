package com.ruoyi.mgmt.controller;

import java.util.List;

import com.ruoyi.mgmt.domain.TestItemProductInfo;
import com.ruoyi.mgmt.service.ITestItemProductInfoService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 项目与产品关系Controller
 * 
 * @author zhuhoulin
 * @date 2026-01-20
 */
@Controller
@RequestMapping("/mgmt/testitemproductinfo")
public class TestItemProductInfoController extends BaseController
{
    private String prefix = "mgmt/testitemproductinfo";

    @Autowired
    private ITestItemProductInfoService testItemProductInfoService;

    @RequiresPermissions("mgmt:testitemproductinfo:view")
    @GetMapping()
    public String testitemproductinfo()
    {
        return prefix + "/testitemproductinfo";
    }

    /**
     * 查询项目与产品关系列表
     */
    @RequiresPermissions("mgmt:testitemproductinfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TestItemProductInfo testItemProductInfo)
    {
        startPage();
        List<TestItemProductInfo> list = testItemProductInfoService.selectTestItemProductInfoList(testItemProductInfo);
        return getDataTable(list);
    }

    /**
     * 导出项目与产品关系列表
     */
    @RequiresPermissions("mgmt:testitemproductinfo:export")
    @Log(title = "项目与产品关系", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TestItemProductInfo testItemProductInfo)
    {
        List<TestItemProductInfo> list = testItemProductInfoService.selectTestItemProductInfoList(testItemProductInfo);
        ExcelUtil<TestItemProductInfo> util = new ExcelUtil<TestItemProductInfo>(TestItemProductInfo.class);
        return util.exportExcel(list, "项目与产品关系数据");
    }

    /**
     * 新增项目与产品关系
     */
    @RequiresPermissions("mgmt:testitemproductinfo:add")
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存项目与产品关系
     */
    @RequiresPermissions("mgmt:testitemproductinfo:add")
    @Log(title = "项目与产品关系", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TestItemProductInfo testItemProductInfo)
    {
        return toAjax(testItemProductInfoService.insertTestItemProductInfo(testItemProductInfo));
    }

    /**
     * 修改项目与产品关系
     */
    @RequiresPermissions("mgmt:testitemproductinfo:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
        TestItemProductInfo testItemProductInfo = testItemProductInfoService.selectTestItemProductInfoById(id);
        mmap.put("testItemProductInfo", testItemProductInfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存项目与产品关系
     */
    @RequiresPermissions("mgmt:testitemproductinfo:edit")
    @Log(title = "项目与产品关系", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TestItemProductInfo testItemProductInfo)
    {
        return toAjax(testItemProductInfoService.updateTestItemProductInfo(testItemProductInfo));
    }

    /**
     * 删除项目与产品关系
     */
    @RequiresPermissions("mgmt:testitemproductinfo:remove")
    @Log(title = "项目与产品关系", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(testItemProductInfoService.deleteTestItemProductInfoByIds(ids));
    }
}
