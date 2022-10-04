package com.ruoyi.logic.mapper;

import java.util.List;
import com.ruoyi.logic.domain.LogicPersonRelation;
import com.ruoyi.logic.domain.LogicPersonRelationVo;
import com.ruoyi.logic.dto.LogicPersonRelationDTO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 人物关系Mapper接口
 * 
 * @author ruoyi
 * @date 2022-02-18
 */
@Mapper
public interface LogicPersonRelationMapper 
{
    /**
     * 查询人物关系
     * 
     * @param relationId 人物关系主键
     * @return 人物关系
     */
    public LogicPersonRelation selectLogicPersonRelationByRelationId(Long relationId);

    public List<LogicPersonRelationVo> selectAllList(LogicPersonRelationDTO logicPersonRelation);

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
     * 删除人物关系
     * 
     * @param relationId 人物关系主键
     * @return 结果
     */
    public int deleteLogicPersonRelationByRelationId(Long relationId);

    /**
     * 批量删除人物关系
     * 
     * @param relationIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteLogicPersonRelationByRelationIds(String[] relationIds);
}
