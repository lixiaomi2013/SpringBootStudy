package com.ruoyi.mgmt.mapper;

import java.util.List;
import com.ruoyi.mgmt.domain.PurchaseOrderDetails;

/**
 * 采购订单明细Mapper接口
 * 
 * @author zhuhoulin
 * @date 2026-01-22
 */
public interface PurchaseOrderDetailsMapper 
{
    /**
     * 查询采购订单明细
     * 
     * @param detailId 采购订单明细主键
     * @return 采购订单明细
     */
    public PurchaseOrderDetails selectPurchaseOrderDetailsByDetailId(String detailId);

    /**
     * 查询采购订单明细列表
     * 
     * @param purchaseOrderDetails 采购订单明细
     * @return 采购订单明细集合
     */
    public List<PurchaseOrderDetails> selectPurchaseOrderDetailsList(PurchaseOrderDetails purchaseOrderDetails);

    /**
     * 新增采购订单明细
     * 
     * @param purchaseOrderDetails 采购订单明细
     * @return 结果
     */
    public int insertPurchaseOrderDetails(PurchaseOrderDetails purchaseOrderDetails);

    /**
     * 修改采购订单明细
     * 
     * @param purchaseOrderDetails 采购订单明细
     * @return 结果
     */
    public int updatePurchaseOrderDetails(PurchaseOrderDetails purchaseOrderDetails);

    /**
     * 删除采购订单明细
     * 
     * @param detailId 采购订单明细主键
     * @return 结果
     */
    public int deletePurchaseOrderDetailsByDetailId(String detailId);

    /**
     * 批量删除采购订单明细
     * 
     * @param detailIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePurchaseOrderDetailsByDetailIds(String[] detailIds);
}
