package com.ruoyi.mgmt.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 产品库存信息对象 v_mgmt_product_info_view
 * 
 * @author zhuhoulin
 * @date 2026-02-09
 */
public class ProductInfoView extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 产品ID */
    @Excel(name = "产品ID")
    private String productId;

    /** 产品编号 */
    @Excel(name = "产品编号")
    private String productCode;

    /** 产品名称 */
    @Excel(name = "产品名称")
    private String productName;

    /** 规格 */
    @Excel(name = "规格")
    private String spec;

    /** 品牌 */
    @Excel(name = "品牌")
    private String brand;

    /** 存储条件 */
    @Excel(name = "存储条件")
    private String storageCondition;

    /** 单位 */
    @Excel(name = "单位")
    private String unit;

    /** 总计数量 */
    @Excel(name = "总计数量")
    private Long totailQuantity;

    /** 已用数量 */
    @Excel(name = "已用数量")
    private Long usedQuantity;

    /** 可用数量 */
    @Excel(name = "可用数量")
    private Long availableQuantity;

    /** 项次 */
    @Excel(name = "项次")
    private Long projectTimes;

    /** 批次号 */
    @Excel(name = "批次号")
    private String batchNumber;

    /** 生产日期 */
    @Excel(name = "生产日期")
    private String productionDate;

    /** 有效日期 */
    @Excel(name = "有效日期")
    private String expiryDate;

    /** 批准文号 */
    @Excel(name = "批准文号")
    private String approvalNumber;

    /** 导入文件名称 */
    @Excel(name = "导入文件名称")
    private String fileName;

    /** 状态 */
    @Excel(name = "状态")
    private String status;

    /** 删除标志 */
    private String delFlag;

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

    public void setSpec(String spec) 
    {
        this.spec = spec;
    }

    public String getSpec() 
    {
        return spec;
    }

    public void setBrand(String brand) 
    {
        this.brand = brand;
    }

    public String getBrand() 
    {
        return brand;
    }

    public void setStorageCondition(String storageCondition) 
    {
        this.storageCondition = storageCondition;
    }

    public String getStorageCondition() 
    {
        return storageCondition;
    }

    public void setUnit(String unit) 
    {
        this.unit = unit;
    }

    public String getUnit() 
    {
        return unit;
    }

    public void setTotailQuantity(Long totailQuantity) 
    {
        this.totailQuantity = totailQuantity;
    }

    public Long getTotailQuantity() 
    {
        return totailQuantity;
    }

    public void setUsedQuantity(Long usedQuantity) 
    {
        this.usedQuantity = usedQuantity;
    }

    public Long getUsedQuantity() 
    {
        return usedQuantity;
    }

    public void setAvailableQuantity(Long availableQuantity) 
    {
        this.availableQuantity = availableQuantity;
    }

    public Long getAvailableQuantity() 
    {
        return availableQuantity;
    }

    public void setProjectTimes(Long projectTimes) 
    {
        this.projectTimes = projectTimes;
    }

    public Long getProjectTimes() 
    {
        return projectTimes;
    }

    public void setBatchNumber(String batchNumber) 
    {
        this.batchNumber = batchNumber;
    }

    public String getBatchNumber() 
    {
        return batchNumber;
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

    public void setApprovalNumber(String approvalNumber) 
    {
        this.approvalNumber = approvalNumber;
    }

    public String getApprovalNumber() 
    {
        return approvalNumber;
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
            .append("productId", getProductId())
            .append("productCode", getProductCode())
            .append("productName", getProductName())
            .append("spec", getSpec())
            .append("brand", getBrand())
            .append("storageCondition", getStorageCondition())
            .append("unit", getUnit())
            .append("totailQuantity", getTotailQuantity())
            .append("usedQuantity", getUsedQuantity())
            .append("availableQuantity", getAvailableQuantity())
            .append("projectTimes", getProjectTimes())
            .append("batchNumber", getBatchNumber())
            .append("productionDate", getProductionDate())
            .append("expiryDate", getExpiryDate())
            .append("approvalNumber", getApprovalNumber())
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
