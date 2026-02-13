package com.ruoyi.mgmt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.uuid.IdUtils;
import com.ruoyi.mgmt.domain.PurchaseDetail;
import com.ruoyi.mgmt.mapper.PurchaseDetailMapper;
import com.ruoyi.mgmt.service.IPurchaseDetailService;

/**
 * 进货明细Service业务层处理
 * 
 * @author zhuhoulin
 * @date 2026-01-05
 */
@Service
public class PurchaseDetailServiceImpl implements IPurchaseDetailService 
{
    @Autowired
    private PurchaseDetailMapper purchaseDetailMapper;

    /**
     * 查询进货明细
     * 
     * @param detailId 进货明细主键
     * @return 进货明细
     */
    @Override
    public PurchaseDetail selectPurchaseDetailByDetailId(String detailId)
    {
        return purchaseDetailMapper.selectPurchaseDetailByDetailId(detailId);
    }

    /**
     * 查询进货明细列表
     * 
     * @param purchaseDetail 进货明细
     * @return 进货明细
     */
    @Override
    public List<PurchaseDetail> selectPurchaseDetailList(PurchaseDetail purchaseDetail)
    {
        return purchaseDetailMapper.selectPurchaseDetailList(purchaseDetail);
    }

    /**
     * 新增进货明细
     * 
     * @param purchaseDetail 进货明细
     * @return 结果
     */
    @Override
    public int insertPurchaseDetail(PurchaseDetail purchaseDetail)
    {
        purchaseDetail.setCreateTime(DateUtils.getNowDate());
        purchaseDetail.setDetailId(IdUtils.fastSimpleUUID());
        return purchaseDetailMapper.insertPurchaseDetail(purchaseDetail);
    }

    /**
     * 修改进货明细
     * 
     * @param purchaseDetail 进货明细
     * @return 结果
     */
    @Override
    public int updatePurchaseDetail(PurchaseDetail purchaseDetail)
    {
        purchaseDetail.setUpdateTime(DateUtils.getNowDate());
        return purchaseDetailMapper.updatePurchaseDetail(purchaseDetail);
    }

    /**
     * 批量删除进货明细
     * 
     * @param detailIds 需要删除的进货明细主键
     * @return 结果
     */
    @Override
    public int deletePurchaseDetailByDetailIds(String detailIds)
    {
        return purchaseDetailMapper.deletePurchaseDetailByDetailIds(Convert.toStrArray(detailIds));
    }

    /**
     * 删除进货明细信息
     * 
     * @param detailId 进货明细主键
     * @return 结果
     */
    @Override
    public int deletePurchaseDetailByDetailId(String detailId)
    {
        return purchaseDetailMapper.deletePurchaseDetailByDetailId(detailId);
    }
}
