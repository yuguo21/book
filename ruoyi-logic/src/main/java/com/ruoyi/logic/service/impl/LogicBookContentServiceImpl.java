package com.ruoyi.logic.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.logic.mapper.LogicBookContentMapper;
import com.ruoyi.logic.domain.LogicBookContent;
import com.ruoyi.logic.service.ILogicBookContentService;
import com.ruoyi.common.core.text.Convert;

import javax.annotation.Resource;

/**
 * 书内容Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-03-01
 */
@Service
public class LogicBookContentServiceImpl implements ILogicBookContentService 
{
    @Resource
    private LogicBookContentMapper logicBookContentMapper;

    /**
     * 查询书内容
     * 
     * @param contentId 书内容主键
     * @return 书内容
     */
    @Override
    public LogicBookContent selectLogicBookContentByContentId(Long contentId)
    {
        return logicBookContentMapper.selectLogicBookContentByContentId(contentId);
    }

    @Override
    public LogicBookContent getLogicBookContentByTitleId(Long titleId) {
        LogicBookContent logicBookContent = new LogicBookContent();
        logicBookContent.setTitleId(titleId);
        return logicBookContentMapper.selectLogicBookContent(logicBookContent);
    }

    /**
     * 查询书内容列表
     * 
     * @param logicBookContent 书内容
     * @return 书内容
     */
    @Override
    public List<LogicBookContent> selectLogicBookContentList(LogicBookContent logicBookContent)
    {
        return logicBookContentMapper.selectLogicBookContentList(logicBookContent);
    }

    /**
     * 新增书内容
     * 
     * @param logicBookContent 书内容
     * @return 结果
     */
    @Override
    public int insertLogicBookContent(LogicBookContent logicBookContent)
    {
        logicBookContent.setCreateTime(DateUtils.getNowDate());
        return logicBookContentMapper.insertLogicBookContent(logicBookContent);
    }

    /**
     * 修改书内容
     * 
     * @param logicBookContent 书内容
     * @return 结果
     */
    @Override
    public int updateLogicBookContent(LogicBookContent logicBookContent)
    {
        logicBookContent.setUpdateTime(DateUtils.getNowDate());
        return logicBookContentMapper.updateLogicBookContent(logicBookContent);
    }

    /**
     * 批量删除书内容
     * 
     * @param contentIds 需要删除的书内容主键
     * @return 结果
     */
    @Override
    public int deleteLogicBookContentByContentIds(String contentIds)
    {
        return logicBookContentMapper.deleteLogicBookContentByContentIds(Convert.toStrArray(contentIds));
    }

    /**
     * 删除书内容信息
     * 
     * @param contentId 书内容主键
     * @return 结果
     */
    @Override
    public int deleteLogicBookContentByContentId(Long contentId)
    {
        return logicBookContentMapper.deleteLogicBookContentByContentId(contentId);
    }
}
