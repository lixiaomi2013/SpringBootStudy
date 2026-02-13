package com.ruoyi.mgmt.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 进货明细对象 t_mgmt_purchase_detail
 * 
 * @author zhuhoulin
 * @date 2026-01-05
 */
public class PurchaseDetail extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    private String detailId;

    /** 进货单ID */
    @Excel(name = "进货单ID")
    private String purchaseId;

    /** 产品ID */
    @Excel(name = "产品ID")
    private String productId;

    /** 批次号 */
    @Excel(name = "批次号")
    private String batchNo;

    /** 采购数量 */
    @Excel(name = "采购数量")
    private Long purchaseQuantity;

    /** 已入库数量 */
    @Excel(name = "已入库数量")
    private Long receivedQuantity;

    /** 采购单价 */
    @Excel(name = "采购单价")
    private BigDecimal unitPrice;

    /** 采购日期 */
    @Excel(name = "采购日期")
    private String purchaseDate;

    /** 预计到货日期 */
    @Excel(name = "预计到货日期")
    private String expectedDate;

    /** 实际到货日期 */
    @Excel(name = "实际到货日期")
    private String actualDate;

    /** 税率 */
    @Excel(name = "税率")
    private BigDecimal taxRate;

    /** 金额 */
    @Excel(name = "金额")
    private BigDecimal amount;

    /** 生产日期 */
    @Excel(name = "生产日期")
    private String productionDate;

    /** 有效期 */
    @Excel(name = "有效期")
    private String expiryDate;

    /** 导入文件名称 */
    @Excel(name = "导入文件名称")
    private String fileName;

    /** 状态 */
    @Excel(name = "状态")
    private String status;

    /** 删除标志 */
    private String delFlag;

    public void setDetailId(String detailId) 
    {
        this.detailId = detailId;
    }

    public String getDetailId() 
    {
        return detailId;
    }

    public void setPurchaseId(String purchaseId) 
    {
        this.purchaseId = purchaseId;
    }

    public String getPurchaseId() 
    {
        return purchaseId;
    }

    public void setProductId(String productId) 
    {
        this.productId = productId;
    }

    public String getProductId() 
    {
        return productId;
    }

    public void setBatchNo(String batchNo) 
    {
        this.batchNo = batchNo;
    }

    public String getBatchNo() 
    {
        return batchNo;
    }

    public void setPurchaseQuantity(Long purchaseQuantity) 
    {
        this.purchaseQuantity = purchaseQuantity;
    }

    public Long getPurchaseQuantity() 
    {
        return purchaseQuantity;
    }

    public void setReceivedQuantity(Long receivedQuantity) 
    {
        this.receivedQuantity = receivedQuantity;
    }

    public Long getReceivedQuantity() 
    {
        return receivedQuantity;
    }

    public void setUnitPrice(BigDecimal unitPrice) 
    {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getUnitPrice() 
    {
        return unitPrice;
    }

    public void setPurchaseDate(String purchaseDate) 
    {
        this.purchaseDate = purchaseDate;
    }

    public String getPurchaseDate() 
    {
        return purchaseDate;
    }

    public void setExpectedDate(String expectedDate) 
    {
        this.expectedDate = expectedDate;
    }

    public String getExpectedDate() 
    {
        return expectedDate;
    }

    public void setActualDate(String actualDate) 
    {
        this.actualDate = actualDate;
    }

    public String getActualDate() 
    {
        return actualDate;
    }

    public void setTaxRate(BigDecimal taxRate) 
    {
        this.taxRate = taxRate;
    }

    public BigDecimal getTaxRate() 
    {
        return taxRate;
    }

    public void setAmount(BigDecimal amount) 
    {
        this.amount = amount;
    }

    public BigDecimal getAmount() 
    {
        return amount;
    }

    public void setProductionDate(String productionDate) 
    {
        this.productionDate = productionDate;
    }

    public String getProductionDate() 
    {
        return productionDate;
    }

    public void setExpiryDate(String expiryDate) 
    {
        this.expiryDate = expiryDate;
    }

    public String getExpiryDate() 
    {
        return expiryDate;
    }

    public void setFileName(String fileName) 
    {
        this.fileName = fileName;
    }

    public String getFileName() 
    {
        return fileName;
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
            .append("detailId", getDetailId())
            .append("purchaseId", getPurchaseId())
            .append("productId", getProductId())
            .append("batchNo", getBatchNo())
            .append("purchaseQuantity", getPurchaseQuantity())
            .append("receivedQuantity", getReceivedQuantity())
            .append("unitPrice", getUnitPrice())
            .append("purchaseDate", getPurchaseDate())
            .append("expectedDate", getExpectedDate())
            .append("actualDate", getActualDate())
            .append("taxRate", getTaxRate())
            .append("amount", getAmount())
            .append("productionDate", getProductionDate())
            .append("expiryDate", getExpiryDate())
            .append("fileName", getFileName())
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
