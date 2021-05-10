package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SkuLog;

/**
 * 商品Service接口
 * 
 * @author ruoyi
 * @date 2021-05-08
 */
public interface ISkuLogService 
{
    /**
     * 查询商品
     * 
     * @param id 商品ID
     * @return 商品
     */
    public SkuLog selectSkuLogById(Long id);

    /**
     * 查询商品列表
     * 
     * @param skuLog 商品
     * @return 商品集合
     */
    public List<SkuLog> selectSkuLogList(SkuLog skuLog);

    /**
     * 新增商品
     * 
     * @param skuLog 商品
     * @return 结果
     */
    public int insertSkuLog(SkuLog skuLog);

    /**
     * 修改商品
     * 
     * @param skuLog 商品
     * @return 结果
     */
    public int updateSkuLog(SkuLog skuLog);

    /**
     * 批量删除商品
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSkuLogByIds(String ids);

    /**
     * 删除商品信息
     * 
     * @param id 商品ID
     * @return 结果
     */
    public int deleteSkuLogById(Long id);
}
