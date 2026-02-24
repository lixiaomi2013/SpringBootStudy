package com.ruoyi.mgmt.mapper;

import java.util.List;
import com.ruoyi.mgmt.domain.TestItemInstrumentProductInfoView;

/**
 * 仪器项目产品信息Mapper接口
 * 
 * @author zhuhoulin
 * @date 2026-02-24
 */
public interface TestItemInstrumentProductInfoViewMapper 
{
    /**
     * 查询仪器项目产品信息
     * 
     * @param instrumentCode 仪器项目产品信息主键
     * @return 仪器项目产品信息
     */
    public TestItemInstrumentProductInfoView selectTestItemInstrumentProductInfoViewByInstrumentCode(String instrumentCode);

    /**
     * 查询仪器项目产品信息列表
     * 
     * @param testItemInstrumentProductInfoView 仪器项目产品信息
     * @return 仪器项目产品信息集合
     */
    public List<TestItemInstrumentProductInfoView> selectTestItemInstrumentProductInfoViewList(TestItemInstrumentProductInfoView testItemInstrumentProductInfoView);

    /**
     * 新增仪器项目产品信息
     * 
     * @param testItemInstrumentProductInfoView 仪器项目产品信息
     * @return 结果
     */
    public int insertTestItemInstrumentProductInfoView(TestItemInstrumentProductInfoView testItemInstrumentProductInfoView);

    /**
     * 修改仪器项目产品信息
     * 
     * @param testItemInstrumentProductInfoView 仪器项目产品信息
     * @return 结果
     */
    public int updateTestItemInstrumentProductInfoView(TestItemInstrumentProductInfoView testItemInstrumentProductInfoView);

    /**
     * 删除仪器项目产品信息
     * 
     * @param instrumentCode 仪器项目产品信息主键
     * @return 结果
     */
    public int deleteTestItemInstrumentProductInfoViewByInstrumentCode(String instrumentCode);

    /**
     * 批量删除仪器项目产品信息
     * 
     * @param instrumentCodes 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTestItemInstrumentProductInfoViewByInstrumentCodes(String[] instrumentCodes);
}
