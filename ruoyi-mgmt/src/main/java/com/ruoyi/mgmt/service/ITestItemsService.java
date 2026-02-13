package com.ruoyi.mgmt.service;

import java.util.List;
import com.ruoyi.mgmt.domain.TestItems;

/**
 * 检验项目主Service接口
 * 
 * @author zhuhoulin
 * @date 2026-01-03
 */
public interface ITestItemsService 
{
    /**
     * 查询检验项目主
     * 
     * @param id 检验项目主主键
     * @return 检验项目主
     */
    public TestItems selectTestItemsById(String id);

    /**
     * 查询检验项目主列表
     * 
     * @param testItems 检验项目主
     * @return 检验项目主集合
     */
    public List<TestItems> selectTestItemsList(TestItems testItems);

    /**
     * 新增检验项目主
     * 
     * @param testItems 检验项目主
     * @return 结果
     */
    public int insertTestItems(TestItems testItems);

    /**
     * 修改检验项目主
     * 
     * @param testItems 检验项目主
     * @return 结果
     */
    public int updateTestItems(TestItems testItems);

    /**
     * 批量删除检验项目主
     * 
     * @param ids 需要删除的检验项目主主键集合
     * @return 结果
     */
    public int deleteTestItemsByIds(String ids);

    /**
     * 删除检验项目主信息
     * 
     * @param id 检验项目主主键
     * @return 结果
     */
    public int deleteTestItemsById(String id);
}
