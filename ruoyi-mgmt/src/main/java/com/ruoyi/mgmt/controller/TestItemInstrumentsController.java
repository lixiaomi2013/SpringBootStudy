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
import com.ruoyi.mgmt.domain.TestItemInstruments;
import com.ruoyi.mgmt.service.ITestItemInstrumentsService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 检验项目与设备关联Controller
 * 
 * @author zhuhoulin
 * @date 2026-01-19
 */
@Controller
@RequestMapping("/mgmt/testiteminstruments")
public class TestItemInstrumentsController extends BaseController
{
    private String prefix = "mgmt/testiteminstruments";

    @Autowired
    private ITestItemInstrumentsService testItemInstrumentsService;

    @RequiresPermissions("mgmt:testiteminstruments:view")
    @GetMapping()
    public String testiteminstruments()
    {
        return prefix + "/testiteminstruments";
    }

    /**
     * 查询检验项目与设备关联列表
     */
    @RequiresPermissions("mgmt:testiteminstruments:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TestItemInstruments testItemInstruments)
    {
        startPage();
        List<TestItemInstruments> list = testItemInstrumentsService.selectTestItemInstrumentsList(testItemInstruments);
        return getDataTable(list);
    }

    /**
     * 导出检验项目与设备关联列表
     */
    @RequiresPermissions("mgmt:testiteminstruments:export")
    @Log(title = "检验项目与设备关联", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TestItemInstruments testItemInstruments)
    {
        List<TestItemInstruments> list = testItemInstrumentsService.selectTestItemInstrumentsList(testItemInstruments);
        ExcelUtil<TestItemInstruments> util = new ExcelUtil<TestItemInstruments>(TestItemInstruments.class);
        return util.exportExcel(list, "检验项目与设备关联数据");
    }

    /**
     * 新增检验项目与设备关联
     */
    @RequiresPermissions("mgmt:testiteminstruments:add")
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存检验项目与设备关联
     */
    @RequiresPermissions("mgmt:testiteminstruments:add")
    @Log(title = "检验项目与设备关联", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TestItemInstruments testItemInstruments)
    {
        return toAjax(testItemInstrumentsService.insertTestItemInstruments(testItemInstruments));
    }

    /**
     * 修改检验项目与设备关联
     */
    @RequiresPermissions("mgmt:testiteminstruments:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
        TestItemInstruments testItemInstruments = testItemInstrumentsService.selectTestItemInstrumentsById(id);
        mmap.put("testItemInstruments", testItemInstruments);
        return prefix + "/edit";
    }

    /**
     * 修改保存检验项目与设备关联
     */
    @RequiresPermissions("mgmt:testiteminstruments:edit")
    @Log(title = "检验项目与设备关联", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TestItemInstruments testItemInstruments)
    {
        return toAjax(testItemInstrumentsService.updateTestItemInstruments(testItemInstruments));
    }

    /**
     * 删除检验项目与设备关联
     */
    @RequiresPermissions("mgmt:testiteminstruments:remove")
    @Log(title = "检验项目与设备关联", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(testItemInstrumentsService.deleteTestItemInstrumentsByIds(ids));
    }
}
