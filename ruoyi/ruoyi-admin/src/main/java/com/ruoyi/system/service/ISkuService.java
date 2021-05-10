package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Sku;

/**
 * 商品Service接口
 * 
 * @author ruoyi
 * @date 2021-05-06
 */
public interface ISkuService 
{
    /**
     * 查询商品
     * 
     * @param id 商品ID
     * @return 商品
     */
    public Sku selectSkuById(Long id);

    /**
     * 查询商品列表
     * 
     * @param sku 商品
     * @return 商品集合
     */
    public List<Sku> selectSkuList(Sku sku);

    /**
     * 新增商品
     * 
     * @param sku 商品
     * @return 结果
     */
    public int insertSku(Sku sku);

    /**
     * 修改商品
     * 
     * @param sku 商品
     * @return 结果
     */
    public int updateSku(Sku sku);

    /**
     * 批量删除商品
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSkuByIds(String ids);

    /**
     * 删除商品信息
     * 
     * @param id 商品ID
     * @return 结果
     */
    public int deleteSkuById(Long id);
}
