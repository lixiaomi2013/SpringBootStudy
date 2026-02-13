package com.ruoyi.mgmt.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 仪器设备主对象 t_mgmt_instruments
 * 
 * @author zhuhoulin
 * @date 2026-01-19
 */
public class Instruments extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private String instrumentId;

    /** 仪器编号 */
    @Excel(name = "仪器编号")
    private String instrumentCode;

    /** 制造商序列号 */
    @Excel(name = "制造商序列号")
    private String serialNumber;

    /** 仪器名称 */
    @Excel(name = "仪器名称")
    private String instrumentName;

    /** 型号 */
    @Excel(name = "型号")
    private String model;

    /** 规格参数 */
    @Excel(name = "规格参数")
    private String specification;

    /** 品牌 */
    @Excel(name = "品牌")
    private String brand;

    /** 分类名称 */
    @Excel(name = "分类名称")
    private String category;

    /** 购买日期 */
    @Excel(name = "购买日期")
    private String purchaseDate;

    /** 购买价格 */
    @Excel(name = "购买价格")
    private BigDecimal price;

    /** 供应商 */
    @Excel(name = "供应商")
    private String supplierId;

    /** 保修期(月) */
    @Excel(name = "保修期(月)")
    private Long warrantyPeriod;

    /** 存放位置 */
    @Excel(name = "存放位置")
    private String location;

    /** 状态 */
    @Excel(name = "状态")
    private String status;

    /** 删除标志 */
    private String delFlag;

    public void setInstrumentId(String instrumentId) 
    {
        this.instrumentId = instrumentId;
    }

    public String getInstrumentId() 
    {
        return instrumentId;
    }

    public void setInstrumentCode(String instrumentCode) 
    {
        this.instrumentCode = instrumentCode;
    }

    public String getInstrumentCode() 
    {
        return instrumentCode;
    }

    public void setSerialNumber(String serialNumber) 
    {
        this.serialNumber = serialNumber;
    }

    public String getSerialNumber() 
    {
        return serialNumber;
    }

    public void setInstrumentName(String instrumentName) 
    {
        this.instrumentName = instrumentName;
    }

    public String getInstrumentName() 
    {
        return instrumentName;
    }

    public void setModel(String model) 
    {
        this.model = model;
    }

    public String getModel() 
    {
        return model;
    }

    public void setSpecification(String specification) 
    {
        this.specification = specification;
    }

    public String getSpecification() 
    {
        return specification;
    }

    public void setBrand(String brand) 
    {
        this.brand = brand;
    }

    public String getBrand() 
    {
        return brand;
    }

    public void setCategory(String category) 
    {
        this.category = category;
    }

    public String getCategory() 
    {
        return category;
    }

    public void setPurchaseDate(String purchaseDate) 
    {
        this.purchaseDate = purchaseDate;
    }

    public String getPurchaseDate() 
    {
        return purchaseDate;
    }

    public void setPrice(BigDecimal price) 
    {
        this.price = price;
    }

    public BigDecimal getPrice() 
    {
        return price;
    }

    public void setSupplierId(String supplierId) 
    {
        this.supplierId = supplierId;
    }

    public String getSupplierId() 
    {
        return supplierId;
    }

    public void setWarrantyPeriod(Long warrantyPeriod) 
    {
        this.warrantyPeriod = warrantyPeriod;
    }

    public Long getWarrantyPeriod() 
    {
        return warrantyPeriod;
    }

    public void setLocation(String location) 
    {
        this.location = location;
    }

    public String getLocation() 
    {
        return location;
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
            .append("instrumentId", getInstrumentId())
            .append("instrumentCode", getInstrumentCode())
            .append("serialNumber", getSerialNumber())
            .append("instrumentName", getInstrumentName())
            .append("model", getModel())
            .append("specification", getSpecification())
            .append("brand", getBrand())
            .append("category", getCategory())
            .append("purchaseDate", getPurchaseDate())
            .append("price", getPrice())
            .append("supplierId", getSupplierId())
            .append("warrantyPeriod", getWarrantyPeriod())
            .append("location", getLocation())
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
