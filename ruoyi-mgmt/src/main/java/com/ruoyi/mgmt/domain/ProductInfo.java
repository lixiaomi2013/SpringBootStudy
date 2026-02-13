package com.ruoyi.mgmt.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.InnerField;
import org.springframework.data.elasticsearch.annotations.MultiField;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.math.BigDecimal;

/**
 * 产品信息对象 t_mgmt_product_info
 * 
 * @author zhuhoulin
 * @date 2025-12-19
 */
@Document(indexName = "t_mgmt_product_info", createIndex = true)
public class ProductInfo extends BaseEntity {
	private static final long serialVersionUID = 1L;

	/** 产品ID */
	@Id
	@Field(type = FieldType.Keyword)
	private String productId;

    /** 产品编号 */
    @Excel(name = "产品编号")
    private String productCode;
    
	/** 产品名称 */
	@Excel(name = "产品名称")
//	@Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_smart")
	
    // 对于需要同时支持搜索和精确匹配的字段，使用 MultiField
    // 产品名称：需要搜索和排序
	@MultiField(
			mainField = @Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_smart"), 
				otherFields = {
						@InnerField(suffix = "brand", type = FieldType.Keyword), 
						@InnerField(suffix = "status", type = FieldType.Keyword) 
						}
			)
	private String productName;

	/** 产品简称 */
	@Excel(name = "产品简称")
	private String productShortName;

	/** 规格 */
	@Excel(name = "规格")
	@Field(type = FieldType.Text, analyzer = "ik_max_word")
	private String spec;

	/** 品牌 */
	@Excel(name = "品牌")
	@Field(type = FieldType.Keyword)
	private String brand;

	/** 存储条件 */
	@Excel(name = "存储条件")
	@Field(type = FieldType.Keyword)
	private String storageCondition;

	/** 单位 */
	@Excel(name = "单位")
	@Field(type = FieldType.Keyword)
	private String unit;

	/** 单价 */
	@Excel(name = "单价")
	@Field(type = FieldType.Double)
	private BigDecimal unitPrice;

	/** 数量 */
	@Excel(name = "数量")
	@Field(type = FieldType.Long)
	private Long quantity;

    /** 项次 */
    @Excel(name = "项次")
    private Long projectTimes;
    
	/** 批号 */
	@Excel(name = "批号")
	@Field(type = FieldType.Keyword)
	private String batchNumber;

	/** 生产日期 */
	@Excel(name = "生产日期")
	@Field(type = FieldType.Keyword)
	private String productionDate;

	/** 有效期截止日期 */
	@Excel(name = "有效期截止日期")
	@Field(type = FieldType.Keyword)
	private String expiryDate;

	/** 批准文号 */
	@Excel(name = "批准文号")
	@Field(type = FieldType.Keyword)
	private String approvalNumber;

	/** 导入文件名称 */
	@Excel(name = "导入文件名称")
	@Field(type = FieldType.Text, analyzer = "ik_max_word")
	private String fileName;

	/** 状态（0正常 1停用） */
	@Excel(name = "状态", readConverterExp = "0=正常,1=停用")
	@Field(type = FieldType.Keyword)
	private String status;

	/** 删除标志（0代表存在 2代表删除） */
	@Field(type = FieldType.Keyword)
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

	public void setProductShortName(String productShortName)
	{
		this.productShortName = productShortName;
	}

	public String getProductShortName()
	{
		return productShortName;
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

	public void setUnitPrice(BigDecimal unitPrice)
	{
		this.unitPrice = unitPrice;
	}

	public BigDecimal getUnitPrice()
	{
		return unitPrice;
	}

	public void setQuantity(Long quantity)
	{
		this.quantity = quantity;
	}

	public Long getQuantity()
	{
		return quantity;
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
				.append("productShortName", getProductShortName())
				.append("spec", getSpec())
				.append("brand", getBrand())
				.append("storageCondition", getStorageCondition())
				.append("unit", getUnit())
				.append("unitPrice", getUnitPrice())
				.append("quantity", getQuantity())
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
