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
import com.ruoyi.mgmt.domain.PurchaseDetail;
import com.ruoyi.mgmt.service.IPurchaseDetailService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 进货明细Controller
 * 
 * @author zhuhoulin
 * @date 2026-01-05
 */
@Controller
@RequestMapping("/mgmt/purchasedetail")
public class PurchaseDetailController extends BaseController
{
    private String prefix = "mgmt/purchasedetail";

    @Autowired
    private IPurchaseDetailService purchaseDetailService;

    @RequiresPermissions("mgmt:purchasedetail:view")
    @GetMapping()
    public String purchasedetail()
    {
        return prefix + "/purchasedetail";
    }

    /**
     * 查询进货明细列表
     */
    @RequiresPermissions("mgmt:purchasedetail:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(PurchaseDetail purchaseDetail)
    {
        startPage();
        List<PurchaseDetail> list = purchaseDetailService.selectPurchaseDetailList(purchaseDetail);
        return getDataTable(list);
    }

    /**
     * 导出进货明细列表
     */
    @RequiresPermissions("mgmt:purchasedetail:export")
    @Log(title = "进货明细", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(PurchaseDetail purchaseDetail)
    {
        List<PurchaseDetail> list = purchaseDetailService.selectPurchaseDetailList(purchaseDetail);
        ExcelUtil<PurchaseDetail> util = new ExcelUtil<PurchaseDetail>(PurchaseDetail.class);
        return util.exportExcel(list, "进货明细数据");
    }

    /**
     * 新增进货明细
     */
    @RequiresPermissions("mgmt:purchasedetail:add")
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存进货明细
     */
    @RequiresPermissions("mgmt:purchasedetail:add")
    @Log(title = "进货明细", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(PurchaseDetail purchaseDetail)
    {
        return toAjax(purchaseDetailService.insertPurchaseDetail(purchaseDetail));
    }

    /**
     * 修改进货明细
     */
    @RequiresPermissions("mgmt:purchasedetail:edit")
    @GetMapping("/edit/{detailId}")
    public String edit(@PathVariable("detailId") String detailId, ModelMap mmap)
    {
        PurchaseDetail purchaseDetail = purchaseDetailService.selectPurchaseDetailByDetailId(detailId);
        mmap.put("purchaseDetail", purchaseDetail);
        return prefix + "/edit";
    }

    /**
     * 修改保存进货明细
     */
    @RequiresPermissions("mgmt:purchasedetail:edit")
    @Log(title = "进货明细", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(PurchaseDetail purchaseDetail)
    {
        return toAjax(purchaseDetailService.updatePurchaseDetail(purchaseDetail));
    }

    /**
     * 删除进货明细
     */
    @RequiresPermissions("mgmt:purchasedetail:remove")
    @Log(title = "进货明细", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(purchaseDetailService.deletePurchaseDetailByDetailIds(ids));
    }
    
    @RequiresPermissions("mgmt:purchasedetail:view")
	@GetMapping("/select")
	public String select() {
		return prefix + "/select";
	}
}
