package com.ruoyi.logic.mapper;

import java.util.List;
import com.ruoyi.logic.domain.LogicBookTitle;

/**
 * 书的内容Mapper接口
 * 
 * @author ruoyi
 * @date 2022-02-26
 */
public interface LogicBookTitleMapper
{
    /**
     * 查询书的内容
     * 
     * @param titleId 书的内容主键
     * @return 书的内容
     */
    public LogicBookTitle selectLogicBookTitleByTitleId(Long titleId);

    /**
     * 查询书的内容列表
     * 
     * @param logicBookTitle 书的内容
     * @return 书的内容集合
     */
    public List<LogicBookTitle> selectLogicBookTitleList(LogicBookTitle logicBookTitle);

    /**
     * 新增书的内容
     * 
     * @param logicBookTitle 书的内容
     * @return 结果
     */
    public int insertLogicBookTitle(LogicBookTitle logicBookTitle);

    /**
     * 修改书的内容
     * 
     * @param logicBookTitle 书的内容
     * @return 结果
     */
    public int updateLogicBookTitle(LogicBookTitle logicBookTitle);

    /**
     * 删除书的内容
     * 
     * @param titleId 书的内容主键
     * @return 结果
     */
    public int deleteLogicBookTitleByTitleId(Long titleId);

    /**
     * 批量删除书的内容
     * 
     * @param titleIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteLogicBookTitleByTitleIds(String[] titleIds);
}
