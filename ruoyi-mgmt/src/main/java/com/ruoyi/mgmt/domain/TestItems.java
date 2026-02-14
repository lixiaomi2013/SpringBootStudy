package com.ruoyi.mgmt.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 检验项目信息对象 t_mgmt_test_items
 * 
 * @author zhuhoulin
 * @date 2026-02-14
 */
public class TestItems extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private String testItemId;

    /** 检验项目代码 */
    @Excel(name = "检验项目代码")
    private String testItemCode;

    /** 检验项目名称 */
    @Excel(name = "检验项目名称")
    private String testItemName;

    /** 报告单显示名称 */
    @Excel(name = "报告单显示名称")
    private String reportName;

    /** 检验类型 */
    @Excel(name = "检验类型")
    private String testTypeId;

    /** 大类 */
    @Excel(name = "大类")
    private String testCategory;

    /** 样本类型 */
    @Excel(name = "样本类型")
    private String sampleType;

    /** 样本量 */
    @Excel(name = "样本量")
    private BigDecimal sampleVolume;

    /** 样本容器 */
    @Excel(name = "样本容器")
    private String sampleContainer;

    /** 临床意义 */
    @Excel(name = "临床意义")
    private String clinicalSignificance;

    /** 参考范围 */
    @Excel(name = "参考范围")
    private String referenceRange;

    /** 单位 */
    @Excel(name = "单位")
    private String unit;

    /** 报告时间 */
    @Excel(name = "报告时间")
    private Long turnaroundTime;

    /** 状态 */
    @Excel(name = "状态")
    private String status;

    /** 删除标志 */
    private String delFlag;

    public void setTestItemId(String testItemId) 
    {
        this.testItemId = testItemId;
    }

    public String getTestItemId() 
    {
        return testItemId;
    }

    public void setTestItemCode(String testItemCode) 
    {
        this.testItemCode = testItemCode;
    }

    public String getTestItemCode() 
    {
        return testItemCode;
    }

    public void setTestItemName(String testItemName) 
    {
        this.testItemName = testItemName;
    }

    public String getTestItemName() 
    {
        return testItemName;
    }

    public void setReportName(String reportName) 
    {
        this.reportName = reportName;
    }

    public String getReportName() 
    {
        return reportName;
    }

    public void setTestTypeId(String testTypeId) 
    {
        this.testTypeId = testTypeId;
    }

    public String getTestTypeId() 
    {
        return testTypeId;
    }

    public void setTestCategory(String testCategory) 
    {
        this.testCategory = testCategory;
    }

    public String getTestCategory() 
    {
        return testCategory;
    }

    public void setSampleType(String sampleType) 
    {
        this.sampleType = sampleType;
    }

    public String getSampleType() 
    {
        return sampleType;
    }

    public void setSampleVolume(BigDecimal sampleVolume) 
    {
        this.sampleVolume = sampleVolume;
    }

    public BigDecimal getSampleVolume() 
    {
        return sampleVolume;
    }

    public void setSampleContainer(String sampleContainer) 
    {
        this.sampleContainer = sampleContainer;
    }

    public String getSampleContainer() 
    {
        return sampleContainer;
    }

    public void setClinicalSignificance(String clinicalSignificance) 
    {
        this.clinicalSignificance = clinicalSignificance;
    }

    public String getClinicalSignificance() 
    {
        return clinicalSignificance;
    }

    public void setReferenceRange(String referenceRange) 
    {
        this.referenceRange = referenceRange;
    }

    public String getReferenceRange() 
    {
        return referenceRange;
    }

    public void setUnit(String unit) 
    {
        this.unit = unit;
    }

    public String getUnit() 
    {
        return unit;
    }

    public void setTurnaroundTime(Long turnaroundTime) 
    {
        this.turnaroundTime = turnaroundTime;
    }

    public Long getTurnaroundTime() 
    {
        return turnaroundTime;
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
            .append("testItemId", getTestItemId())
            .append("testItemCode", getTestItemCode())
            .append("testItemName", getTestItemName())
            .append("reportName", getReportName())
            .append("testTypeId", getTestTypeId())
            .append("testCategory", getTestCategory())
            .append("sampleType", getSampleType())
            .append("sampleVolume", getSampleVolume())
            .append("sampleContainer", getSampleContainer())
            .append("clinicalSignificance", getClinicalSignificance())
            .append("referenceRange", getReferenceRange())
            .append("unit", getUnit())
            .append("turnaroundTime", getTurnaroundTime())
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
