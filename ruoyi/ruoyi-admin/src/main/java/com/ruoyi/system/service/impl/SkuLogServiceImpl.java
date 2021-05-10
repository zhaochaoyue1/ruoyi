package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SkuLogMapper;
import com.ruoyi.system.domain.SkuLog;
import com.ruoyi.system.service.ISkuLogService;
import com.ruoyi.common.core.text.Convert;

/**
 * 商品Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-05-08
 */
@Service
public class SkuLogServiceImpl implements ISkuLogService 
{
    @Autowired
    private SkuLogMapper skuLogMapper;

    /**
     * 查询商品
     * 
     * @param id 商品ID
     * @return 商品
     */
    @Override
    public SkuLog selectSkuLogById(Long id)
    {
        return skuLogMapper.selectSkuLogById(id);
    }

    /**
     * 查询商品列表
     * 
     * @param skuLog 商品
     * @return 商品
     */
    @Override
    public List<SkuLog> selectSkuLogList(SkuLog skuLog)
    {
        return skuLogMapper.selectSkuLogList(skuLog);
    }

    /**
     * 新增商品
     * 
     * @param skuLog 商品
     * @return 结果
     */
    @Override
    public int insertSkuLog(SkuLog skuLog)
    {
        return skuLogMapper.insertSkuLog(skuLog);
    }

    /**
     * 修改商品
     * 
     * @param skuLog 商品
     * @return 结果
     */
    @Override
    public int updateSkuLog(SkuLog skuLog)
    {
        return skuLogMapper.updateSkuLog(skuLog);
    }

    /**
     * 删除商品对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSkuLogByIds(String ids)
    {
        return skuLogMapper.deleteSkuLogByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除商品信息
     * 
     * @param id 商品ID
     * @return 结果
     */
    @Override
    public int deleteSkuLogById(Long id)
    {
        return skuLogMapper.deleteSkuLogById(id);
    }
}
