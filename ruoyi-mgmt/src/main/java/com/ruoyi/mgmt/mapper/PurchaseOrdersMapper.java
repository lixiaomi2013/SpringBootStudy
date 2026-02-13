package com.ruoyi.mgmt.mapper;

import java.util.List;
import com.ruoyi.mgmt.domain.PurchaseOrders;

/**
 * 采购订单Mapper接口
 * 
 * @author zhuhoulin
 * @date 2026-01-22
 */
public interface PurchaseOrdersMapper 
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
     * 删除采购订单
     * 
     * @param purchaseId 采购订单主键
     * @return 结果
     */
    public int deletePurchaseOrdersByPurchaseId(String purchaseId);

    /**
     * 批量删除采购订单
     * 
     * @param purchaseIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePurchaseOrdersByPurchaseIds(String[] purchaseIds);
}
