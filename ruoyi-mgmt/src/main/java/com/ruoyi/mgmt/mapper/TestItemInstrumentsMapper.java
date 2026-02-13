package com.ruoyi.mgmt.mapper;

import java.util.List;
import com.ruoyi.mgmt.domain.TestItemInstruments;

/**
 * 检验项目与设备关联Mapper接口
 * 
 * @author zhuhoulin
 * @date 2026-01-19
 */
public interface TestItemInstrumentsMapper 
{
    /**
     * 查询检验项目与设备关联
     * 
     * @param id 检验项目与设备关联主键
     * @return 检验项目与设备关联
     */
    public TestItemInstruments selectTestItemInstrumentsById(String id);

    /**
     * 查询检验项目与设备关联列表
     * 
     * @param testItemInstruments 检验项目与设备关联
     * @return 检验项目与设备关联集合
     */
    public List<TestItemInstruments> selectTestItemInstrumentsList(TestItemInstruments testItemInstruments);

    /**
     * 新增检验项目与设备关联
     * 
     * @param testItemInstruments 检验项目与设备关联
     * @return 结果
     */
    public int insertTestItemInstruments(TestItemInstruments testItemInstruments);

    /**
     * 修改检验项目与设备关联
     * 
     * @param testItemInstruments 检验项目与设备关联
     * @return 结果
     */
    public int updateTestItemInstruments(TestItemInstruments testItemInstruments);

    /**
     * 删除检验项目与设备关联
     * 
     * @param id 检验项目与设备关联主键
     * @return 结果
     */
    public int deleteTestItemInstrumentsById(String id);

    /**
     * 批量删除检验项目与设备关联
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTestItemInstrumentsByIds(String[] ids);
}
