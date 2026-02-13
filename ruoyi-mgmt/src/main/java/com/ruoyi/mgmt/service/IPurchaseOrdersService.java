package com.ruoyi.mgmt.service;

import java.util.List;
import com.ruoyi.mgmt.domain.PurchaseOrders;

/**
 * 采购订单Service接口
 * 
 * @author zhuhoulin
 * @date 2026-01-22
 */
public interface IPurchaseOrdersService 
{
    /**
     * 查询采购订单
     * 
     * @param purchaseId 采购订单主键
     * @return 采购订单
     */
    public PurchaseOrders selectPurchaseOrdersByPurchaseId(String purchaseId);

    /**
     * 查询采购订单列表
     * 
     * @param purchaseOrders 采购订单
     * @return 采购订单集合
     */
    public List<PurchaseOrders> selectPurchaseOrdersList(PurchaseOrders purchaseOrders);

    /**
     * 新增采购订单
     * 
     * @param purchaseOrders 采购订单
     * @return 结果
     */
    public int insertPurchaseOrders(PurchaseOrders purchaseOrders);

    /**
     * 修改采购订单
     * 
     * @param purchaseOrders 采购订单
     * @return 结果
     */
    public int updatePurchaseOrders(PurchaseOrders purchaseOrders);

    /**
     * 批量删除采购订单
     * 
     * @param purchaseIds 需要删除的采购订单主键集合
     * @return 结果
     */
    public int deletePurchaseOrdersByPurchaseIds(String purchaseIds);

    /**
     * 删除采购订单信息
     * 
     * @param purchaseId 采购订单主键
     * @return 结果
     */
    public int deletePurchaseOrdersByPurchaseId(String purchaseId);
}
