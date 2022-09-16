package com.ruoyi.logic.mapper;

import java.util.List;
import com.ruoyi.logic.domain.LogicMeta;
import org.apache.ibatis.annotations.Mapper;

/**
 * 书中元素Mapper接口
 * 
 * @author ruoyi
 * @date 2022-02-22
 */
@Mapper
public interface LogicMetaMapper 
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
     * 删除书中元素
     * 
     * @param metaId 书中元素主键
     * @return 结果
     */
    public int deleteLogicMetaByMetaId(Long metaId);

    /**
     * 批量删除书中元素
     * 
     * @param metaIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteLogicMetaByMetaIds(String[] metaIds);
}
