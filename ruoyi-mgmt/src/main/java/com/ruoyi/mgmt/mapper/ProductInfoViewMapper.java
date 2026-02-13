package com.ruoyi.mgmt.mapper;

import java.util.List;
import com.ruoyi.mgmt.domain.ProductInfoView;

/**
 * 产品库存信息Mapper接口
 * 
 * @author zhuhoulin
 * @date 2026-02-09
 */
public interface ProductInfoViewMapper 
{
    /**
     * 查询产品库存信息
     * 
     * @param productId 产品库存信息主键
     * @return 产品库存信息
     */
    public ProductInfoView selectProductInfoViewByProductId(String productId);

    /**
     * 查询产品库存信息列表
     * 
     * @param productInfoView 产品库存信息
     * @return 产品库存信息集合
     */
    public List<ProductInfoView> selectProductInfoViewList(ProductInfoView productInfoView);

    /**
     * 新增产品库存信息
     * 
     * @param productInfoView 产品库存信息
     * @return 结果
     */
    public int insertProductInfoView(ProductInfoView productInfoView);

    /**
     * 修改产品库存信息
     * 
     * @param productInfoView 产品库存信息
     * @return 结果
     */
    public int updateProductInfoView(ProductInfoView productInfoView);

    /**
     * 删除产品库存信息
     * 
     * @param productId 产品库存信息主键
     * @return 结果
     */
    public int deleteProductInfoViewByProductId(String productId);

    /**
     * 批量删除产品库存信息
     * 
     * @param productIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteProductInfoViewByProductIds(String[] productIds);
}
