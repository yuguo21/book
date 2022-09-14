package com.ruoyi.logic.service;

import java.util.List;
import com.ruoyi.logic.domain.LogicMeta;

/**
 * 书中元素Service接口
 * 
 * @author ruoyi
 * @date 2022-02-22
 */
public interface ILogicMetaService 
{
    /**
     * 查询书中元素
     * 
     * @param metaId 书中元素主键
     * @return 书中元素
     */
    public LogicMeta selectLogicMetaByMetaId(Long metaId);

    /**
     * 查询书中元素列表
     * 
     * @param logicMeta 书中元素
     * @return 书中元素集合
     */
    public List<LogicMeta> selectLogicMetaList(LogicMeta logicMeta);

    /**
     * 新增书中元素
     * 
     * @param logicMeta 书中元素
     * @return 结果
     */
    public int insertLogicMeta(LogicMeta logicMeta);

    /**
     * 修改书中元素
     * 
     * @param logicMeta 书中元素
     * @return 结果
     */
    public int updateLogicMeta(LogicMeta logicMeta);

    /**
     * 批量删除书中元素
     * 
     * @param metaIds 需要删除的书中元素主键集合
     * @return 结果
     */
    public int deleteLogicMetaByMetaIds(String metaIds);

    /**
     * 删除书中元素信息
     * 
     * @param metaId 书中元素主键
     * @return 结果
     */
    public int deleteLogicMetaByMetaId(Long metaId);
}
