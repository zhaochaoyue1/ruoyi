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
import com.ruoyi.system.domain.Sku;
import com.ruoyi.system.service.ISkuService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 商品Controller
 * 
 * @author ruoyi
 * @date 2021-05-06
 */
@Controller
@RequestMapping("/system/sku")
public class SkuController extends BaseController
{
    private String prefix = "system/sku";

    @Autowired
    private ISkuService skuService;

    @RequiresPermissions("system:sku:view")
    @GetMapping()
    public String sku(ModelMap mmap)
    {
        return prefix + "/sku";
    }

    /**
     * 查询商品列表
     */
    @RequiresPermissions("system:sku:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Sku sku)
    {
        startPage();
        List<Sku> list = skuService.selectSkuList(sku);
        return getDataTable(list);
    }

    /**
     * 导出商品列表
     */
    @RequiresPermissions("system:sku:export")
    @Log(title = "商品", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Sku sku)
    {
        List<Sku> list = skuService.selectSkuList(sku);
        ExcelUtil<Sku> util = new ExcelUtil<Sku>(Sku.class);
        return util.exportExcel(list, "sku");
    }

    /**
     * 新增商品
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存商品
     */
    @RequiresPermissions("system:sku:add")
    @Log(title = "商品", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Sku sku)
    {
        sku.create();
        return toAjax(skuService.insertSku(sku));
    }

    /**
     * 修改商品
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Sku sku = skuService.selectSkuById(id);
        mmap.put("sku", sku);
        return prefix + "/edit";
    }

    /**
     * 查看商品详情
     * @param id
     * @param mmap
     * @return
     */
    @RequiresPermissions("system:sku:detail")
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") Long id, ModelMap mmap)
    {
        Sku sku = skuService.selectSkuById(id);
        mmap.put("sku", sku);
        return prefix + "/detail";
    }

    /**
     * 修改保存商品
     */
    @RequiresPermissions("system:sku:edit")
    @Log(title = "商品", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Sku sku)
    {
        sku.update();
        return toAjax(skuService.updateSku(sku));
    }

    /**
     * 删除商品
     */
    @RequiresPermissions("system:sku:remove")
    @Log(title = "商品", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(skuService.deleteSkuByIds(ids));
    }
}
