package com.ruoyi.mgmt.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.uuid.IdUtils;
import com.ruoyi.mgmt.domain.TestItemProductInfo;
import com.ruoyi.mgmt.mapper.TestItemProductInfoMapper;
import com.ruoyi.mgmt.service.ITestItemProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.core.text.Convert;

/**
 * 项目与产品关系Service业务层处理
 * 
 * @author zhuhoulin
 * @date 2026-01-20
 */
@Service
public class TestItemProductInfoServiceImpl implements ITestItemProductInfoService
{
    @Autowired
    private TestItemProductInfoMapper testItemProductInfoMapper;

    /**
     * 查询项目与产品关系
     * 
     * @param id 项目与产品关系主键
     * @return 项目与产品关系
     */
    @Override
    public TestItemProductInfo selectTestItemProductInfoById(String id)
    {
        return testItemProductInfoMapper.selectTestItemProductInfoById(id);
    }

    /**
     * 查询项目与产品关系列表
     * 
     * @param testItemProductInfo 项目与产品关系
     * @return 项目与产品关系
     */
    @Override
    public List<TestItemProductInfo> selectTestItemProductInfoList(TestItemProductInfo testItemProductInfo)
    {
        return testItemProductInfoMapper.selectTestItemProductInfoList(testItemProductInfo);
    }

    /**
     * 新增项目与产品关系
     * 
     * @param testItemProductInfo 项目与产品关系
     * @return 结果
     */
    @Override
    public int insertTestItemProductInfo(TestItemProductInfo testItemProductInfo)
    {
        testItemProductInfo.setId(IdUtils.fastSimpleUUID());
        testItemProductInfo.setCreateTime(DateUtils.getNowDate());
        return testItemProductInfoMapper.insertTestItemProductInfo(testItemProductInfo);
    }

    /**
     * 修改项目与产品关系
     * 
     * @param testItemProductInfo 项目与产品关系
     * @return 结果
     */
    @Override
    public int updateTestItemProductInfo(TestItemProductInfo testItemProductInfo)
    {
        testItemProductInfo.setUpdateTime(DateUtils.getNowDate());
        return testItemProductInfoMapper.updateTestItemProductInfo(testItemProductInfo);
    }

    /**
     * 批量删除项目与产品关系
     * 
     * @param ids 需要删除的项目与产品关系主键
     * @return 结果
     */
    @Override
    public int deleteTestItemProductInfoByIds(String ids)
    {
        return testItemProductInfoMapper.deleteTestItemProductInfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除项目与产品关系信息
     * 
     * @param id 项目与产品关系主键
     * @return 结果
     */
    @Override
    public int deleteTestItemProductInfoById(String id)
    {
        return testItemProductInfoMapper.deleteTestItemProductInfoById(id);
    }
}
