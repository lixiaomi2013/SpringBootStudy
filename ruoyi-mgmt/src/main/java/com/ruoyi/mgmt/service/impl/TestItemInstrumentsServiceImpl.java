package com.ruoyi.mgmt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.uuid.IdUtils;
import com.ruoyi.mgmt.domain.TestItemInstruments;
import com.ruoyi.mgmt.mapper.TestItemInstrumentsMapper;
import com.ruoyi.mgmt.service.ITestItemInstrumentsService;

/**
 * 检验项目与设备关联Service业务层处理
 * 
 * @author zhuhoulin
 * @date 2026-01-19
 */
@Service
public class TestItemInstrumentsServiceImpl implements ITestItemInstrumentsService 
{
    @Autowired
    private TestItemInstrumentsMapper testItemInstrumentsMapper;

    /**
     * 查询检验项目与设备关联
     * 
     * @param id 检验项目与设备关联主键
     * @return 检验项目与设备关联
     */
    @Override
    public TestItemInstruments selectTestItemInstrumentsById(String id)
    {
        return testItemInstrumentsMapper.selectTestItemInstrumentsById(id);
    }

    /**
     * 查询检验项目与设备关联列表
     * 
     * @param testItemInstruments 检验项目与设备关联
     * @return 检验项目与设备关联
     */
    @Override
    public List<TestItemInstruments> selectTestItemInstrumentsList(TestItemInstruments testItemInstruments)
    {
        return testItemInstrumentsMapper.selectTestItemInstrumentsList(testItemInstruments);
    }

    /**
     * 新增检验项目与设备关联
     * 
     * @param testItemInstruments 检验项目与设备关联
     * @return 结果
     */
    @Override
    public int insertTestItemInstruments(TestItemInstruments testItemInstruments)
    {
        testItemInstruments.setCreateTime(DateUtils.getNowDate());
        testItemInstruments.setId(IdUtils.fastSimpleUUID());
        return testItemInstrumentsMapper.insertTestItemInstruments(testItemInstruments);
    }

    /**
     * 修改检验项目与设备关联
     * 
     * @param testItemInstruments 检验项目与设备关联
     * @return 结果
     */
    @Override
    public int updateTestItemInstruments(TestItemInstruments testItemInstruments)
    {
        testItemInstruments.setUpdateTime(DateUtils.getNowDate());
        return testItemInstrumentsMapper.updateTestItemInstruments(testItemInstruments);
    }

    /**
     * 批量删除检验项目与设备关联
     * 
     * @param ids 需要删除的检验项目与设备关联主键
     * @return 结果
     */
    @Override
    public int deleteTestItemInstrumentsByIds(String ids)
    {
        return testItemInstrumentsMapper.deleteTestItemInstrumentsByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除检验项目与设备关联信息
     * 
     * @param id 检验项目与设备关联主键
     * @return 结果
     */
    @Override
    public int deleteTestItemInstrumentsById(String id)
    {
        return testItemInstrumentsMapper.deleteTestItemInstrumentsById(id);
    }
}
