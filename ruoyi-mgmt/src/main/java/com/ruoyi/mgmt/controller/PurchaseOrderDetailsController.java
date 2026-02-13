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
import com.ruoyi.mgmt.domain.PurchaseOrderDetails;
import com.ruoyi.mgmt.service.IPurchaseOrderDetailsService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 采购订单明细Controller
 * 
 * @author zhuhoulin
 * @date 2026-01-22
 */
@Controller
@RequestMapping("/mgmt/purchaseorderdetails")
public class PurchaseOrderDetailsController extends BaseController
{
    private String prefix = "mgmt/purchaseorderdetails";

    @Autowired
    private IPurchaseOrderDetailsService purchaseOrderDetailsService;

    @RequiresPermissions("mgmt:purchaseorderdetails:view")
    @GetMapping()
    public String purchaseorderdetails()
    {
        return prefix + "/purchaseorderdetails";
    }

    /**
     * 查询采购订单明细列表
     */
    @RequiresPermissions("mgmt:purchaseorderdetails:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(PurchaseOrderDetails purchaseOrderDetails)
    {
        startPage();
        List<PurchaseOrderDetails> list = purchaseOrderDetailsService.selectPurchaseOrderDetailsList(purchaseOrderDetails);
        return getDataTable(list);
    }

    /**
     * 导出采购订单明细列表
     */
    @RequiresPermissions("mgmt:purchaseorderdetails:export")
    @Log(title = "采购订单明细", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(PurchaseOrderDetails purchaseOrderDetails)
    {
        List<PurchaseOrderDetails> list = purchaseOrderDetailsService.selectPurchaseOrderDetailsList(purchaseOrderDetails);
        ExcelUtil<PurchaseOrderDetails> util = new ExcelUtil<PurchaseOrderDetails>(PurchaseOrderDetails.class);
        return util.exportExcel(list, "采购订单明细数据");
    }

    /**
     * 新增采购订单明细
     */
    @RequiresPermissions("mgmt:purchaseorderdetails:add")
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存采购订单明细
     */
    @RequiresPermissions("mgmt:purchaseorderdetails:add")
    @Log(title = "采购订单明细", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(PurchaseOrderDetails purchaseOrderDetails)
    {
        return toAjax(purchaseOrderDetailsService.insertPurchaseOrderDetails(purchaseOrderDetails));
    }

    /**
     * 修改采购订单明细
     */
    @RequiresPermissions("mgmt:purchaseorderdetails:edit")
    @GetMapping("/edit/{detailId}")
    public String edit(@PathVariable("detailId") String detailId, ModelMap mmap)
    {
        PurchaseOrderDetails purchaseOrderDetails = purchaseOrderDetailsService.selectPurchaseOrderDetailsByDetailId(detailId);
        mmap.put("purchaseOrderDetails", purchaseOrderDetails);
        return prefix + "/edit";
    }

    /**
     * 修改保存采购订单明细
     */
    @RequiresPermissions("mgmt:purchaseorderdetails:edit")
    @Log(title = "采购订单明细", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(PurchaseOrderDetails purchaseOrderDetails)
    {
        return toAjax(purchaseOrderDetailsService.updatePurchaseOrderDetails(purchaseOrderDetails));
    }

    /**
     * 删除采购订单明细
     */
    @RequiresPermissions("mgmt:purchaseorderdetails:remove")
    @Log(title = "采购订单明细", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(purchaseOrderDetailsService.deletePurchaseOrderDetailsByDetailIds(ids));
    }
}
