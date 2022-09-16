package com.ruoyi.logic.service;

import java.util.List;
import com.ruoyi.logic.domain.LogicBookContent;

/**
 * 书内容Service接口
 * 
 * @author ruoyi
 * @date 2022-03-01
 */
public interface ILogicBookContentService 
{
    /**
     * 查询书内容
     * 
     * @param contentId 书内容主键
     * @return 书内容
     */
    public LogicBookContent selectLogicBookContentByContentId(Long contentId);

    /**
     * get content by chapter id
     * @param titleId
     * @return
     */
    public LogicBookContent getLogicBookContentByTitleId(Long titleId);

    /**
     * 查询书内容列表
     * 
     * @param logicBookContent 书内容
     * @return 书内容集合
     */
    public List<LogicBookContent> selectLogicBookContentList(LogicBookContent logicBookContent);

    /**
     * 新增书内容
     * 
     * @param logicBookContent 书内容
     * @return 结果
     */
    public int insertLogicBookContent(LogicBookContent logicBookContent);

    /**
     * 修改书内容
     * 
     * @param logicBookContent 书内容
     * @return 结果
     */
    public int updateLogicBookContent(LogicBookContent logicBookContent);

    /**
     * 批量删除书内容
     * 
     * @param contentIds 需要删除的书内容主键集合
     * @return 结果
     */
    public int deleteLogicBookContentByContentIds(String contentIds);

    /**
     * 删除书内容信息
     * 
     * @param contentId 书内容主键
     * @return 结果
     */
    public int deleteLogicBookContentByContentId(Long contentId);
}
