package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Brand;

/**
 * 品牌Service接口
 * 
 * @author ruoyi
 * @date 2021-05-06
 */
public interface IBrandService 
{
    /**
     * 查询品牌
     * 
     * @param id 品牌ID
     * @return 品牌
     */
    public Brand selectBrandById(Long id);

    /**
     * 查询品牌列表
     * 
     * @param brand 品牌
     * @return 品牌集合
     */
    public List<Brand> selectBrandList(Brand brand);

    /**
     * 新增品牌
     * 
     * @param brand 品牌
     * @return 结果
     */
    public int insertBrand(Brand brand);

    /**
     * 修改品牌
     * 
     * @param brand 品牌
     * @return 结果
     */
    public int updateBrand(Brand brand);

    /**
     * 批量删除品牌
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteBrandByIds(String ids);

    /**
     * 删除品牌信息
     * 
     * @param id 品牌ID
     * @return 结果
     */
    public int deleteBrandById(Long id);
}
