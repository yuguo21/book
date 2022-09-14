package com.ruoyi.logic.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 书内容对象 logic_book_content
 * 
 * @author ruoyi
 * @date 2022-03-01
 */
public class LogicBookContent extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long contentId;

    /** 内容 */
    @Excel(name = "内容")
    private String content;

    /** 书key */
    @Excel(name = "书key")
    private String bookKey;

    /** 标题ID */
    @Excel(name = "标题ID")
    private Long titleId;

    public void setContentId(Long contentId) 
    {
        this.contentId = contentId;
    }

    public Long getContentId() 
    {
        return contentId;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }
    public void setBookKey(String bookKey) 
    {
        this.bookKey = bookKey;
    }

    public String getBookKey() 
    {
        return bookKey;
    }
    public void setTitleId(Long titleId) 
    {
        this.titleId = titleId;
    }

    public Long getTitleId() 
    {
        return titleId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("contentId", getContentId())
            .append("content", getContent())
            .append("bookKey", getBookKey())
            .append("titleId", getTitleId())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
