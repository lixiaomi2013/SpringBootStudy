package com.ruoyi.mgmt.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 项目与产品关系对象 t_mgmt_test_item_product_info
 * 
 * @author zhuhoulin
 * @date 2026-01-20
 */
public class TestItemProductInfo extends BaseEntity
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

    /** 产品ID */
    @Excel(name = "产品ID")
    private String productId;

    /** 产品编号 */
    @Excel(name = "产品编号")
    private String productCode;

    /** 产品名称 */
    @Excel(name = "产品名称")
    private String productName;

    /** 样本类型 */
    @Excel(name = "样本类型")
    private String sampleType;

    /** 价格（元） */
    @Excel(name = "价格", readConverterExp = "元=")
    private BigDecimal price;

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

    public void setProductId(String productId) 
    {
        this.productId = productId;
    }

    public String getProductId() 
    {
        return productId;
    }

    public void setProductCode(String productCode) 
    {
        this.productCode = productCode;
    }

    public String getProductCode() 
    {
        return productCode;
    }

    public void setProductName(String productName) 
    {
        this.productName = productName;
    }

    public String getProductName() 
    {
        return productName;
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
            .append("productId", getProductId())
            .append("productCode", getProductCode())
            .append("productName", getProductName())
            .append("sampleType", getSampleType())
            .append("price", getPrice())
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
