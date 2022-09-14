package com.ruoyi.sumernote.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import cn.hutool.core.util.XmlUtil;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.sumernote.domain.LogiicSummernoteFunction;
import com.ruoyi.sumernote.service.ILogiicSummernoteFunctionService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 富文本快捷指令Controller
 * 
 * @author ruoyi
 * @date 2022-03-22
 */
@Controller
@RequestMapping("/summernote/function")
public class LogiicSummernoteFunctionController extends BaseController
{
    private String prefix = "sumernote/function";

    @Autowired
    private ILogiicSummernoteFunctionService logiicSummernoteFunctionService;



    @RequiresPermissions("sumernote:function:view")
    @GetMapping()
    public String function()
    {
        return prefix + "/function";
    }

    /**
     * 查询富文本快捷指令列表
     */
    @RequiresPermissions("sumernote:function:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(LogiicSummernoteFunction logiicSummernoteFunction)
    {
        startPage();
        List<LogiicSummernoteFunction> list = logiicSummernoteFunctionService.selectLogiicSummernoteFunctionList(logiicSummernoteFunction);
        return getDataTable(list);
    }

    /**
     * 关键字指令查询
     */
    @RequiresPermissions("sumernote:function:list")
    @PostMapping("/one")
    @ResponseBody
    public Map<String, Object> one(LogiicSummernoteFunction logiicSummernoteFunction)
    {
        List<LogiicSummernoteFunction> list = logiicSummernoteFunctionService.selectLogiicSummernoteFunctionList(logiicSummernoteFunction);
        
        if (list != null && list.size()>0){
            return resultEntity(200, "接收成功", list.get(0));
        }

        return resultEntity(400, "为查找到相关数据", null);
    }

    /**
     * 保存
     */
    @RequiresPermissions("sumernote:function:list")
    @PostMapping("/save")
    @ResponseBody
    public Map<String, Object> saveContent(String bookKey, Long titleId, String summernote){
        //Document doc = XmlUtil.readXML(summernote);
        Document doc = XmlUtil.parseXml(summernote);
        Node node = doc.getFirstChild();
        String str = node.getTextContent();
        if (str != null && str.trim().equals("")){

        }
        return null;
    }

    /**
     * 关键字迭代
     * @param logiicSummernoteFunction
     * @return
     */
    @RequiresPermissions("sumernote:function:list")
    @PostMapping("/keywords")
    @ResponseBody
    public Map<String, Object> keywords(LogiicSummernoteFunction logiicSummernoteFunction)
    {
        List<LogiicSummernoteFunction> list = logiicSummernoteFunctionService.selectLogiicSummernoteFunctionList(logiicSummernoteFunction);
        
        if (list != null && list.size()>0){
            List<String> keywords = new ArrayList<String>();
            for (LogiicSummernoteFunction entity : list){
                keywords.add(entity.getName());
            }
            return resultEntity(200, "接收成功", keywords);
        }

        return resultEntity(400, "为查找到相关数据", null);
    }

    /**
     * 导出富文本快捷指令列表
     */
    @RequiresPermissions("sumernote:function:export")
    @Log(title = "富文本快捷指令", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(LogiicSummernoteFunction logiicSummernoteFunction)
    {
        List<LogiicSummernoteFunction> list = logiicSummernoteFunctionService.selectLogiicSummernoteFunctionList(logiicSummernoteFunction);
        ExcelUtil<LogiicSummernoteFunction> util = new ExcelUtil<LogiicSummernoteFunction>(LogiicSummernoteFunction.class);
        return util.exportExcel(list, "富文本快捷指令数据");
    }

    /**
     * 新增富文本快捷指令
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存富文本快捷指令
     */
    @RequiresPermissions("sumernote:function:add")
    @Log(title = "富文本快捷指令", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(LogiicSummernoteFunction logiicSummernoteFunction)
    {
        return toAjax(logiicSummernoteFunctionService.insertLogiicSummernoteFunction(logiicSummernoteFunction));
    }

    /**
     * 修改富文本快捷指令
     */
    @RequiresPermissions("sumernote:function:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        LogiicSummernoteFunction logiicSummernoteFunction = logiicSummernoteFunctionService.selectLogiicSummernoteFunctionById(id);
        mmap.put("logiicSummernoteFunction", logiicSummernoteFunction);
        return prefix + "/edit";
    }

    /**
     * 修改保存富文本快捷指令
     */
    @RequiresPermissions("sumernote:function:edit")
    @Log(title = "富文本快捷指令", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(LogiicSummernoteFunction logiicSummernoteFunction)
    {
        return toAjax(logiicSummernoteFunctionService.updateLogiicSummernoteFunction(logiicSummernoteFunction));
    }

    /**
     * 删除富文本快捷指令
     */
    @RequiresPermissions("sumernote:function:remove")
    @Log(title = "富文本快捷指令", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(logiicSummernoteFunctionService.deleteLogiicSummernoteFunctionByIds(ids));
    }

}
