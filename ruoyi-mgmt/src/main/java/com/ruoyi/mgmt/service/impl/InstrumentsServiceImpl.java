package com.ruoyi.mgmt.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.uuid.IdUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.mgmt.mapper.InstrumentsMapper;
import com.ruoyi.mgmt.domain.Instruments;
import com.ruoyi.mgmt.service.IInstrumentsService;
import com.ruoyi.common.core.text.Convert;

/**
 * 仪器设备主Service业务层处理
 * 
 * @author zhuhoulin
 * @date 2026-01-19
 */
@Service
public class InstrumentsServiceImpl implements IInstrumentsService 
{
    @Autowired
    private InstrumentsMapper instrumentsMapper;

    /**
     * 查询仪器设备主
     * 
     * @param instrumentId 仪器设备主主键
     * @return 仪器设备主
     */
    @Override
    public Instruments selectInstrumentsByInstrumentId(String instrumentId)
    {
        return instrumentsMapper.selectInstrumentsByInstrumentId(instrumentId);
    }

    /**
     * 查询仪器设备主列表
     * 
     * @param instruments 仪器设备主
     * @return 仪器设备主
     */
    @Override
    public List<Instruments> selectInstrumentsList(Instruments instruments)
    {
        return instrumentsMapper.selectInstrumentsList(instruments);
    }

    /**
     * 新增仪器设备主
     * 
     * @param instruments 仪器设备主
     * @return 结果
     */
    @Override
    public int insertInstruments(Instruments instruments)
    {
        instruments.setCreateTime(DateUtils.getNowDate());
        instruments.setInstrumentId(IdUtils.fastSimpleUUID());
        return instrumentsMapper.insertInstruments(instruments);
    }

    /**
     * 修改仪器设备主
     * 
     * @param instruments 仪器设备主
     * @return 结果
     */
    @Override
    public int updateInstruments(Instruments instruments)
    {
        instruments.setUpdateTime(DateUtils.getNowDate());
        return instrumentsMapper.updateInstruments(instruments);
    }

    /**
     * 批量删除仪器设备主
     * 
     * @param instrumentIds 需要删除的仪器设备主主键
     * @return 结果
     */
    @Override
    public int deleteInstrumentsByInstrumentIds(String instrumentIds)
    {
        return instrumentsMapper.deleteInstrumentsByInstrumentIds(Convert.toStrArray(instrumentIds));
    }

    /**
     * 删除仪器设备主信息
     * 
     * @param instrumentId 仪器设备主主键
     * @return 结果
     */
    @Override
    public int deleteInstrumentsByInstrumentId(String instrumentId)
    {
        return instrumentsMapper.deleteInstrumentsByInstrumentId(instrumentId);
    }
}
