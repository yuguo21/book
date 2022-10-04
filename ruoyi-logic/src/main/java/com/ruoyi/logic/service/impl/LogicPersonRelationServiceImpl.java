package com.ruoyi.logic.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.logic.domain.LogicPersonRelationVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.logic.mapper.LogicPersonRelationMapper;
import com.ruoyi.logic.domain.LogicPersonRelation;
import com.ruoyi.logic.dto.LogicPersonRelationDTO;
import com.ruoyi.logic.service.ILogicPersonRelationService;
import com.ruoyi.common.core.text.Convert;

/**
 * 人物关系Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-02-18
 */
@Service
public class LogicPersonRelationServiceImpl implements ILogicPersonRelationService 
{
    @Autowired
    private LogicPersonRelationMapper logicPersonRelationMapper;

    /**
     * 查询人物关系
     * 
     * @param relationId 人物关系主键
     * @return 人物关系
     */
    @Override
    public LogicPersonRelation selectLogicPersonRelationByRelationId(Long relationId)
    {
        return logicPersonRelationMapper.selectLogicPersonRelationByRelationId(relationId);
    }

    /**
     * 查询人物关系列表
     * 
     * @param logicPersonRelation 人物关系
     * @return 人物关系
     */
    @Override
    public List<LogicPersonRelation> selectLogicPersonRelationList(LogicPersonRelationDTO logicPersonRelation)
    {
        return logicPersonRelationMapper.selectLogicPersonRelationList(logicPersonRelation);
    }

    @Override
    public List<LogicPersonRelationVo> queryAllList(LogicPersonRelationDTO logicPersonRelation) {
        return logicPersonRelationMapper.selectAllList(logicPersonRelation);
    }


    /**
     * 新增人物关系
     * 
     * @param logicPersonRelation 人物关系
     * @return 结果
     */
    @Override
    public int insertLogicPersonRelation(LogicPersonRelation logicPersonRelation)
    {
        logicPersonRelation.setCreateTime(DateUtils.getNowDate());
        return logicPersonRelationMapper.insertLogicPersonRelation(logicPersonRelation);
    }

    /**
     * 修改人物关系
     * 
     * @param logicPersonRelation 人物关系
     * @return 结果
     */
    @Override
    public int updateLogicPersonRelation(LogicPersonRelation logicPersonRelation)
    {
        logicPersonRelation.setUpdateTime(DateUtils.getNowDate());
        return logicPersonRelationMapper.updateLogicPersonRelation(logicPersonRelation);
    }

    /**
     * 批量删除人物关系
     * 
     * @param relationIds 需要删除的人物关系主键
     * @return 结果
     */
    @Override
    public int deleteLogicPersonRelationByRelationIds(String relationIds)
    {
        return logicPersonRelationMapper.deleteLogicPersonRelationByRelationIds(Convert.toStrArray(relationIds));
    }

    /**
     * 删除人物关系信息
     * 
     * @param relationId 人物关系主键
     * @return 结果
     */
    @Override
    public int deleteLogicPersonRelationByRelationId(Long relationId)
    {
        return logicPersonRelationMapper.deleteLogicPersonRelationByRelationId(relationId);
    }
}
