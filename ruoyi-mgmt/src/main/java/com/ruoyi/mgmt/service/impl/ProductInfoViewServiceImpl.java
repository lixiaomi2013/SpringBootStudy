package com.ruoyi.mgmt.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.uuid.IdUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.mgmt.mapper.ProductInfoViewMapper;
import com.ruoyi.mgmt.domain.ProductInfoView;
import com.ruoyi.mgmt.service.IProductInfoViewService;
import com.ruoyi.common.core.text.Convert;

/**
 * 产品库存信息Service业务层处理
 * 
 * @author zhuhoulin
 * @date 2026-02-09
 */
@Service
public class ProductInfoViewServiceImpl implements IProductInfoViewService 
{
    @Autowired
    private ProductInfoViewMapper productInfoViewMapper;

    /**
     * 查询产品库存信息
     * 
     * @param productId 产品库存信息主键
     * @return 产品库存信息
     */
    @Override
    public ProductInfoView selectProductInfoViewByProductId(String productId)
    {
        return productInfoViewMapper.selectProductInfoViewByProductId(productId);
    }

    /**
     * 查询产品库存信息列表
     * 
     * @param productInfoView 产品库存信息
     * @return 产品库存信息
     */
    @Override
    public List<ProductInfoView> selectProductInfoViewList(ProductInfoView productInfoView)
    {
        return productInfoViewMapper.selectProductInfoViewList(productInfoView);
    }

    /**
     * 新增产品库存信息
     * 
     * @param productInfoView 产品库存信息
     * @return 结果
     */
    @Override
    public int insertProductInfoView(ProductInfoView productInfoView)
    {
        productInfoView.setProductId(IdUtils.fastSimpleUUID());
        productInfoView.setCreateTime(DateUtils.getNowDate());
        return productInfoViewMapper.insertProductInfoView(productInfoView);
    }

    /**
     * 修改产品库存信息
     * 
     * @param productInfoView 产品库存信息
     * @return 结果
     */
    @Override
    public int updateProductInfoView(ProductInfoView productInfoView)
    {
        productInfoView.setUpdateTime(DateUtils.getNowDate());
        return productInfoViewMapper.updateProductInfoView(productInfoView);
    }

    /**
     * 批量删除产品库存信息
     * 
     * @param productIds 需要删除的产品库存信息主键
     * @return 结果
     */
    @Override
    public int deleteProductInfoViewByProductIds(String productIds)
    {
        return productInfoViewMapper.deleteProductInfoViewByProductIds(Convert.toStrArray(productIds));
    }

    /**
     * 删除产品库存信息信息
     * 
     * @param productId 产品库存信息主键
     * @return 结果
     */
    @Override
    public int deleteProductInfoViewByProductId(String productId)
    {
        return productInfoViewMapper.deleteProductInfoViewByProductId(productId);
    }
}
