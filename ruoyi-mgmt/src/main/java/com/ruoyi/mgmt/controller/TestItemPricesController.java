package com.ruoyi.mgmt.controller;

import java.util.List;
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
import com.ruoyi.mgmt.domain.TestItemPrices;
import com.ruoyi.mgmt.service.ITestItemPricesService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 检验项目价格Controller
 * 
 * @author zhuhoulin
 * @date 2026-01-03
 */
@Controller
@RequestMapping("/mgmt/testitemprices")
public class TestItemPricesController extends BaseController
{
    private String prefix = "mgmt/testitemprices";

    @Autowired
    private ITestItemPricesService testItemPricesService;

    @RequiresPermissions("mgmt:testitemprices:view")
    @GetMapping()
    public String testitemprices()
    {
        return prefix + "/testitemprices";
    }

    /**
     * 查询检验项目价格列表
     */
    @RequiresPermissions("mgmt:testitemprices:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TestItemPrices testItemPrices)
    {
        startPage();
        List<TestItemPrices> list = testItemPricesService.selectTestItemPricesList(testItemPrices);
        return getDataTable(list);
    }

    /**
     * 导出检验项目价格列表
     */
    @RequiresPermissions("mgmt:testitemprices:export")
    @Log(title = "检验项目价格", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TestItemPrices testItemPrices)
    {
        List<TestItemPrices> list = testItemPricesService.selectTestItemPricesList(testItemPrices);
        ExcelUtil<TestItemPrices> util = new ExcelUtil<TestItemPrices>(TestItemPrices.class);
        return util.exportExcel(list, "检验项目价格数据");
    }

    /**
     * 新增检验项目价格
     */
    @RequiresPermissions("mgmt:testitemprices:add")
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存检验项目价格
     */
    @RequiresPermissions("mgmt:testitemprices:add")
    @Log(title = "检验项目价格", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TestItemPrices testItemPrices)
    {
        return toAjax(testItemPricesService.insertTestItemPrices(testItemPrices));
    }

    /**
     * 修改检验项目价格
     */
    @RequiresPermissions("mgmt:testitemprices:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
        TestItemPrices testItemPrices = testItemPricesService.selectTestItemPricesById(id);
        mmap.put("testItemPrices", testItemPrices);
        return prefix + "/edit";
    }

    /**
     * 修改保存检验项目价格
     */
    @RequiresPermissions("mgmt:testitemprices:edit")
    @Log(title = "检验项目价格", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TestItemPrices testItemPrices)
    {
        return toAjax(testItemPricesService.updateTestItemPrices(testItemPrices));
    }

    /**
     * 删除检验项目价格
     */
    @RequiresPermissions("mgmt:testitemprices:remove")
    @Log(title = "检验项目价格", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(testItemPricesService.deleteTestItemPricesByIds(ids));
    }
}
