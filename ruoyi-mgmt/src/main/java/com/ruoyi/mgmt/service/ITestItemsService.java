package com.ruoyi.mgmt.service;

import java.util.List;
import com.ruoyi.mgmt.domain.TestItems;

/**
 * 检验项目信息Service接口
 * 
 * @author zhuhoulin
 * @date 2026-02-14
 */
public interface ITestItemsService 
{
    /**
     * 查询检验项目信息
     * 
     * @param testItemId 检验项目信息主键
     * @return 检验项目信息
     */
    public TestItems selectTestItemsByTestItemId(String testItemId);

    /**
     * 查询检验项目信息列表
     * 
     * @param testItems 检验项目信息
     * @return 检验项目信息集合
     */
    public List<TestItems> selectTestItemsList(TestItems testItems);

    /**
     * 新增检验项目信息
     * 
     * @param testItems 检验项目信息
     * @return 结果
     */
    public int insertTestItems(TestItems testItems);

    /**
     * 修改检验项目信息
     * 
     * @param testItems 检验项目信息
     * @return 结果
     */
    public int updateTestItems(TestItems testItems);

    /**
     * 批量删除检验项目信息
     * 
     * @param testItemIds 需要删除的检验项目信息主键集合
     * @return 结果
     */
    public int deleteTestItemsByTestItemIds(String testItemIds);

    /**
     * 删除检验项目信息信息
     * 
     * @param testItemId 检验项目信息主键
     * @return 结果
     */
    public int deleteTestItemsByTestItemId(String testItemId);
}
