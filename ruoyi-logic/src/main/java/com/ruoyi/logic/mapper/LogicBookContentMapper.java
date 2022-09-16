package com.ruoyi.logic.mapper;

import java.util.List;
import com.ruoyi.logic.domain.LogicBookContent;
import org.apache.ibatis.annotations.Mapper;

/**
 * 书内容Mapper接口
 * 
 * @author ruoyi
 * @date 2022-03-01
 */
@Mapper
public interface LogicBookContentMapper 
{
    /**
     * 查询书内容
     * 
     * @param contentId 书内容主键
     * @return 书内容
     */
    public LogicBookContent selectLogicBookContentByContentId(Long contentId);

    /**
     * 获取内容
     * @param logicBookContent
     * @return
     */
    public LogicBookContent selectLogicBookContent(LogicBookContent logicBookContent);

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
     * 删除书内容
     * 
     * @param contentId 书内容主键
     * @return 结果
     */
    public int deleteLogicBookContentByContentId(Long contentId);

    /**
     * 批量删除书内容
     * 
     * @param contentIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteLogicBookContentByContentIds(String[] contentIds);
}
