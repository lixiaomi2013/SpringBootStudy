package com.ruoyi.mgmt.mapper;

import java.util.List;
import com.ruoyi.mgmt.domain.TestItems;

/**
 * 检验项目主Mapper接口
 * 
 * @author zhuhoulin
 * @date 2026-01-03
 */
public interface TestItemsMapper 
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
     * 删除检验项目主
     * 
     * @param id 检验项目主主键
     * @return 结果
     */
    public int deleteTestItemsById(String id);

    /**
     * 批量删除检验项目主
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTestItemsByIds(String[] ids);
}
