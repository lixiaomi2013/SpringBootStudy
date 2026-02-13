package com.ruoyi.mgmt.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.uuid.IdUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.mgmt.mapper.ProductInfoMapper;
import com.ruoyi.mgmt.domain.ProductInfo;
import com.ruoyi.mgmt.service.IProductInfoService;
import com.ruoyi.common.core.text.Convert;

/**
 * 产品信息Service业务层处理
 * 
 * @author zhuhoulin
 * @date 2025-12-19
 */
@Service
public class ProductInfoServiceImpl implements IProductInfoService 
{
    @Autowired
    private ProductInfoMapper productInfoMapper;

    /**
     * 查询产品信息
     * 
     * @param productId 产品信息主键
     * @return 产品信息
     */
    @Override
    public ProductInfo selectProductInfoByProductId(String productId)
    {
        return productInfoMapper.selectProductInfoByProductId(productId);
    }

    /**
     * 查询产品信息列表
     * 
     * @param productInfo 产品信息
     * @return 产品信息
     */
    @Override
    public List<ProductInfo> selectProductInfoList(ProductInfo productInfo)
    {
        return productInfoMapper.selectProductInfoList(productInfo);
    }

    /**
     * 新增产品信息
     * 
     * @param productInfo 产品信息
     * @return 结果
     */
    @Override
    public int insertProductInfo(ProductInfo productInfo)
    {
        productInfo.setCreateTime(DateUtils.getNowDate());
        productInfo.setProductId(IdUtils.fastSimpleUUID());
        return productInfoMapper.insertProductInfo(productInfo);
    }

    /**
     * 修改产品信息
     * 
     * @param productInfo 产品信息
     * @return 结果
     */
    @Override
    public int updateProductInfo(ProductInfo productInfo)
    {
        productInfo.setUpdateTime(DateUtils.getNowDate());
        return productInfoMapper.updateProductInfo(productInfo);
    }

    /**
     * 批量删除产品信息
     * 
     * @param productIds 需要删除的产品信息主键
     * @return 结果
     */
    @Override
    public int deleteProductInfoByProductIds(String productIds)
    {
        return productInfoMapper.deleteProductInfoByProductIds(Convert.toStrArray(productIds));
    }

    /**
     * 删除产品信息信息
     * 
     * @param productId 产品信息主键
     * @return 结果
     */
    @Override
    public int deleteProductInfoByProductId(String productId)
    {
        return productInfoMapper.deleteProductInfoByProductId(productId);
    }
}
