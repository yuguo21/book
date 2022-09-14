package com.ruoyi.sumernote.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.sumernote.mapper.LogiicSummernoteFunctionMapper;
import com.ruoyi.sumernote.domain.LogiicSummernoteFunction;
import com.ruoyi.sumernote.service.ILogiicSummernoteFunctionService;
import com.ruoyi.common.core.text.Convert;

/**
 * 富文本快捷指令Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-03-22
 */
@Service
public class LogiicSummernoteFunctionServiceImpl implements ILogiicSummernoteFunctionService 
{
    @Autowired
    private LogiicSummernoteFunctionMapper logiicSummernoteFunctionMapper;

    /**
     * 查询富文本快捷指令
     * 
     * @param id 富文本快捷指令主键
     * @return 富文本快捷指令
     */
    @Override
    public LogiicSummernoteFunction selectLogiicSummernoteFunctionById(Long id)
    {
        return logiicSummernoteFunctionMapper.selectLogiicSummernoteFunctionById(id);
    }

    /**
     * 查询富文本快捷指令列表
     * 
     * @param logiicSummernoteFunction 富文本快捷指令
     * @return 富文本快捷指令
     */
    @Override
    public List<LogiicSummernoteFunction> selectLogiicSummernoteFunctionList(LogiicSummernoteFunction logiicSummernoteFunction)
    {
        return logiicSummernoteFunctionMapper.selectLogiicSummernoteFunctionList(logiicSummernoteFunction);
    }

    /**
     * 新增富文本快捷指令
     * 
     * @param logiicSummernoteFunction 富文本快捷指令
     * @return 结果
     */
    @Override
    public int insertLogiicSummernoteFunction(LogiicSummernoteFunction logiicSummernoteFunction)
    {
        logiicSummernoteFunction.setCreateTime(DateUtils.getNowDate());
        return logiicSummernoteFunctionMapper.insertLogiicSummernoteFunction(logiicSummernoteFunction);
    }

    /**
     * 修改富文本快捷指令
     * 
     * @param logiicSummernoteFunction 富文本快捷指令
     * @return 结果
     */
    @Override
    public int updateLogiicSummernoteFunction(LogiicSummernoteFunction logiicSummernoteFunction)
    {
        logiicSummernoteFunction.setUpdateTime(DateUtils.getNowDate());
        return logiicSummernoteFunctionMapper.updateLogiicSummernoteFunction(logiicSummernoteFunction);
    }

    /**
     * 批量删除富文本快捷指令
     * 
     * @param ids 需要删除的富文本快捷指令主键
     * @return 结果
     */
    @Override
    public int deleteLogiicSummernoteFunctionByIds(String ids)
    {
        return logiicSummernoteFunctionMapper.deleteLogiicSummernoteFunctionByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除富文本快捷指令信息
     * 
     * @param id 富文本快捷指令主键
     * @return 结果
     */
    @Override
    public int deleteLogiicSummernoteFunctionById(Long id)
    {
        return logiicSummernoteFunctionMapper.deleteLogiicSummernoteFunctionById(id);
    }
}
