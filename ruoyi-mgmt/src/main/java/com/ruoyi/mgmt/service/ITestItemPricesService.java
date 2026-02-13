package com.ruoyi.mgmt.service;

import java.util.List;
import com.ruoyi.mgmt.domain.TestItemPrices;

/**
 * 检验项目价格Service接口
 * 
 * @author zhuhoulin
 * @date 2026-01-03
 */
public interface ITestItemPricesService 
{
    /**
     * 查询检验项目价格
     * 
     * @param id 检验项目价格主键
     * @return 检验项目价格
     */
    public TestItemPrices selectTestItemPricesById(String id);

    /**
     * 查询检验项目价格列表
     * 
     * @param testItemPrices 检验项目价格
     * @return 检验项目价格集合
     */
    public List<TestItemPrices> selectTestItemPricesList(TestItemPrices testItemPrices);

    /**
     * 新增检验项目价格
     * 
     * @param testItemPrices 检验项目价格
     * @return 结果
     */
    public int insertTestItemPrices(TestItemPrices testItemPrices);

    /**
     * 修改检验项目价格
     * 
     * @param testItemPrices 检验项目价格
     * @return 结果
     */
    public int updateTestItemPrices(TestItemPrices testItemPrices);

    /**
     * 批量删除检验项目价格
     * 
     * @param ids 需要删除的检验项目价格主键集合
     * @return 结果
     */
    public int deleteTestItemPricesByIds(String ids);

    /**
     * 删除检验项目价格信息
     * 
     * @param id 检验项目价格主键
     * @return 结果
     */
    public int deleteTestItemPricesById(String id);
}
