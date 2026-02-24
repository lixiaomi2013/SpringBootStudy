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
import com.ruoyi.mgmt.domain.TestItemInstrumentProductInfoView;
import com.ruoyi.mgmt.service.ITestItemInstrumentProductInfoViewService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 仪器项目产品信息Controller
 * 
 * @author zhuhoulin
 * @date 2026-02-24
 */
@Controller
@RequestMapping("/mgmt/testiteminstrumentproductinfo")
public class TestItemInstrumentProductInfoViewController extends BaseController
{
    private String prefix = "mgmt/testiteminstrumentproductinfo";

    @Autowired
    private ITestItemInstrumentProductInfoViewService testItemInstrumentProductInfoViewService;

    @RequiresPermissions("mgmt:testiteminstrumentproductinfo:view")
    @GetMapping()
    public String testiteminstrumentproductinfo()
    {
        return prefix + "/testiteminstrumentproductinfo";
    }

    /**
     * 查询仪器项目产品信息列表
     */
    @RequiresPermissions("mgmt:testiteminstrumentproductinfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TestItemInstrumentProductInfoView testItemInstrumentProductInfoView)
    {
        startPage();
        List<TestItemInstrumentProductInfoView> list = testItemInstrumentProductInfoViewService.selectTestItemInstrumentProductInfoViewList(testItemInstrumentProductInfoView);
        return getDataTable(list);
    }

    /**
     * 导出仪器项目产品信息列表
     */
    @RequiresPermissions("mgmt:testiteminstrumentproductinfo:export")
    @Log(title = "仪器项目产品信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TestItemInstrumentProductInfoView testItemInstrumentProductInfoView)
    {
        List<TestItemInstrumentProductInfoView> list = testItemInstrumentProductInfoViewService.selectTestItemInstrumentProductInfoViewList(testItemInstrumentProductInfoView);
        ExcelUtil<TestItemInstrumentProductInfoView> util = new ExcelUtil<TestItemInstrumentProductInfoView>(TestItemInstrumentProductInfoView.class);
        return util.exportExcel(list, "仪器项目产品信息数据");
    }

    /**
     * 新增仪器项目产品信息
     */
    @RequiresPermissions("mgmt:testiteminstrumentproductinfo:add")
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存仪器项目产品信息
     */
    @RequiresPermissions("mgmt:testiteminstrumentproductinfo:add")
    @Log(title = "仪器项目产品信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TestItemInstrumentProductInfoView testItemInstrumentProductInfoView)
    {
        return toAjax(testItemInstrumentProductInfoViewService.insertTestItemInstrumentProductInfoView(testItemInstrumentProductInfoView));
    }

    /**
     * 修改仪器项目产品信息
     */
    @RequiresPermissions("mgmt:testiteminstrumentproductinfo:edit")
    @GetMapping("/edit/{instrumentCode}")
    public String edit(@PathVariable("instrumentCode") String instrumentCode, ModelMap mmap)
    {
        TestItemInstrumentProductInfoView testItemInstrumentProductInfoView = testItemInstrumentProductInfoViewService.selectTestItemInstrumentProductInfoViewByInstrumentCode(instrumentCode);
        mmap.put("testItemInstrumentProductInfoView", testItemInstrumentProductInfoView);
        return prefix + "/edit";
    }

    /**
     * 修改保存仪器项目产品信息
     */
    @RequiresPermissions("mgmt:testiteminstrumentproductinfo:edit")
    @Log(title = "仪器项目产品信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TestItemInstrumentProductInfoView testItemInstrumentProductInfoView)
    {
        return toAjax(testItemInstrumentProductInfoViewService.updateTestItemInstrumentProductInfoView(testItemInstrumentProductInfoView));
    }

    /**
     * 删除仪器项目产品信息
     */
    @RequiresPermissions("mgmt:testiteminstrumentproductinfo:remove")
    @Log(title = "仪器项目产品信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(testItemInstrumentProductInfoViewService.deleteTestItemInstrumentProductInfoViewByInstrumentCodes(ids));
    }
}
