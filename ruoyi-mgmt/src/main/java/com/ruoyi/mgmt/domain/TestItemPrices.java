package com.ruoyi.mgmt.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 检验项目价格对象 t_mgmt_test_item_prices
 * 
 * @author zhuhoulin
 * @date 2026-01-03
 */
public class TestItemPrices extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private String id;

    /** 检验项目 */
    @Excel(name = "检验项目")
    private String testItemId;

    /** 价格（元） */
    @Excel(name = "价格", readConverterExp = "元=")
    private BigDecimal price;

    /** 币种 */
    @Excel(name = "币种")
    private String currency;

    /** 价格类型 */
    @Excel(name = "价格类型")
    private String priceType;

    /** 客户类型 */
    @Excel(name = "客户类型")
    private String clientType;

    /** 生效日期 */
    @Excel(name = "生效日期")
    private String effectiveDate;

    /** 失效日期 */
    @Excel(name = "失效日期")
    private String expiryDate;

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

    public void setPrice(BigDecimal price) 
    {
        this.price = price;
    }

    public BigDecimal getPrice() 
    {
        return price;
    }

    public void setCurrency(String currency) 
    {
        this.currency = currency;
    }

    public String getCurrency() 
    {
        return currency;
    }

    public void setPriceType(String priceType) 
    {
        this.priceType = priceType;
    }

    public String getPriceType() 
    {
        return priceType;
    }

    public void setClientType(String clientType) 
    {
        this.clientType = clientType;
    }

    public String getClientType() 
    {
        return clientType;
    }

    public void setEffectiveDate(String effectiveDate) 
    {
        this.effectiveDate = effectiveDate;
    }

    public String getEffectiveDate() 
    {
        return effectiveDate;
    }

    public void setExpiryDate(String expiryDate) 
    {
        this.expiryDate = expiryDate;
    }

    public String getExpiryDate() 
    {
        return expiryDate;
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
            .append("price", getPrice())
            .append("currency", getCurrency())
            .append("priceType", getPriceType())
            .append("clientType", getClientType())
            .append("effectiveDate", getEffectiveDate())
            .append("expiryDate", getExpiryDate())
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
