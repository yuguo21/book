package com.ruoyi.logic.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.logic.mapper.LogicMetaMapper;
import com.ruoyi.logic.domain.LogicMeta;
import com.ruoyi.logic.service.ILogicMetaService;
import com.ruoyi.common.core.text.Convert;

/**
 * 书中元素Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-02-22
 */
@Service
public class LogicMetaServiceImpl implements ILogicMetaService 
{
    @Autowired
    private LogicMetaMapper logicMetaMapper;

    /**
     * 查询书中元素
     * 
     * @param metaId 书中元素主键
     * @return 书中元素
     */
    @Override
    public LogicMeta selectLogicMetaByMetaId(Long metaId)
    {
        return logicMetaMapper.selectLogicMetaByMetaId(metaId);
    }

    /**
     * 查询书中元素列表
     * 
     * @param logicMeta 书中元素
     * @return 书中元素
     */
    @Override
    public List<LogicMeta> selectLogicMetaList(LogicMeta logicMeta)
    {
        return logicMetaMapper.selectLogicMetaList(logicMeta);
    }

    /**
     * 新增书中元素
     * 
     * @param logicMeta 书中元素
     * @return 结果
     */
    @Override
    public int insertLogicMeta(LogicMeta logicMeta)
    {
        logicMeta.setCreateTime(DateUtils.getNowDate());
        return logicMetaMapper.insertLogicMeta(logicMeta);
    }

    /**
     * 修改书中元素
     * 
     * @param logicMeta 书中元素
     * @return 结果
     */
    @Override
    public int updateLogicMeta(LogicMeta logicMeta)
    {
        logicMeta.setUpdateTime(DateUtils.getNowDate());
        return logicMetaMapper.updateLogicMeta(logicMeta);
    }

    /**
     * 批量删除书中元素
     * 
     * @param metaIds 需要删除的书中元素主键
     * @return 结果
     */
    @Override
    public int deleteLogicMetaByMetaIds(String metaIds)
    {
        return logicMetaMapper.deleteLogicMetaByMetaIds(Convert.toStrArray(metaIds));
    }

    /**
     * 删除书中元素信息
     * 
     * @param metaId 书中元素主键
     * @return 结果
     */
    @Override
    public int deleteLogicMetaByMetaId(Long metaId)
    {
        return logicMetaMapper.deleteLogicMetaByMetaId(metaId);
    }
}
