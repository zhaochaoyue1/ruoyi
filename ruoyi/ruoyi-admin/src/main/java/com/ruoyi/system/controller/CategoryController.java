package com.ruoyi.system.controller;

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
import com.ruoyi.system.domain.Category;
import com.ruoyi.system.service.ICategoryService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 分类Controller
 * 
 * @author ruoyi
 * @date 2021-05-06
 */
@Controller
@RequestMapping("/system/category")
public class CategoryController extends BaseController
{
    private String prefix = "system/category";

    @Autowired
    private ICategoryService categoryService;

    @RequiresPermissions("system:category:view")
    @GetMapping()
    public String category()
    {
        return prefix + "/category";
    }

    /**
     * 查询分类列表
     */
    @RequiresPermissions("system:category:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Category category)
    {
        startPage();
        List<Category> list = categoryService.selectCategoryList(category);
        return getDataTable(list);
    }

    /**
     * 导出分类列表
     */
    @RequiresPermissions("system:category:export")
    @Log(title = "分类", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Category category)
    {
        List<Category> list = categoryService.selectCategoryList(category);
        ExcelUtil<Category> util = new ExcelUtil<Category>(Category.class);
        return util.exportExcel(list, "category");
    }

    /**
     * 新增分类
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存分类
     */
    @RequiresPermissions("system:category:add")
    @Log(title = "分类", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Category category)
    {
        category.create();
        return toAjax(categoryService.insertCategory(category));
    }

    /**
     * 修改分类
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Category category = categoryService.selectCategoryById(id);
        mmap.put("category", category);
        return prefix + "/edit";
    }

    /**
     * 修改保存分类
     */
    @RequiresPermissions("system:category:edit")
    @Log(title = "分类", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Category category)
    {
        category.update();
        return toAjax(categoryService.updateCategory(category));
    }

    /**
     * 删除分类
     */
    @RequiresPermissions("system:category:remove")
    @Log(title = "分类", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(categoryService.deleteCategoryByIds(ids));
    }
}
