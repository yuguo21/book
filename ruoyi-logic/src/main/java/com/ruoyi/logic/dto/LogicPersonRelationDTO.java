package com.ruoyi.logic.dto;

import com.ruoyi.common.core.domain.BaseEntity;

public class LogicPersonRelationDTO extends BaseEntity{
    
    private Long personIdA;

    private Long personIdB;

    private Long[] personIds;

    private String bookKey;

    private String relationName;

    public Long getPersonIdB() {
        return personIdB;
    }

    public void setPersonIdB(Long personIdB) {
        this.personIdB = personIdB;
    }

    public Long getPersonIdA() {
        return personIdA;
    }

    public void setPersonIdA(Long personIdA) {
        this.personIdA = personIdA;
    }

    public Long[] getPersonIds() {
        return personIds;
    }

    public void setPersonIds(Long[] personIds) {
        this.personIds = personIds;
    }

    public String getBookKey() {
        return bookKey;
    }

    public void setBookKey(String bookKey) {
        this.bookKey = bookKey;
    }

    public String getRelationName() {
        return relationName;
    }

    public void setRelationName(String relationName) {
        this.relationName = relationName;
    }

}
