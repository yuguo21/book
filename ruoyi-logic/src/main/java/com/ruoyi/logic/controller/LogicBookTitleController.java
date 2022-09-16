package com.ruoyi.logic.controller;

import java.util.ArrayList;
import java.util.List;

import com.ruoyi.common.core.domain.entity.SysDictData;
import com.ruoyi.common.utils.DictUtils;
import com.ruoyi.logic.domain.LogicBookContent;
import com.ruoyi.logic.domain.LogicBookTitleTreeVo;
import com.ruoyi.logic.service.ILogicBookContentService;
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
    @Autowired
    private ILogicBookContentService logicBookContentService;

    @RequiresPermissions("logic:title:view")
    @GetMapping()
    public String title(String bookKey, ModelMap mmap) {
        mmap.addAttribute("bookKey", bookKey);
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
    public String add(String bookKey, ModelMap mmap)
    {
        mmap.addAttribute("bookKey", bookKey);
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
     * get chapter tree
     * @param bookKey
     * @return
     */
    @GetMapping("/tree")
    @ResponseBody
    public List<LogicBookTitleTreeVo> tree(String bookKey){
        List<LogicBookTitle> chapters = logicBookTitleService.findByBookey(bookKey);
        List<LogicBookTitleTreeVo> treeVos = new ArrayList<>(chapters.size()+1);
        LogicBookTitleTreeVo treeRoot = new LogicBookTitleTreeVo();
        treeRoot.setId(99999999L);
        treeRoot.setpId(0L);
        treeRoot.setName("章节");
        treeRoot.setTitle("章节");
        treeVos.add(treeRoot);
        for (LogicBookTitle charpter : chapters){
            LogicBookTitleTreeVo tmpChapter = new LogicBookTitleTreeVo();
            tmpChapter.setId(charpter.getTitleId());
            tmpChapter.setpId(99999999L);
            tmpChapter.setName(charpter.getTitle());
            tmpChapter.setTitle(charpter.getTitle());
            treeVos.add(tmpChapter);
        }
        return treeVos;
    }

    @GetMapping("getContent")
    @ResponseBody
    public AjaxResult getContent(Long titleId){
        LogicBookContent content = logicBookContentService.getLogicBookContentByTitleId(titleId);
        return AjaxResult.success(content);
    }

    /**
     * 新增保存书内容
     */
    @RequiresPermissions("logic:content:add")
    @Log(title = "书内容", businessType = BusinessType.INSERT)
    @PostMapping("/addContent")
    @ResponseBody
    public AjaxResult addContent(LogicBookContent logicBookContent)
    {
        Long titleId = logicBookContent.getTitleId();
        LogicBookContent bookContent = logicBookContentService.getLogicBookContentByTitleId(titleId);
        if (bookContent == null){
            return toAjax(logicBookContentService.insertLogicBookContent(logicBookContent));
        }else{
            bookContent.setContent(logicBookContent.getContent());
            return toAjax(logicBookContentService.updateLogicBookContent(bookContent));
        }
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
