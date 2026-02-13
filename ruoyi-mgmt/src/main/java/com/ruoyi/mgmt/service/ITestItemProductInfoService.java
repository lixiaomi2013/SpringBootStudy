package com.ruoyi.mgmt.service;

import java.util.List;

import com.ruoyi.mgmt.domain.TestItemProductInfo;

/**
 * 项目与产品关系Service接口
 * 
 * @author zhuhoulin
 * @date 2026-01-20
 */
public interface ITestItemProductInfoService 
{
    /**
     * 查询项目与产品关系
     * 
     * @param id 项目与产品关系主键
     * @return 项目与产品关系
     */
    public TestItemProductInfo selectTestItemProductInfoById(String id);

    /**
     * 查询项目与产品关系列表
     * 
     * @param testItemProductInfo 项目与产品关系
     * @return 项目与产品关系集合
     */
    public List<TestItemProductInfo> selectTestItemProductInfoList(TestItemProductInfo testItemProductInfo);

    /**
     * 新增项目与产品关系
     * 
     * @param testItemProductInfo 项目与产品关系
     * @return 结果
     */
    public int insertTestItemProductInfo(TestItemProductInfo testItemProductInfo);

    /**
     * 修改项目与产品关系
     * 
     * @param testItemProductInfo 项目与产品关系
     * @return 结果
     */
    public int updateTestItemProductInfo(TestItemProductInfo testItemProductInfo);

    /**
     * 批量删除项目与产品关系
     * 
     * @param ids 需要删除的项目与产品关系主键集合
     * @return 结果
     */
    public int deleteTestItemProductInfoByIds(String ids);

    /**
     * 删除项目与产品关系信息
     * 
     * @param id 项目与产品关系主键
     * @return 结果
     */
    public int deleteTestItemProductInfoById(String id);
}
