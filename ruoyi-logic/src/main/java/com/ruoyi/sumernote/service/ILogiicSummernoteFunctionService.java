package com.ruoyi.sumernote.service;

import java.util.List;
import com.ruoyi.sumernote.domain.LogiicSummernoteFunction;

/**
 * 富文本快捷指令Service接口
 * 
 * @author ruoyi
 * @date 2022-03-22
 */
public interface ILogiicSummernoteFunctionService 
{
    /**
     * 查询富文本快捷指令
     * 
     * @param id 富文本快捷指令主键
     * @return 富文本快捷指令
     */
    public LogiicSummernoteFunction selectLogiicSummernoteFunctionById(Long id);

    /**
     * 查询富文本快捷指令列表
     * 
     * @param logiicSummernoteFunction 富文本快捷指令
     * @return 富文本快捷指令集合
     */
    public List<LogiicSummernoteFunction> selectLogiicSummernoteFunctionList(LogiicSummernoteFunction logiicSummernoteFunction);

    /**
     * 新增富文本快捷指令
     * 
     * @param logiicSummernoteFunction 富文本快捷指令
     * @return 结果
     */
    public int insertLogiicSummernoteFunction(LogiicSummernoteFunction logiicSummernoteFunction);

    /**
     * 修改富文本快捷指令
     * 
     * @param logiicSummernoteFunction 富文本快捷指令
     * @return 结果
     */
    public int updateLogiicSummernoteFunction(LogiicSummernoteFunction logiicSummernoteFunction);

    /**
     * 批量删除富文本快捷指令
     * 
     * @param ids 需要删除的富文本快捷指令主键集合
     * @return 结果
     */
    public int deleteLogiicSummernoteFunctionByIds(String ids);

    /**
     * 删除富文本快捷指令信息
     * 
     * @param id 富文本快捷指令主键
     * @return 结果
     */
    public int deleteLogiicSummernoteFunctionById(Long id);
}
