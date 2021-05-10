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
import com.ruoyi.system.domain.Brand;
import com.ruoyi.system.service.IBrandService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 品牌Controller
 * 
 * @author ruoyi
 * @date 2021-05-06
 */
@Controller
@RequestMapping("/system/brand")
public class BrandController extends BaseController
{
    private String prefix = "system/brand";

    @Autowired
    private IBrandService brandService;

    @RequiresPermissions("system:brand:view")
    @GetMapping()
    public String brand()
    {
        return prefix + "/brand";
    }

    /**
     * 查询品牌列表
     */
    @RequiresPermissions("system:brand:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Brand brand)
    {
        startPage();
        List<Brand> list = brandService.selectBrandList(brand);
        return getDataTable(list);
    }

    /**
     * 导出品牌列表
     */
    @RequiresPermissions("system:brand:export")
    @Log(title = "品牌", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Brand brand)
    {
        List<Brand> list = brandService.selectBrandList(brand);
        ExcelUtil<Brand> util = new ExcelUtil<Brand>(Brand.class);
        return util.exportExcel(list, "brand");
    }

    /**
     * 新增品牌
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存品牌
     */
    @RequiresPermissions("system:brand:add")
    @Log(title = "品牌", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Brand brand)
    {
        brand.create();
        return toAjax(brandService.insertBrand(brand));
    }

    /**
     * 修改品牌
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Brand brand = brandService.selectBrandById(id);
        mmap.put("brand", brand);
        return prefix + "/edit";
    }

    /**
     * 修改保存品牌
     */
    @RequiresPermissions("system:brand:edit")
    @Log(title = "品牌", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Brand brand)
    {
        brand.update();
        return toAjax(brandService.updateBrand(brand));
    }

    /**
     * 删除品牌
     */
    @RequiresPermissions("system:brand:remove")
    @Log(title = "品牌", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(brandService.deleteBrandByIds(ids));
    }
}
