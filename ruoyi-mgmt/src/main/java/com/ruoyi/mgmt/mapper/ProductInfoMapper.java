package com.ruoyi.mgmt.mapper;

import java.util.List;
import com.ruoyi.mgmt.domain.ProductInfo;

/**
 * 产品信息Mapper接口
 * 
 * @author zhuhoulin
 * @date 2026-02-02
 */
public interface ProductInfoMapper 
{
    /**
     * 查询产品信息
     * 
     * @param productId 产品信息主键
     * @return 产品信息
     */
    public ProductInfo selectProductInfoByProductId(String productId);

    /**
     * 查询产品信息列表
     * 
     * @param productInfo 产品信息
     * @return 产品信息集合
     */
    public List<ProductInfo> selectProductInfoList(ProductInfo productInfo);

    /**
     * 新增产品信息
     * 
     * @param productInfo 产品信息
     * @return 结果
     */
    public int insertProductInfo(ProductInfo productInfo);

    /**
     * 修改产品信息
     * 
     * @param productInfo 产品信息
     * @return 结果
     */
    public int updateProductInfo(ProductInfo productInfo);

    /**
     * 删除产品信息
     * 
     * @param productId 产品信息主键
     * @return 结果
     */
    public int deleteProductInfoByProductId(String productId);

    /**
     * 批量删除产品信息
     * 
     * @param productIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteProductInfoByProductIds(String[] productIds);
}
