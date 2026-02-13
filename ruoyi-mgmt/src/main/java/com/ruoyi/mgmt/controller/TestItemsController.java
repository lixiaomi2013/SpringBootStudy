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
import com.ruoyi.mgmt.domain.TestItems;
import com.ruoyi.mgmt.service.ITestItemsService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 检验项目主Controller
 * 
 * @author zhuhoulin
 * @date 2026-01-03
 */
@Controller
@RequestMapping("/mgmt/testitems")
public class TestItemsController extends BaseController
{
    private String prefix = "mgmt/testitems";

    @Autowired
    private ITestItemsService testItemsService;

    @RequiresPermissions("mgmt:testitems:view")
    @GetMapping()
    public String testitems()
    {
        return prefix + "/testitems";
    }

    /**
     * 查询检验项目主列表
     */
    @RequiresPermissions("mgmt:testitems:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TestItems testItems)
    {
        startPage();
        List<TestItems> list = testItemsService.selectTestItemsList(testItems);
        return getDataTable(list);
    }

    /**
     * 导出检验项目主列表
     */
    @RequiresPermissions("mgmt:testitems:export")
    @Log(title = "检验项目主", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TestItems testItems)
    {
        List<TestItems> list = testItemsService.selectTestItemsList(testItems);
        ExcelUtil<TestItems> util = new ExcelUtil<TestItems>(TestItems.class);
        return util.exportExcel(list, "检验项目主数据");
    }

    /**
     * 新增检验项目主
     */
    @RequiresPermissions("mgmt:testitems:add")
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存检验项目主
     */
    @RequiresPermissions("mgmt:testitems:add")
    @Log(title = "检验项目主", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TestItems testItems)
    {
        return toAjax(testItemsService.insertTestItems(testItems));
    }

    /**
     * 修改检验项目主
     */
    @RequiresPermissions("mgmt:testitems:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
        TestItems testItems = testItemsService.selectTestItemsById(id);
        mmap.put("testItems", testItems);
        return prefix + "/edit";
    }

    /**
     * 修改保存检验项目主
     */
    @RequiresPermissions("mgmt:testitems:edit")
    @Log(title = "检验项目主", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TestItems testItems)
    {
        return toAjax(testItemsService.updateTestItems(testItems));
    }

    /**
     * 删除检验项目主
     */
    @RequiresPermissions("mgmt:testitems:remove")
    @Log(title = "检验项目主", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(testItemsService.deleteTestItemsByIds(ids));
    }
    
    @RequiresPermissions("mgmt:testitems:view")
	@GetMapping("/select")
	public String select() {
		return prefix + "/select";
	}
}
