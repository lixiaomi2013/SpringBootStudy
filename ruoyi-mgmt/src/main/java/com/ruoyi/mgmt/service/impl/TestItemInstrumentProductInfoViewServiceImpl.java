package com.ruoyi.mgmt.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.uuid.IdUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.mgmt.mapper.TestItemInstrumentProductInfoViewMapper;
import com.ruoyi.mgmt.domain.TestItemInstrumentProductInfoView;
import com.ruoyi.mgmt.service.ITestItemInstrumentProductInfoViewService;
import com.ruoyi.common.core.text.Convert;

/**
 * 仪器项目产品信息Service业务层处理
 * 
 * @author zhuhoulin
 * @date 2026-02-24
 */
@Service
public class TestItemInstrumentProductInfoViewServiceImpl implements ITestItemInstrumentProductInfoViewService 
{
    @Autowired
    private TestItemInstrumentProductInfoViewMapper testItemInstrumentProductInfoViewMapper;

    /**
     * 查询仪器项目产品信息
     * 
     * @param instrumentCode 仪器项目产品信息主键
     * @return 仪器项目产品信息
     */
    @Override
    public TestItemInstrumentProductInfoView selectTestItemInstrumentProductInfoViewByInstrumentCode(String instrumentCode)
    {
        return testItemInstrumentProductInfoViewMapper.selectTestItemInstrumentProductInfoViewByInstrumentCode(instrumentCode);
    }

    /**
     * 查询仪器项目产品信息列表
     * 
     * @param testItemInstrumentProductInfoView 仪器项目产品信息
     * @return 仪器项目产品信息
     */
    @Override
    public List<TestItemInstrumentProductInfoView> selectTestItemInstrumentProductInfoViewList(TestItemInstrumentProductInfoView testItemInstrumentProductInfoView)
    {
        return testItemInstrumentProductInfoViewMapper.selectTestItemInstrumentProductInfoViewList(testItemInstrumentProductInfoView);
    }

    /**
     * 新增仪器项目产品信息
     * 
     * @param testItemInstrumentProductInfoView 仪器项目产品信息
     * @return 结果
     */
    @Override
    public int insertTestItemInstrumentProductInfoView(TestItemInstrumentProductInfoView testItemInstrumentProductInfoView)
    {
        testItemInstrumentProductInfoView.setInstrumentCode(IdUtils.fastSimpleUUID());
        testItemInstrumentProductInfoView.setCreateTime(DateUtils.getNowDate());
        return testItemInstrumentProductInfoViewMapper.insertTestItemInstrumentProductInfoView(testItemInstrumentProductInfoView);
    }

    /**
     * 修改仪器项目产品信息
     * 
     * @param testItemInstrumentProductInfoView 仪器项目产品信息
     * @return 结果
     */
    @Override
    public int updateTestItemInstrumentProductInfoView(TestItemInstrumentProductInfoView testItemInstrumentProductInfoView)
    {
        testItemInstrumentProductInfoView.setUpdateTime(DateUtils.getNowDate());
        return testItemInstrumentProductInfoViewMapper.updateTestItemInstrumentProductInfoView(testItemInstrumentProductInfoView);
    }

    /**
     * 批量删除仪器项目产品信息
     * 
     * @param instrumentCodes 需要删除的仪器项目产品信息主键
     * @return 结果
     */
    @Override
    public int deleteTestItemInstrumentProductInfoViewByInstrumentCodes(String instrumentCodes)
    {
        return testItemInstrumentProductInfoViewMapper.deleteTestItemInstrumentProductInfoViewByInstrumentCodes(Convert.toStrArray(instrumentCodes));
    }

    /**
     * 删除仪器项目产品信息信息
     * 
     * @param instrumentCode 仪器项目产品信息主键
     * @return 结果
     */
    @Override
    public int deleteTestItemInstrumentProductInfoViewByInstrumentCode(String instrumentCode)
    {
        return testItemInstrumentProductInfoViewMapper.deleteTestItemInstrumentProductInfoViewByInstrumentCode(instrumentCode);
    }
}
