package com.ruoyi.mgmt.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.uuid.IdUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.mgmt.mapper.TestItemsMapper;
import com.ruoyi.mgmt.domain.TestItems;
import com.ruoyi.mgmt.service.ITestItemsService;
import com.ruoyi.common.core.text.Convert;

/**
 * 检验项目主Service业务层处理
 * 
 * @author zhuhoulin
 * @date 2026-01-03
 */
@Service
public class TestItemsServiceImpl implements ITestItemsService 
{
    @Autowired
    private TestItemsMapper testItemsMapper;

    /**
     * 查询检验项目主
     * 
     * @param id 检验项目主主键
     * @return 检验项目主
     */
    @Override
    public TestItems selectTestItemsById(String id)
    {
        return testItemsMapper.selectTestItemsById(id);
    }

    /**
     * 查询检验项目主列表
     * 
     * @param testItems 检验项目主
     * @return 检验项目主
     */
    @Override
    public List<TestItems> selectTestItemsList(TestItems testItems)
    {
        return testItemsMapper.selectTestItemsList(testItems);
    }

    /**
     * 新增检验项目主
     * 
     * @param testItems 检验项目主
     * @return 结果
     */
    @Override
    public int insertTestItems(TestItems testItems)
    {
        testItems.setCreateTime(DateUtils.getNowDate());
        testItems.setId(IdUtils.fastSimpleUUID());
        return testItemsMapper.insertTestItems(testItems);
    }

    /**
     * 修改检验项目主
     * 
     * @param testItems 检验项目主
     * @return 结果
     */
    @Override
    public int updateTestItems(TestItems testItems)
    {
        testItems.setUpdateTime(DateUtils.getNowDate());
        return testItemsMapper.updateTestItems(testItems);
    }

    /**
     * 批量删除检验项目主
     * 
     * @param ids 需要删除的检验项目主主键
     * @return 结果
     */
    @Override
    public int deleteTestItemsByIds(String ids)
    {
        return testItemsMapper.deleteTestItemsByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除检验项目主信息
     * 
     * @param id 检验项目主主键
     * @return 结果
     */
    @Override
    public int deleteTestItemsById(String id)
    {
        return testItemsMapper.deleteTestItemsById(id);
    }
}
