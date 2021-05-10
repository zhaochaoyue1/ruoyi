package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * 分类对象 category
 *
 * @author ruoyi
 * @date 2021-05-06
 */
public class Category extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    private Long id;

    /**
     * 分类名称
     */
    @Excel(name = "分类名称")
    private String name;

    /**
     * 父类ID
     */
    @Excel(name = "父类ID")
    private Long parentId;


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

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Long getParentId() {
        return parentId;
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("name", getName())
                .append("parentId", getParentId())
                .append("createTime", getCreateTime())
                .append("createId", getCreateId())
                .append("updateTime", getUpdateTime())
                .append("updateId", getUpdateId())
                .append("createBy", getCreateBy())
                .append("updateBy", getUpdateBy())
                .toString();
    }
}
