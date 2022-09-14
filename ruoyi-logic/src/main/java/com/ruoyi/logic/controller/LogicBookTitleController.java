package com.ruoyi.logic.controller;

import java.util.List;

import com.ruoyi.common.core.domain.entity.SysDictData;
import com.ruoyi.common.utils.DictUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.logic.domain.LogicBookTitle;
import com.ruoyi.logic.service.ILogicBookTitleService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 书的内容Controller
 * 
 * @author ruoyi
 * @date 2022-02-26
 */
@Controller
@RequestMapping("/logic/title")
public class LogicBookTitleController extends BaseController
{
    private String prefix = "logic/title";

    @Autowired
    private ILogicBookTitleService logicBookTitleService;

    @RequiresPermissions("logic:title:view")
    @GetMapping()
    public String title(String bookey, ModelMap mmap) {
        List<LogicBookTitle> bookChapters = logicBookTitleService.findByBookey(bookey);
        mmap.addAttribute("bookChapters", bookChapters);
        return prefix + "/title";
    }

    /**
     * 查询书的内容列表
     */
    @RequiresPermissions("logic:title:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(LogicBookTitle logicBookTitle)
    {
        startPage();
        List<LogicBookTitle> list = logicBookTitleService.selectLogicBookTitleList(logicBookTitle);
        return getDataTable(list);
    }

    /**
     * get book's chapter
     */
    @RequiresPermissions("logic:title:export")
    @Log(title = "书的内容", businessType = BusinessType.EXPORT)
    @GetMapping("/findChapters")
    @ResponseBody
    public AjaxResult findChapters(String bookey){
        List<SysDictData> dictDatas = DictUtils.getDictCache(bookey);

        return AjaxResult.success(dictDatas);
    }

    /**
     * 导出书的内容列表
     */
    @RequiresPermissions("logic:title:export")
    @Log(title = "书的内容", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(LogicBookTitle logicBookTitle)
    {
        List<LogicBookTitle> list = logicBookTitleService.selectLogicBookTitleList(logicBookTitle);
        ExcelUtil<LogicBookTitle> util = new ExcelUtil<LogicBookTitle>(LogicBookTitle.class);
        return util.exportExcel(list, "书的内容数据");
    }

    /**
     * 新增书的内容
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存书的内容
     */
    @RequiresPermissions("logic:title:add")
    @Log(title = "书的内容", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(LogicBookTitle logicBookTitle)
    {
        return toAjax(logicBookTitleService.insertLogicBookTitle(logicBookTitle));
    }

    /**
     * 修改书的内容
     */
    @RequiresPermissions("logic:title:edit")
    @GetMapping("/edit/{titleId}")
    public String edit(@PathVariable("titleId") Long titleId, ModelMap mmap)
    {
        LogicBookTitle logicBookTitle = logicBookTitleService.selectLogicBookTitleByTitleId(titleId);
        mmap.put("logicBookTitle", logicBookTitle);
        return prefix + "/edit";
    }

    /**
     * 修改保存书的内容
     */
    @RequiresPermissions("logic:title:edit")
    @Log(title = "书的内容", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(LogicBookTitle logicBookTitle)
    {
        return toAjax(logicBookTitleService.updateLogicBookTitle(logicBookTitle));
    }

    /**
     * 删除书的内容
     */
    @RequiresPermissions("logic:title:remove")
    @Log(title = "书的内容", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(logicBookTitleService.deleteLogicBookTitleByTitleIds(ids));
    }
}
