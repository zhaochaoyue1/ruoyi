package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * student对象 student
 * 
 * @author ruoyi
 * @date 2021-04-23
 */
public class Student extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 名称 */
    @Excel(name = "名称")
    private String name;

    /** 年纪 */
    @Excel(name = "年纪")
    private Long age;

    /** 图片url */
    @Excel(name = "图片url")
    private String picUrl;

    /** 视频流 */
    @Excel(name = "视频流")
    private String picStream;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setAge(Long age) 
    {
        this.age = age;
    }

    public Long getAge() 
    {
        return age;
    }
    public void setPicUrl(String picUrl) 
    {
        this.picUrl = picUrl;
    }

    public String getPicUrl() 
    {
        return picUrl;
    }
    public void setPicStream(String picStream) 
    {
        this.picStream = picStream;
    }

    public String getPicStream() 
    {
        return picStream;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("age", getAge())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("picUrl", getPicUrl())
            .append("picStream", getPicStream())
            .toString();
    }
}
