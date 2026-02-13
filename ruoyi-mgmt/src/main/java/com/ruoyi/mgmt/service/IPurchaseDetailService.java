package com.ruoyi.mgmt.service;

import java.util.List;
import com.ruoyi.mgmt.domain.PurchaseDetail;

/**
 * 进货明细Service接口
 * 
 * @author zhuhoulin
 * @date 2026-01-05
 */
public interface IPurchaseDetailService 
{
    /**
     * 查询进货明细
     * 
     * @param detailId 进货明细主键
     * @return 进货明细
     */
    public PurchaseDetail selectPurchaseDetailByDetailId(String detailId);

    /**
     * 查询进货明细列表
     * 
     * @param purchaseDetail 进货明细
     * @return 进货明细集合
     */
    public List<PurchaseDetail> selectPurchaseDetailList(PurchaseDetail purchaseDetail);

    /**
     * 新增进货明细
     * 
     * @param purchaseDetail 进货明细
     * @return 结果
     */
    public int insertPurchaseDetail(PurchaseDetail purchaseDetail);

    /**
     * 修改进货明细
     * 
     * @param purchaseDetail 进货明细
     * @return 结果
     */
    public int updatePurchaseDetail(PurchaseDetail purchaseDetail);

    /**
     * 批量删除进货明细
     * 
     * @param detailIds 需要删除的进货明细主键集合
     * @return 结果
     */
    public int deletePurchaseDetailByDetailIds(String detailIds);

    /**
     * 删除进货明细信息
     * 
     * @param detailId 进货明细主键
     * @return 结果
     */
    public int deletePurchaseDetailByDetailId(String detailId);
}
