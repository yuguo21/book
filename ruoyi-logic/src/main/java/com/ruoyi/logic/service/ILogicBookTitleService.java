package com.ruoyi.logic.service;

import java.util.List;
import com.ruoyi.logic.domain.LogicBookTitle;

/**
 * 书的内容Service接口
 * 
 * @author ruoyi
 * @date 2022-02-26
 */
public interface ILogicBookTitleService 
{
    /**
     * 查询书的内容
     * 
     * @param titleId 书的内容主键
     * @return 书的内容
     */
    public LogicBookTitle selectLogicBookTitleByTitleId(Long titleId);

    /**
     * search chapters use bookey
     * @param bookey
     * @return
     */
    public List<LogicBookTitle> findByBookey(String bookey);

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
     * 批量删除书的内容
     * 
     * @param titleIds 需要删除的书的内容主键集合
     * @return 结果
     */
    public int deleteLogicBookTitleByTitleIds(String titleIds);

    /**
     * 删除书的内容信息
     * 
     * @param titleId 书的内容主键
     * @return 结果
     */
    public int deleteLogicBookTitleByTitleId(Long titleId);
}
