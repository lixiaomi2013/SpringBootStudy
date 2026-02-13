package com.ruoyi.mgmt.controller;

import java.util.List;

import com.ruoyi.common.core.domain.entity.SysUser;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.PageUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.mgmt.domain.ProductInfo;
import com.ruoyi.mgmt.elasticsearch.repository.ProductInfoRepository;
import com.ruoyi.mgmt.service.IProductInfoService;
import org.springframework.web.multipart.MultipartFile;

/**
 * 产品信息Controller
 * 
 * @author zhuhoulin
 * @date 2025-12-19
 */
@Controller
@RequestMapping("/mgmt/product")
public class ProductInfoController extends BaseController
{
    private String prefix = "mgmt/product";

    @Autowired
    private IProductInfoService productInfoService;
    
    @Autowired(required = false)
    private ProductInfoRepository productInfoRepository;

    @RequiresPermissions("mgmt:product:view")
    @GetMapping()
    public String product()
    {
        return prefix + "/product";
    }

	/**
	 * 查询产品信息列表
	 */
	@RequiresPermissions("mgmt:product:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(ProductInfo productInfo) {
		startPage();

		String productName = productInfo.getProductName();
		String brand = productInfo.getBrand();
		String status = productInfo.getStatus();

		int page = PageUtils.getLocalPage().getPageNum();

		int size = PageUtils.getLocalPage().getPageSize();

		Sort sort = Sort.by("productionDate");
		Pageable pageable = PageRequest.of(page, size, sort);

		List<ProductInfo> list = productInfoService.selectProductInfoList(productInfo);
		return getDataTable(list);
//		for (ProductInfo product : list) {
//			productInfoRepository.save(product);
//		}
		
//		Page<ProductInfo> productInfoPage = productInfoRepository.findByProductNameContainingAndBrandAndStatus(productName, brand, status, pageable);

//		List<ProductInfo> productInfolist = productInfoRepository.findActiveNormalProducts();
//		for (ProductInfo product : productInfolist) {
//			logger.info("elasticsearch : " + product.getProductId() + "-" + product.getProductName());
//		}

//		return getDataTable(productInfoPage.toList());
	}

    /**
     * 导出产品信息列表
     */
    @RequiresPermissions("mgmt:product:export")
    @Log(title = "产品信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ProductInfo productInfo)
    {
        List<ProductInfo> list = productInfoService.selectProductInfoList(productInfo);
        ExcelUtil<ProductInfo> util = new ExcelUtil<ProductInfo>(ProductInfo.class);
        return util.exportExcel(list, "产品信息数据");
    }

    /**
     * 新增产品信息
     */
    @RequiresPermissions("mgmt:product:add")
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存产品信息
     */
    @RequiresPermissions("mgmt:product:add")
    @Log(title = "产品信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ProductInfo productInfo)
    {
        return toAjax(productInfoService.insertProductInfo(productInfo));
    }

    /**
     * 修改产品信息
     */
    @RequiresPermissions("mgmt:product:edit")
    @GetMapping("/edit/{productId}")
    public String edit(@PathVariable("productId") String productId, ModelMap mmap)
    {
        ProductInfo productInfo = productInfoService.selectProductInfoByProductId(productId);
        mmap.put("productInfo", productInfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存产品信息
     */
    @RequiresPermissions("mgmt:product:edit")
    @Log(title = "产品信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ProductInfo productInfo)
    {
        return toAjax(productInfoService.updateProductInfo(productInfo));
    }

    /**
     * 删除产品信息
     */
    @RequiresPermissions("mgmt:product:remove")
    @Log(title = "产品信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(productInfoService.deleteProductInfoByProductIds(ids));
    }


    @Log(title = "产品信息", businessType = BusinessType.IMPORT)
    @RequiresPermissions("mgmt:product:export")
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<ProductInfo> util = new ExcelUtil<ProductInfo>(ProductInfo.class);
        List<ProductInfo> productInfoList = util.importExcel(file.getInputStream());
        for (ProductInfo productInfo : productInfoList) {
            productInfoService.insertProductInfo(productInfo);
        }
//        String message = productInfoService.importExcel(productInfoList, updateSupport, getLoginName());
        return AjaxResult.success("导入成功");
    }

    @RequiresPermissions("mgmt:product:view")
	@GetMapping("/select")
	public String select() {
		return prefix + "/select";
	}
}
