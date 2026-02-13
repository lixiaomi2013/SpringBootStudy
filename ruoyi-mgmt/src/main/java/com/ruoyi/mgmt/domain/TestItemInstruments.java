package com.ruoyi.mgmt.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 检验项目与设备关联对象 t_mgmt_test_item_instruments
 * 
 * @author zhuhoulin
 * @date 2026-01-19
 */
public class TestItemInstruments extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private String id;

    /** 项目ID */
    @Excel(name = "项目ID")
    private String testItemId;

    /** 项目名称 */
    @Excel(name = "项目名称")
    private String testItemName;

    /** 设备ID */
    @Excel(name = "设备ID")
    private String instrumentId;

    /** 设备名称 */
    @Excel(name = "设备名称")
    private String instrumentName;

    /** 样本类型 */
    @Excel(name = "样本类型")
    private String sampleType;

    /** 价格（元） */
    @Excel(name = "价格", readConverterExp = "元=")
    private BigDecimal price;

    /** 是否为主要检测设备 */
    @Excel(name = "是否为主要检测设备")
    private String isPrimary;

    /** 是否为默认设备 */
    @Excel(name = "是否为默认设备")
    private String isDefault;

    /** 排序 */
    @Excel(name = "排序")
    private Long sortOrder;

    /** 状态 */
    @Excel(name = "状态")
    private String status;

    /** 删除标志 */
    private String delFlag;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }

    public void setTestItemId(String testItemId) 
    {
        this.testItemId = testItemId;
    }

    public String getTestItemId() 
    {
        return testItemId;
    }

    public void setTestItemName(String testItemName) 
    {
        this.testItemName = testItemName;
    }

    public String getTestItemName() 
    {
        return testItemName;
    }

    public void setInstrumentId(String instrumentId) 
    {
        this.instrumentId = instrumentId;
    }

    public String getInstrumentId() 
    {
        return instrumentId;
    }

    public void setInstrumentName(String instrumentName) 
    {
        this.instrumentName = instrumentName;
    }

    public String getInstrumentName() 
    {
        return instrumentName;
    }

    public void setSampleType(String sampleType) 
    {
        this.sampleType = sampleType;
    }

    public String getSampleType() 
    {
        return sampleType;
    }

    public void setPrice(BigDecimal price) 
    {
        this.price = price;
    }

    public BigDecimal getPrice() 
    {
        return price;
    }

    public void setIsPrimary(String isPrimary) 
    {
        this.isPrimary = isPrimary;
    }

    public String getIsPrimary() 
    {
        return isPrimary;
    }

    public void setIsDefault(String isDefault) 
    {
        this.isDefault = isDefault;
    }

    public String getIsDefault() 
    {
        return isDefault;
    }

    public void setSortOrder(Long sortOrder) 
    {
        this.sortOrder = sortOrder;
    }

    public Long getSortOrder() 
    {
        return sortOrder;
    }

    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    public void setDelFlag(String delFlag) 
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag() 
    {
        return delFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("testItemId", getTestItemId())
            .append("testItemName", getTestItemName())
            .append("instrumentId", getInstrumentId())
            .append("instrumentName", getInstrumentName())
            .append("sampleType", getSampleType())
            .append("price", getPrice())
            .append("isPrimary", getIsPrimary())
            .append("isDefault", getIsDefault())
            .append("sortOrder", getSortOrder())
            .append("status", getStatus())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
