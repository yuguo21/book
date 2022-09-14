package com.ruoyi.logic.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 书中元素对象 logic_meta
 * 
 * @author ruoyi
 * @date 2022-02-22
 */
public class LogicMeta extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long metaId;

    /** 名称 */
    @Excel(name = "名称")
    private String name;

    /** 简介 */
    private String profile;

    /** 照片 */
    private String photo;

    /** 书名 */
    @Excel(name = "书名")
    private String bookKey;

    /** 类型 */
    @Excel(name = "类型")
    private String state;



    

    public void setMetaId(Long metaId) 
    {
        this.metaId = metaId;
    }

    public Long getMetaId() 
    {
        return metaId;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setProfile(String profile) 
    {
        this.profile = profile;
    }

    public String getProfile() 
    {
        return profile;
    }
    public void setPhoto(String photo) 
    {
        this.photo = photo;
    }

    public String getPhoto() 
    {
        return photo;
    }
    public void setBookKey(String bookKey) 
    {
        this.bookKey = bookKey;
    }

    public String getBookKey() 
    {
        return bookKey;
    }
    public void setState(String state) 
    {
        this.state = state;
    }

    public String getState() 
    {
        return state;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("metaId", getMetaId())
            .append("name", getName())
            .append("profile", getProfile())
            .append("photo", getPhoto())
            .append("bookKey", getBookKey())
            .append("state", getState())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
