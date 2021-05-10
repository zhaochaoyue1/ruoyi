package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.BrandMapper;
import com.ruoyi.system.domain.Brand;
import com.ruoyi.system.service.IBrandService;
import com.ruoyi.common.core.text.Convert;

/**
 * 品牌Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-05-06
 */
@Service
public class BrandServiceImpl implements IBrandService 
{
    @Autowired
    private BrandMapper brandMapper;
    @Autowired
    private ZcyService zcyService;

    /**
     * 查询品牌
     * 
     * @param id 品牌ID
     * @return 品牌
     */
    @Override
    public Brand selectBrandById(Long id)
    {
        return brandMapper.selectBrandById(id);
    }

    /**
     * 查询品牌列表
     * 
     * @param brand 品牌
     * @return 品牌
     */
    @Override
    public List<Brand> selectBrandList(Brand brand)
    {
        return brandMapper.selectBrandList(brand);
    }

    /**
     * 新增品牌
     * 
     * @param brand 品牌
     * @return 结果
     */
    @Override
    public int insertBrand(Brand brand)
    {
        zcyService.cleanBrand();
        return brandMapper.insertBrand(brand);
    }

    /**
     * 修改品牌
     * 
     * @param brand 品牌
     * @return 结果
     */
    @Override
    public int updateBrand(Brand brand)
    {
        zcyService.cleanBrand();
        return brandMapper.updateBrand(brand);
    }

    /**
     * 删除品牌对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteBrandByIds(String ids)
    {
        zcyService.cleanBrand();
        return brandMapper.deleteBrandByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除品牌信息
     * 
     * @param id 品牌ID
     * @return 结果
     */
    @Override
    public int deleteBrandById(Long id)
    {
        zcyService.cleanBrand();
        return brandMapper.deleteBrandById(id);
    }
}
