package com.ruoyi.mgmt.elasticsearch.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.ruoyi.mgmt.domain.ProductInfo;

public interface ProductInfoRepository extends ElasticsearchRepository<ProductInfo, String> {

	// 1. 根据产品名称查询
	List<ProductInfo> findByProductName(String productName);

	// 2. 根据产品名称模糊查询
	List<ProductInfo> findByProductNameContaining(String keyword);

	// 3. 根据产品名称和品牌查询
	List<ProductInfo> findByProductNameAndBrand(String productName, String brand);

	// 4. 根据品牌查询
	List<ProductInfo> findByBrand(String brand);

	// 5. 根据状态查询
	List<ProductInfo> findByStatus(String status);

	// 6. 根据删除标志查询
	List<ProductInfo> findByDelFlag(String delFlag);

	// 7. 根据批号查询
	List<ProductInfo> findByBatchNumber(String batchNumber);

	// 8. 根据批准文号查询
	List<ProductInfo> findByApprovalNumber(String approvalNumber);

	// 9. 根据单位查询
	List<ProductInfo> findByUnit(String unit);

	// 10. 根据存储条件查询
	List<ProductInfo> findByStorageCondition(String storageCondition);

	// 11. 数量范围查询
	List<ProductInfo> findByQuantityBetween(Integer minQuantity, Integer maxQuantity);

	// 12. 根据创建时间范围查询
	List<ProductInfo> findByCreateTimeBetween(LocalDateTime startTime, LocalDateTime endTime);

	// 13. 根据更新时间范围查询
	List<ProductInfo> findByUpdateTimeBetween(LocalDateTime startTime, LocalDateTime endTime);

	// 14. 根据创建者查询
	List<ProductInfo> findByCreateBy(String createBy);

	// 15. 根据更新者查询
	List<ProductInfo> findByUpdateBy(String updateBy);

	// 16. 复合查询：根据名称、品牌、状态（分页）
	Page<ProductInfo> findByProductNameContainingAndBrandAndStatus(String productName, String brand, String status, Pageable pageable);

	// 17. 复合查询：根据删除标志和状态
	List<ProductInfo> findByDelFlagAndStatus(String delFlag, String status);

	// 18. 复合查询：未删除的正常产品
	default List<ProductInfo> findActiveNormalProducts() {
		return findByDelFlagAndStatus("0", "0");
	}

	// 19. 自定义查询：全文搜索（名称、规格、备注）
	@Query("{\"bool\": {\"must\": [" + "{\"term\": {\"delFlag\": \"0\"}}," + "{\"bool\": {\"should\": [" + "{\"match\": {\"productName\": {\"query\": \"?0\", \"boost\": 3}}}, " + "{\"match\": {\"spec\": {\"query\": \"?0\", \"boost\": 2}}}, " + "{\"match\": {\"remark\": \"?0\"}}" + "]}}]}}")
	List<ProductInfo> searchFullText(String keyword);

	// 20. 自定义查询：复合条件搜索
	@Query("{\"bool\": {\"must\": [" + "{\"term\": {\"delFlag\": \"0\"}}," + "{\"match\": {\"productName\": \"?0\"}}," + "{\"term\": {\"brand\": \"?1\"}}," + "{\"term\": {\"status\": \"?2\"}}," + "{\"range\": {\"quantity\": {\"gte\": ?3}}}" + "]}}")
	List<ProductInfo> findByComplexCondition(String productName, String brand, String status, Integer minQuantity);

	// 21. 自定义查询：检查过期产品
	@Query("{\"bool\": {\"must\": [" + "{\"term\": {\"delFlag\": \"0\"}}," + "{\"term\": {\"status\": \"0\"}}," + "{\"range\": {\"expiryDate\": {\"lt\": \"?0\"}}}" + "]}}")
	List<ProductInfo> findExpiredProducts(String currentDate);

	// 22. 自定义查询：批量ID查询
	@Query("{\"terms\": {\"_id\": ?0}}")
	List<ProductInfo> findByIds(List<String> ids);

	// 23. 自定义查询：根据文件名查询
	List<ProductInfo> findByFileName(String fileName);

	// 24. 判断产品是否存在
	boolean existsByProductNameAndBatchNumberAndDelFlag(String productName, String batchNumber, String delFlag);

	// 25. 根据产品名称统计数量
	long countByProductName(String productName);

	// 26. 根据品牌统计数量
	long countByBrand(String brand);

	// 27. 分页查询所有有效产品
	Page<ProductInfo> findByDelFlag(String delFlag, Pageable pageable);
}