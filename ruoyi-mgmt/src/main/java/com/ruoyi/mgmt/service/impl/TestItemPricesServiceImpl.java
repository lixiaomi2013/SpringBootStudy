package com.ruoyi.mgmt.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.uuid.IdUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.mgmt.mapper.TestItemPricesMapper;
import com.ruoyi.mgmt.domain.TestItemPrices;
import com.ruoyi.mgmt.service.ITestItemPricesService;
import com.ruoyi.common.core.text.Convert;

/**
 * 检验项目价格Service业务层处理
 * 
 * @author zhuhoulin
 * @date 2026-01-03
 */
@Service
public class TestItemPricesServiceImpl implements ITestItemPricesService 
{
    @Autowired
    private TestItemPricesMapper testItemPricesMapper;

    /**
     * 查询检验项目价格
     * 
     * @param id 检验项目价格主键
     * @return 检验项目价格
     */
    @Override
    public TestItemPrices selectTestItemPricesById(String id)
    {
        return testItemPricesMapper.selectTestItemPricesById(id);
    }

    /**
     * 查询检验项目价格列表
     * 
     * @param testItemPrices 检验项目价格
     * @return 检验项目价格
     */
    @Override
    public List<TestItemPrices> selectTestItemPricesList(TestItemPrices testItemPrices)
    {
        return testItemPricesMapper.selectTestItemPricesList(testItemPrices);
    }

    /**
     * 新增检验项目价格
     * 
     * @param testItemPrices 检验项目价格
     * @return 结果
     */
    @Override
    public int insertTestItemPrices(TestItemPrices testItemPrices)
    {
        testItemPrices.setCreateTime(DateUtils.getNowDate());
        testItemPrices.setId(IdUtils.fastSimpleUUID());
        return testItemPricesMapper.insertTestItemPrices(testItemPrices);
    }

    /**
     * 修改检验项目价格
     * 
     * @param testItemPrices 检验项目价格
     * @return 结果
     */
    @Override
    public int updateTestItemPrices(TestItemPrices testItemPrices)
    {
        testItemPrices.setUpdateTime(DateUtils.getNowDate());
        return testItemPricesMapper.updateTestItemPrices(testItemPrices);
    }

    /**
     * 批量删除检验项目价格
     * 
     * @param ids 需要删除的检验项目价格主键
     * @return 结果
     */
    @Override
    public int deleteTestItemPricesByIds(String ids)
    {
        return testItemPricesMapper.deleteTestItemPricesByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除检验项目价格信息
     * 
     * @param id 检验项目价格主键
     * @return 结果
     */
    @Override
    public int deleteTestItemPricesById(String id)
    {
        return testItemPricesMapper.deleteTestItemPricesById(id);
    }
}
