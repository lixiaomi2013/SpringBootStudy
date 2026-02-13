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
import com.ruoyi.mgmt.domain.Instruments;
import com.ruoyi.mgmt.service.IInstrumentsService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 仪器设备主Controller
 * 
 * @author zhuhoulin
 * @date 2026-01-19
 */
@Controller
@RequestMapping("/mgmt/instruments")
public class InstrumentsController extends BaseController
{
    private String prefix = "mgmt/instruments";

    @Autowired
    private IInstrumentsService instrumentsService;

    @RequiresPermissions("mgmt:instruments:view")
    @GetMapping()
    public String instruments()
    {
        return prefix + "/instruments";
    }

    /**
     * 查询仪器设备主列表
     */
    @RequiresPermissions("mgmt:instruments:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Instruments instruments)
    {
        startPage();
        List<Instruments> list = instrumentsService.selectInstrumentsList(instruments);
        return getDataTable(list);
    }

    /**
     * 导出仪器设备主列表
     */
    @RequiresPermissions("mgmt:instruments:export")
    @Log(title = "仪器设备主", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Instruments instruments)
    {
        List<Instruments> list = instrumentsService.selectInstrumentsList(instruments);
        ExcelUtil<Instruments> util = new ExcelUtil<Instruments>(Instruments.class);
        return util.exportExcel(list, "仪器设备主数据");
    }

    /**
     * 新增仪器设备主
     */
    @RequiresPermissions("mgmt:instruments:add")
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存仪器设备主
     */
    @RequiresPermissions("mgmt:instruments:add")
    @Log(title = "仪器设备主", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Instruments instruments)
    {
        return toAjax(instrumentsService.insertInstruments(instruments));
    }

    /**
     * 修改仪器设备主
     */
    @RequiresPermissions("mgmt:instruments:edit")
    @GetMapping("/edit/{instrumentId}")
    public String edit(@PathVariable("instrumentId") String instrumentId, ModelMap mmap)
    {
        Instruments instruments = instrumentsService.selectInstrumentsByInstrumentId(instrumentId);
        mmap.put("instruments", instruments);
        return prefix + "/edit";
    }

    /**
     * 修改保存仪器设备主
     */
    @RequiresPermissions("mgmt:instruments:edit")
    @Log(title = "仪器设备主", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Instruments instruments)
    {
        return toAjax(instrumentsService.updateInstruments(instruments));
    }

    /**
     * 删除仪器设备主
     */
    @RequiresPermissions("mgmt:instruments:remove")
    @Log(title = "仪器设备主", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(instrumentsService.deleteInstrumentsByInstrumentIds(ids));
    }
    
    @RequiresPermissions("mgmt:instruments:view")
	@GetMapping("/select")
	public String parent() {
		return prefix + "/select";
	}
}
