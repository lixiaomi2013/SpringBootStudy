package com.ruoyi.mgmt.mapper;

import java.util.List;
import com.ruoyi.mgmt.domain.Instruments;

/**
 * 仪器设备主Mapper接口
 * 
 * @author zhuhoulin
 * @date 2026-01-19
 */
public interface InstrumentsMapper 
{
    /**
     * 查询仪器设备主
     * 
     * @param instrumentId 仪器设备主主键
     * @return 仪器设备主
     */
    public Instruments selectInstrumentsByInstrumentId(String instrumentId);

    /**
     * 查询仪器设备主列表
     * 
     * @param instruments 仪器设备主
     * @return 仪器设备主集合
     */
    public List<Instruments> selectInstrumentsList(Instruments instruments);

    /**
     * 新增仪器设备主
     * 
     * @param instruments 仪器设备主
     * @return 结果
     */
    public int insertInstruments(Instruments instruments);

    /**
     * 修改仪器设备主
     * 
     * @param instruments 仪器设备主
     * @return 结果
     */
    public int updateInstruments(Instruments instruments);

    /**
     * 删除仪器设备主
     * 
     * @param instrumentId 仪器设备主主键
     * @return 结果
     */
    public int deleteInstrumentsByInstrumentId(String instrumentId);

    /**
     * 批量删除仪器设备主
     * 
     * @param instrumentIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteInstrumentsByInstrumentIds(String[] instrumentIds);
}
