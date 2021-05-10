package com.ruoyi.system.service.impl;

import java.util.Date;
import java.util.List;

import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.system.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.CategoryMapper;
import com.ruoyi.system.domain.Category;
import com.ruoyi.system.service.ICategoryService;
import com.ruoyi.common.core.text.Convert;

/**
 * 分类Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-05-06
 */
@Service
public class CategoryServiceImpl implements ICategoryService 
{
    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private ZcyService zcyService;

    /**
     * 查询分类
     * 
     * @param id 分类ID
     * @return 分类
     */
    @Override
    public Category selectCategoryById(Long id)
    {
        return categoryMapper.selectCategoryById(id);
    }

    /**
     * 查询分类列表
     * 
     * @param category 分类
     * @return 分类
     */
    @Override
    public List<Category> selectCategoryList(Category category)
    {
        zcyService.cleanCategory();
        List<Category> categories = categoryMapper.selectCategoryList(category);
        return categories;
    }

    /**
     * 新增分类
     * 
     * @param category 分类
     * @return 结果
     */
    @Override
    public int insertCategory(Category category)
    {
        zcyService.cleanCategory();
        return categoryMapper.insertCategory(category);
    }

    /**
     * 修改分类
     * 
     * @param category 分类
     * @return 结果
     */
    @Override
    public int updateCategory(Category category)
    {
        zcyService.cleanCategory();
        return categoryMapper.updateCategory(category);
    }

    /**
     * 删除分类对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCategoryByIds(String ids)
    {
        zcyService.cleanCategory();
        return categoryMapper.deleteCategoryByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除分类信息
     * 
     * @param id 分类ID
     * @return 结果
     */
    @Override
    public int deleteCategoryById(Long id)
    {
        zcyService.cleanCategory();
        return categoryMapper.deleteCategoryById(id);
    }
}
