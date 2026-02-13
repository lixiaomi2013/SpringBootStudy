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
import com.ruoyi.mgmt.domain.PurchaseOrders;
import com.ruoyi.mgmt.service.IPurchaseOrdersService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 采购订单Controller
 * 
 * @author zhuhoulin
 * @date 2026-01-22
 */
@Controller
@RequestMapping("/mgmt/purchaseorders")
public class PurchaseOrdersController extends BaseController
{
    private String prefix = "mgmt/purchaseorders";

    @Autowired
    private IPurchaseOrdersService purchaseOrdersService;

    @RequiresPermissions("mgmt:purchaseorders:view")
    @GetMapping()
    public String purchaseorders()
    {
        return prefix + "/purchaseorders";
    }

    /**
     * 查询采购订单列表
     */
    @RequiresPermissions("mgmt:purchaseorders:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(PurchaseOrders purchaseOrders)
    {
        startPage();
        List<PurchaseOrders> list = purchaseOrdersService.selectPurchaseOrdersList(purchaseOrders);
        return getDataTable(list);
    }

    /**
     * 导出采购订单列表
     */
    @RequiresPermissions("mgmt:purchaseorders:export")
    @Log(title = "采购订单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(PurchaseOrders purchaseOrders)
    {
        List<PurchaseOrders> list = purchaseOrdersService.selectPurchaseOrdersList(purchaseOrders);
        ExcelUtil<PurchaseOrders> util = new ExcelUtil<PurchaseOrders>(PurchaseOrders.class);
        return util.exportExcel(list, "采购订单数据");
    }

    /**
     * 新增采购订单
     */
    @RequiresPermissions("mgmt:purchaseorders:add")
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存采购订单
     */
    @RequiresPermissions("mgmt:purchaseorders:add")
    @Log(title = "采购订单", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(PurchaseOrders purchaseOrders)
    {
        return toAjax(purchaseOrdersService.insertPurchaseOrders(purchaseOrders));
    }

    /**
     * 修改采购订单
     */
    @RequiresPermissions("mgmt:purchaseorders:edit")
    @GetMapping("/edit/{purchaseId}")
    public String edit(@PathVariable("purchaseId") String purchaseId, ModelMap mmap)
    {
        PurchaseOrders purchaseOrders = purchaseOrdersService.selectPurchaseOrdersByPurchaseId(purchaseId);
        mmap.put("purchaseOrders", purchaseOrders);
        return prefix + "/edit";
    }

    /**
     * 修改保存采购订单
     */
    @RequiresPermissions("mgmt:purchaseorders:edit")
    @Log(title = "采购订单", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(PurchaseOrders purchaseOrders)
    {
        return toAjax(purchaseOrdersService.updatePurchaseOrders(purchaseOrders));
    }

    /**
     * 删除采购订单
     */
    @RequiresPermissions("mgmt:purchaseorders:remove")
    @Log(title = "采购订单", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(purchaseOrdersService.deletePurchaseOrdersByPurchaseIds(ids));
    }

    @RequiresPermissions("mgmt:purchaseorders:view")
    @GetMapping("/select")
    public String select() {
        return prefix + "/select";
    }
}
