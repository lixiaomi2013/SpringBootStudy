package com.ruoyi.mgmt.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.mgmt.domain.ProductInfoView;
import com.ruoyi.mgmt.service.IProductInfoViewService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 产品库存信息Controller
 * 
 * @author zhuhoulin
 * @date 2026-02-09
 */
@Controller
@RequestMapping("/mgmt/productinfoview")
public class ProductInfoViewController extends BaseController
{
    private String prefix = "mgmt/productinfoview";

    @Autowired
    private IProductInfoViewService productInfoViewService;

    @RequiresPermissions("mgmt:productinfoview:view")
    @GetMapping()
    public String productinfoview()
    {
        return prefix + "/productinfoview";
    }

    /**
     * 查询产品库存信息列表
     */
    @RequiresPermissions("mgmt:productinfoview:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ProductInfoView productInfoView)
    {
        startPage();
        List<ProductInfoView> list = productInfoViewService.selectProductInfoViewList(productInfoView);
        return getDataTable(list);
    }

    /**
     * 导出产品库存信息列表
     */
    @RequiresPermissions("mgmt:productinfoview:export")
    @Log(title = "产品库存信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ProductInfoView productInfoView)
    {
        List<ProductInfoView> list = productInfoViewService.selectProductInfoViewList(productInfoView);
        ExcelUtil<ProductInfoView> util = new ExcelUtil<ProductInfoView>(ProductInfoView.class);
        return util.exportExcel(list, "产品库存信息数据");
    }

    /**
     * 新增产品库存信息
     */
    @RequiresPermissions("mgmt:productinfoview:add")
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存产品库存信息
     */
    @RequiresPermissions("mgmt:productinfoview:add")
    @Log(title = "产品库存信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ProductInfoView productInfoView)
    {
        return toAjax(productInfoViewService.insertProductInfoView(productInfoView));
    }

    /**
     * 修改产品库存信息
     */
    @RequiresPermissions("mgmt:productinfoview:edit")
    @GetMapping("/edit/{productId}")
    public String edit(@PathVariable("productId") String productId, ModelMap mmap)
    {
        ProductInfoView productInfoView = productInfoViewService.selectProductInfoViewByProductId(productId);
        mmap.put("productInfoView", productInfoView);
        return prefix + "/edit";
    }

    /**
     * 修改保存产品库存信息
     */
    @RequiresPermissions("mgmt:productinfoview:edit")
    @Log(title = "产品库存信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ProductInfoView productInfoView)
    {
        return toAjax(productInfoViewService.updateProductInfoView(productInfoView));
    }

    /**
     * 删除产品库存信息
     */
    @RequiresPermissions("mgmt:productinfoview:remove")
    @Log(title = "产品库存信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(productInfoViewService.deleteProductInfoViewByProductIds(ids));
    }
}
