package com.ruoyi.logic.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 书的内容对象 logic_book_title
 * 
 * @author ruoyi
 * @date 2022-02-26
 */
public class LogicBookTitle extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long titleId;

    /** 标题 */
    @Excel(name = "标题")
    private String title;

    /** 书名 */
    private String bookKey;

    /** 标记 */
    private String flag;

    public void setTitleId(Long titleId) 
    {
        this.titleId = titleId;
    }

    public Long getTitleId() 
    {
        return titleId;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }
    public void setBookKey(String bookKey) 
    {
        this.bookKey = bookKey;
    }

    public String getBookKey() 
    {
        return bookKey;
    }
    public void setFlag(String flag) 
    {
        this.flag = flag;
    }

    public String getFlag() 
    {
        return flag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("titleId", getTitleId())
            .append("title", getTitle())
            .append("bookKey", getBookKey())
            .append("flag", getFlag())
            .append("createTime", getCreateTime())
            .append("createBy", getCreateBy())
            .append("updateTime", getUpdateTime())
            .append("updateBy", getUpdateBy())
            .append("remark", getRemark())
            .toString();
    }
}
