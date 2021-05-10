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
import com.ruoyi.system.domain.SkuLog;
import com.ruoyi.system.service.ISkuLogService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 商品Controller
 * 
 * @author ruoyi
 * @date 2021-05-08
 */
@Controller
@RequestMapping("/system/skuLog")
public class SkuLogController extends BaseController
{
    private String prefix = "system/skuLog";

    @Autowired
    private ISkuLogService skuLogService;

    @RequiresPermissions("system:skuLog:view")
    @GetMapping("/{skuId}")
    public String log(@PathVariable("skuId") Long skuId, ModelMap mmap)
    {
        mmap.put("skuId",skuId);
        return prefix + "/skuLog";
    }

    /**
     * 查询商品列表
     */
    @RequiresPermissions("system:skuLog:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SkuLog skuLog)
    {
        startPage();
        List<SkuLog> list = skuLogService.selectSkuLogList(skuLog);
        return getDataTable(list);
    }

    /**
     * 导出商品列表
     */
    @RequiresPermissions("system:log:export")
    @Log(title = "商品", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SkuLog skuLog)
    {
        List<SkuLog> list = skuLogService.selectSkuLogList(skuLog);
        ExcelUtil<SkuLog> util = new ExcelUtil<SkuLog>(SkuLog.class);
        return util.exportExcel(list, "log");
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
    @RequiresPermissions("system:log:add")
    @Log(title = "商品", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SkuLog skuLog)
    {
        skuLog.create();
        return toAjax(skuLogService.insertSkuLog(skuLog));
    }

    /**
     * 修改商品
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        SkuLog skuLog = skuLogService.selectSkuLogById(id);
        mmap.put("skuLog", skuLog);
        return prefix + "/edit";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") Long id, ModelMap mmap)
    {
        SkuLog skuLog = skuLogService.selectSkuLogById(id);
        mmap.put("skuLog", skuLog);
        return prefix + "/detail";
    }

    /**
     * 修改保存商品
     */
    @RequiresPermissions("system:log:edit")
    @Log(title = "商品", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SkuLog skuLog)
    {
        skuLog.update();
        return toAjax(skuLogService.updateSkuLog(skuLog));
    }

    /**
     * 删除商品
     */
    @RequiresPermissions("system:log:remove")
    @Log(title = "商品", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(skuLogService.deleteSkuLogByIds(ids));
    }
}
