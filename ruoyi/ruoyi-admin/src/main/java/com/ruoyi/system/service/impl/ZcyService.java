package com.ruoyi.system.service.impl;

import com.google.common.collect.Maps;
import com.ruoyi.system.domain.Brand;
import com.ruoyi.system.domain.Category;
import com.ruoyi.system.service.IBrandService;
import com.ruoyi.system.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;

/**
 * @description: ZcyService
 * @date: 2021/5/7 下午5:35
 * @author: zcy
 * @version: 1.0
 */
@Service("zcy")
public class ZcyService {
    private static Map<String,Object> map = Maps.newHashMap();
    private final static String BRAND = "brand";
    private final static String CATEGORY = "category";
    @Autowired
    private IBrandService brandService;
    @Autowired
    private ICategoryService categoryService;

    @PostConstruct
    public void init(){
        Brand brand = new Brand();
        List<Brand> brands = brandService.selectBrandList(brand);
        List<Category> categories = categoryService.selectCategoryList(new Category());
        map.put(BRAND,brands);
        map.put(CATEGORY,categories);
    }

    public List<Brand> getBrand()
    {
        List<Brand> brands = (List<Brand>) map.get(BRAND);
        if(CollectionUtils.isEmpty(brands)){
            brands = brandService.selectBrandList(new Brand());
            map.put(BRAND,brands);
            return brands;
        }
        return brands;
    }

    public List<Category> getCategory(){
        List<Category> categories = (List<Category>) map.get(CATEGORY);
        if(CollectionUtils.isEmpty(categories)){
            categories = categoryService.selectCategoryList(new Category());
            map.put(CATEGORY,categories);
            return categories;
        }
        return categories;
    }

    public void cleanBrand(){
        map.remove(BRAND);
    }

    public void cleanCategory(){
        map.remove(CATEGORY);
    }

}
