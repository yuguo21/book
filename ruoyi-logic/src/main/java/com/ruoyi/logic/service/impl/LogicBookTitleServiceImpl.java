package com.ruoyi.logic.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.logic.mapper.LogicBookTitleMapper;
import com.ruoyi.logic.domain.LogicBookTitle;
import com.ruoyi.logic.service.ILogicBookTitleService;
import com.ruoyi.common.core.text.Convert;

/**
 * 书的内容Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-02-26
 */
@Service
public class LogicBookTitleServiceImpl implements ILogicBookTitleService 
{
    @Autowired
    private LogicBookTitleMapper logicBookTitleMapper;

    /**
     * 查询书的内容
     * 
     * @param titleId 书的内容主键
     * @return 书的内容
     */
    @Override
    public LogicBookTitle selectLogicBookTitleByTitleId(Long titleId)
    {
        return logicBookTitleMapper.selectLogicBookTitleByTitleId(titleId);
    }

    @Override
    public List<LogicBookTitle> findByBookey(String bookey) {
        LogicBookTitle bookTitle = new LogicBookTitle();
        bookTitle.setBookKey(bookey);

        return logicBookTitleMapper.selectLogicBookTitleList(bookTitle);
    }

    /**
     * 查询书的内容列表
     * 
     * @param logicBookTitle 书的内容
     * @return 书的内容
     */
    @Override
    public List<LogicBookTitle> selectLogicBookTitleList(LogicBookTitle logicBookTitle)
    {
        return logicBookTitleMapper.selectLogicBookTitleList(logicBookTitle);
    }

    /**
     * 新增书的内容
     * 
     * @param logicBookTitle 书的内容
     * @return 结果
     */
    @Override
    public int insertLogicBookTitle(LogicBookTitle logicBookTitle)
    {
        logicBookTitle.setCreateTime(DateUtils.getNowDate());
        return logicBookTitleMapper.insertLogicBookTitle(logicBookTitle);
    }

    /**
     * 修改书的内容
     * 
     * @param logicBookTitle 书的内容
     * @return 结果
     */
    @Override
    public int updateLogicBookTitle(LogicBookTitle logicBookTitle)
    {
        logicBookTitle.setUpdateTime(DateUtils.getNowDate());
        return logicBookTitleMapper.updateLogicBookTitle(logicBookTitle);
    }

    /**
     * 批量删除书的内容
     * 
     * @param titleIds 需要删除的书的内容主键
     * @return 结果
     */
    @Override
    public int deleteLogicBookTitleByTitleIds(String titleIds)
    {
        return logicBookTitleMapper.deleteLogicBookTitleByTitleIds(Convert.toStrArray(titleIds));
    }

    /**
     * 删除书的内容信息
     * 
     * @param titleId 书的内容主键
     * @return 结果
     */
    @Override
    public int deleteLogicBookTitleByTitleId(Long titleId)
    {
        return logicBookTitleMapper.deleteLogicBookTitleByTitleId(titleId);
    }
}
