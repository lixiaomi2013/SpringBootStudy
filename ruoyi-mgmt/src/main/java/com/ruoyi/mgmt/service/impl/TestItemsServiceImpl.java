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
 * 检验项目信息Service业务层处理
 * 
 * @author zhuhoulin
 * @date 2026-02-14
 */
@Service
public class TestItemsServiceImpl implements ITestItemsService 
{
    @Autowired
    private TestItemsMapper testItemsMapper;

    /**
     * 查询检验项目信息
     * 
     * @param testItemId 检验项目信息主键
     * @return 检验项目信息
     */
    @Override
    public TestItems selectTestItemsByTestItemId(String testItemId)
    {
        return testItemsMapper.selectTestItemsByTestItemId(testItemId);
    }

    /**
     * 查询检验项目信息列表
     * 
     * @param testItems 检验项目信息
     * @return 检验项目信息
     */
    @Override
    public List<TestItems> selectTestItemsList(TestItems testItems)
    {
        return testItemsMapper.selectTestItemsList(testItems);
    }

    /**
     * 新增检验项目信息
     * 
     * @param testItems 检验项目信息
     * @return 结果
     */
    @Override
    public int insertTestItems(TestItems testItems)
    {
        testItems.setTestItemId(IdUtils.fastSimpleUUID());
        testItems.setCreateTime(DateUtils.getNowDate());
        return testItemsMapper.insertTestItems(testItems);
    }

    /**
     * 修改检验项目信息
     * 
     * @param testItems 检验项目信息
     * @return 结果
     */
    @Override
    public int updateTestItems(TestItems testItems)
    {
        testItems.setUpdateTime(DateUtils.getNowDate());
        return testItemsMapper.updateTestItems(testItems);
    }

    /**
     * 批量删除检验项目信息
     * 
     * @param testItemIds 需要删除的检验项目信息主键
     * @return 结果
     */
    @Override
    public int deleteTestItemsByTestItemIds(String testItemIds)
    {
        return testItemsMapper.deleteTestItemsByTestItemIds(Convert.toStrArray(testItemIds));
    }

    /**
     * 删除检验项目信息信息
     * 
     * @param testItemId 检验项目信息主键
     * @return 结果
     */
    @Override
    public int deleteTestItemsByTestItemId(String testItemId)
    {
        return testItemsMapper.deleteTestItemsByTestItemId(testItemId);
    }
}
