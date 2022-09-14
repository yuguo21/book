package com.ruoyi.logic.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 人物关系对象 logic_person_relation
 * 
 * @author ruoyi
 * @date 2022-02-18
 */
public class LogicPersonRelation extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long relationId;

    /** 书名 */
    @Excel(name = "书名")
    private String bookKey;

    /** 人物1 */
    @Excel(name = "人物1")
    private Long personIdA;

    /** 人物2 */
    @Excel(name = "人物2")
    private Long personIdB;

    /** 关系名称 */
    @Excel(name = "关系名称")
    private String relationName;

    @Excel(name = "人物名称1")
    private String nameA;

    @Excel(name = "人物名称2")
    private String nameB;

    public String getNameA() {
        return nameA;
    }

    public void setNameA(String nameA) {
        this.nameA = nameA;
    }

    public String getNameB() {
        return nameB;
    }

    public void setNameB(String nameB) {
        this.nameB = nameB;
    }

    public void setRelationId(Long relationId) 
    {
        this.relationId = relationId;
    }

    public Long getRelationId() 
    {
        return relationId;
    }
    public void setBookKey(String bookKey) 
    {
        this.bookKey = bookKey;
    }

    public String getBookKey() 
    {
        return bookKey;
    }
    public void setPersonIdA(Long personIdA) 
    {
        this.personIdA = personIdA;
    }

    public Long getPersonIdA() 
    {
        return personIdA;
    }
    public void setPersonIdB(Long personIdB) 
    {
        this.personIdB = personIdB;
    }

    public Long getPersonIdB() 
    {
        return personIdB;
    }
    public void setRelationName(String relationName) 
    {
        this.relationName = relationName;
    }

    public String getRelationName() 
    {
        return relationName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("relationId", getRelationId())
            .append("bookKey", getBookKey())
            .append("personIdA", getPersonIdA())
            .append("personIdB", getPersonIdB())
            .append("relationName", getRelationName())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
