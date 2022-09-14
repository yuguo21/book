package com.ruoyi.logic.service;

import java.util.List;
import com.ruoyi.logic.domain.LogicPersonRelation;
import com.ruoyi.logic.dto.LogicPersonRelationDTO;

/**
 * 人物关系Service接口
 * 
 * @author ruoyi
 * @date 2022-02-18
 */
public interface ILogicPersonRelationService 
{
    /**
     * 查询人物关系
     * 
     * @param relationId 人物关系主键
     * @return 人物关系
     */
    public LogicPersonRelation selectLogicPersonRelationByRelationId(Long relationId);

    /**
     * 查询人物关系列表
     * 
     * @param logicPersonRelation 人物关系
     * @return 人物关系集合
     */
    public List<LogicPersonRelation> selectLogicPersonRelationList(LogicPersonRelationDTO logicPersonRelation);

    /**
     * 新增人物关系
     * 
     * @param logicPersonRelation 人物关系
     * @return 结果
     */
    public int insertLogicPersonRelation(LogicPersonRelation logicPersonRelation);

    /**
     * 修改人物关系
     * 
     * @param logicPersonRelation 人物关系
     * @return 结果
     */
    public int updateLogicPersonRelation(LogicPersonRelation logicPersonRelation);

    /**
     * 批量删除人物关系
     * 
     * @param relationIds 需要删除的人物关系主键集合
     * @return 结果
     */
    public int deleteLogicPersonRelationByRelationIds(String relationIds);

    /**
     * 删除人物关系信息
     * 
     * @param relationId 人物关系主键
     * @return 结果
     */
    public int deleteLogicPersonRelationByRelationId(Long relationId);
}
