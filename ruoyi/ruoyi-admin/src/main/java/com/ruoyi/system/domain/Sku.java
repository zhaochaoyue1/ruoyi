package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 商品对象 sku
 *
 * @author ruoyi
 * @date 2021-05-06
 */
public class Sku extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 商品id
     */
    private Long id;

    /**
     * sku名称
     */
    @Excel(name = "sku名称")
    private String name;

    /**
     * 尺码
     */
    @Excel(name = "尺码")
    private Long size;

    /**
     * 入库价格
     */
    @Excel(name = "入库价格")
    private Long fromPrice;

    /**
     * 销售价格
     */
    @Excel(name = "销售价格")
    private Long salePrice;

    /**
     * percentage
     */
    @Excel(name = "percentage")
    private Long percentage;

    /**
     * 状态
     */
    @Excel(name = "状态")
    private Long status;

    /**
     * 打分
     */
    @Excel(name = "打分")
    private Long score;

    /**
     * 主图
     */
    @Excel(name = "主图")
    private String pic;
    /**
     * 主图
     */
    @Excel(name = "品牌")
    private Integer brand;
    /**
     * 主图
     */
    @Excel(name = "分类")
    private Integer category;

    @Excel(name = "图集")
    private String atlas;

    public String getAtlas() {
        return atlas;
    }

    public void setAtlas(String atlas) {
        this.atlas = atlas;
    }

    public Integer getBrand() {
        return brand;
    }

    public void setBrand(Integer brand) {
        this.brand = brand;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public Long getSize() {
        return size;
    }

    public void setFromPrice(Long fromPrice) {
        this.fromPrice = fromPrice;
    }

    public Long getFromPrice() {
        return fromPrice;
    }

    public void setSalePrice(Long salePrice) {
        this.salePrice = salePrice;
    }

    public Long getSalePrice() {
        return salePrice;
    }

    public void setPercentage(Long percentage) {
        this.percentage = percentage;
    }

    public Long getPercentage() {
        return percentage;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public Long getStatus() {
        return status;
    }

    public void setScore(Long score) {
        this.score = score;
    }

    public Long getScore() {
        return score;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getPic() {
        return pic;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("name", getName())
                .append("size", getSize())
                .append("fromPrice", getFromPrice())
                .append("salePrice", getSalePrice())
                .append("percentage", getPercentage())
                .append("status", getStatus())
                .append("score", getScore())
                .append("pic", getPic())
                .append("createTime", getCreateTime())
                .append("createId", getCreateId())
                .append("updateTime", getUpdateTime())
                .append("updateId", getUpdateId())
                .append("createBy", getCreateBy())
                .append("updateBy", getUpdateBy())
                .append("brand", getBrand())
                .append("category", getCategory())
                .append("atlas",getAtlas())
                .toString();
    }
}
