package com.ruoyi.mgmt.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.uuid.IdUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.mgmt.mapper.PurchaseOrderDetailsMapper;
import com.ruoyi.mgmt.domain.PurchaseOrderDetails;
import com.ruoyi.mgmt.service.IPurchaseOrderDetailsService;
import com.ruoyi.common.core.text.Convert;

/**
 * 采购订单明细Service业务层处理
 * 
 * @author zhuhoulin
 * @date 2026-01-22
 */
@Service
public class PurchaseOrderDetailsServiceImpl implements IPurchaseOrderDetailsService 
{
    @Autowired
    private PurchaseOrderDetailsMapper purchaseOrderDetailsMapper;

    /**
     * 查询采购订单明细
     * 
     * @param detailId 采购订单明细主键
     * @return 采购订单明细
     */
    @Override
    public PurchaseOrderDetails selectPurchaseOrderDetailsByDetailId(String detailId)
    {
        return purchaseOrderDetailsMapper.selectPurchaseOrderDetailsByDetailId(detailId);
    }

    /**
     * 查询采购订单明细列表
     * 
     * @param purchaseOrderDetails 采购订单明细
     * @return 采购订单明细
     */
    @Override
    public List<PurchaseOrderDetails> selectPurchaseOrderDetailsList(PurchaseOrderDetails purchaseOrderDetails)
    {
        return purchaseOrderDetailsMapper.selectPurchaseOrderDetailsList(purchaseOrderDetails);
    }

    /**
     * 新增采购订单明细
     * 
     * @param purchaseOrderDetails 采购订单明细
     * @return 结果
     */
    @Override
    public int insertPurchaseOrderDetails(PurchaseOrderDetails purchaseOrderDetails)
    {
        purchaseOrderDetails.setDetailId(IdUtils.fastSimpleUUID());
        purchaseOrderDetails.setCreateTime(DateUtils.getNowDate());
        return purchaseOrderDetailsMapper.insertPurchaseOrderDetails(purchaseOrderDetails);
    }

    /**
     * 修改采购订单明细
     * 
     * @param purchaseOrderDetails 采购订单明细
     * @return 结果
     */
    @Override
    public int updatePurchaseOrderDetails(PurchaseOrderDetails purchaseOrderDetails)
    {
        purchaseOrderDetails.setUpdateTime(DateUtils.getNowDate());
        return purchaseOrderDetailsMapper.updatePurchaseOrderDetails(purchaseOrderDetails);
    }

    /**
     * 批量删除采购订单明细
     * 
     * @param detailIds 需要删除的采购订单明细主键
     * @return 结果
     */
    @Override
    public int deletePurchaseOrderDetailsByDetailIds(String detailIds)
    {
        return purchaseOrderDetailsMapper.deletePurchaseOrderDetailsByDetailIds(Convert.toStrArray(detailIds));
    }

    /**
     * 删除采购订单明细信息
     * 
     * @param detailId 采购订单明细主键
     * @return 结果
     */
    @Override
    public int deletePurchaseOrderDetailsByDetailId(String detailId)
    {
        return purchaseOrderDetailsMapper.deletePurchaseOrderDetailsByDetailId(detailId);
    }
}
