package com.ruoyi.mgmt.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.uuid.IdUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.mgmt.mapper.PurchaseOrdersMapper;
import com.ruoyi.mgmt.domain.PurchaseOrders;
import com.ruoyi.mgmt.service.IPurchaseOrdersService;
import com.ruoyi.common.core.text.Convert;

/**
 * 采购订单Service业务层处理
 * 
 * @author zhuhoulin
 * @date 2026-01-22
 */
@Service
public class PurchaseOrdersServiceImpl implements IPurchaseOrdersService 
{
    @Autowired
    private PurchaseOrdersMapper purchaseOrdersMapper;

    /**
     * 查询采购订单
     * 
     * @param purchaseId 采购订单主键
     * @return 采购订单
     */
    @Override
    public PurchaseOrders selectPurchaseOrdersByPurchaseId(String purchaseId)
    {
        return purchaseOrdersMapper.selectPurchaseOrdersByPurchaseId(purchaseId);
    }

    /**
     * 查询采购订单列表
     * 
     * @param purchaseOrders 采购订单
     * @return 采购订单
     */
    @Override
    public List<PurchaseOrders> selectPurchaseOrdersList(PurchaseOrders purchaseOrders)
    {
        return purchaseOrdersMapper.selectPurchaseOrdersList(purchaseOrders);
    }

    /**
     * 新增采购订单
     * 
     * @param purchaseOrders 采购订单
     * @return 结果
     */
    @Override
    public int insertPurchaseOrders(PurchaseOrders purchaseOrders)
    {
        purchaseOrders.setPurchaseId(IdUtils.fastSimpleUUID());
        purchaseOrders.setCreateTime(DateUtils.getNowDate());
        return purchaseOrdersMapper.insertPurchaseOrders(purchaseOrders);
    }

    /**
     * 修改采购订单
     * 
     * @param purchaseOrders 采购订单
     * @return 结果
     */
    @Override
    public int updatePurchaseOrders(PurchaseOrders purchaseOrders)
    {
        purchaseOrders.setUpdateTime(DateUtils.getNowDate());
        return purchaseOrdersMapper.updatePurchaseOrders(purchaseOrders);
    }

    /**
     * 批量删除采购订单
     * 
     * @param purchaseIds 需要删除的采购订单主键
     * @return 结果
     */
    @Override
    public int deletePurchaseOrdersByPurchaseIds(String purchaseIds)
    {
        return purchaseOrdersMapper.deletePurchaseOrdersByPurchaseIds(Convert.toStrArray(purchaseIds));
    }

    /**
     * 删除采购订单信息
     * 
     * @param purchaseId 采购订单主键
     * @return 结果
     */
    @Override
    public int deletePurchaseOrdersByPurchaseId(String purchaseId)
    {
        return purchaseOrdersMapper.deletePurchaseOrdersByPurchaseId(purchaseId);
    }
}
