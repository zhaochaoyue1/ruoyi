package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.SkuLog;
import com.ruoyi.system.mapper.SkuLogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SkuMapper;
import com.ruoyi.system.domain.Sku;
import com.ruoyi.system.service.ISkuService;
import com.ruoyi.common.core.text.Convert;
import org.springframework.transaction.annotation.Transactional;

/**
 * 商品Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-05-06
 */
@Service
public class SkuServiceImpl implements ISkuService 
{
    @Autowired
    private SkuMapper skuMapper;
    @Autowired
    private SkuLogMapper skuLogMapper;

    /**
     * 查询商品
     * 
     * @param id 商品ID
     * @return 商品
     */
    @Override
    public Sku selectSkuById(Long id)
    {
        return skuMapper.selectSkuById(id);
    }

    /**
     * 查询商品列表
     * 
     * @param sku 商品
     * @return 商品
     */
    @Override
    public List<Sku> selectSkuList(Sku sku)
    {
        return skuMapper.selectSkuList(sku);
    }

    /**
     * 新增商品
     * 
     * @param sku 商品
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertSku(Sku sku)
    {

        int i = skuMapper.insertSku(sku);
        if(i ==0){
            return i;
        }
        SkuLog skuLog = new SkuLog(sku);
        int i1 = skuLogMapper.insertSkuLog(skuLog);
        if(i1 == 0){
            throw new RuntimeException("服务异常");
        }
        return i;
    }

    /**
     * 修改商品
     * 
     * @param sku 商品
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateSku(Sku sku)
    {
        int i = skuMapper.updateSku(sku);
        Sku sku1 = skuMapper.selectSkuById(sku.getId());
        SkuLog skuLog = new SkuLog(sku1);
        int i1 = skuLogMapper.insertSkuLog(skuLog);
        if(i1 == 0){
            throw new RuntimeException("服务异常");
        }
        return i;
    }

    /**
     * 删除商品对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSkuByIds(String ids)
    {
        return skuMapper.deleteSkuByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除商品信息
     * 
     * @param id 商品ID
     * @return 结果
     */
    @Override
    public int deleteSkuById(Long id)
    {
        return skuMapper.deleteSkuById(id);
    }
}
