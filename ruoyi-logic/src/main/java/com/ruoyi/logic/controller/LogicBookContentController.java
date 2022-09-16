package com.ruoyi.logic.controller;

import java.util.List;
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
import com.ruoyi.logic.domain.LogicBookContent;
import com.ruoyi.logic.service.ILogicBookContentService;
import com.ruoyi.logic.service.ILogicBookTitleService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 书内容Controller
 * 
 * @author ruoyi
 * @date 2022-03-01
 */
@Controller
@RequestMapping("/logic/content")
public class LogicBookContentController extends BaseController
{
    private String prefix = "logic/content";

    @Autowired
    private ILogicBookContentService logicBookContentService;

    @Autowired
    private ILogicBookTitleService logicBookTitleService;
    
    
    
    @RequiresPermissions("logic:content:view")
    @GetMapping()
    public String content()
    {
        return prefix + "/content";
    }

    /**
     * 查询书内容列表
     */
    @RequiresPermissions("logic:content:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(LogicBookContent logicBookContent)
    {
        startPage();
        List<LogicBookContent> list = logicBookContentService.selectLogicBookContentList(logicBookContent);
        return getDataTable(list);
    }

    /**
     * 导出书内容列表
     */
    @RequiresPermissions("logic:content:export")
    @Log(title = "书内容", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(LogicBookContent logicBookContent)
    {
        List<LogicBookContent> list = logicBookContentService.selectLogicBookContentList(logicBookContent);
        ExcelUtil<LogicBookContent> util = new ExcelUtil<LogicBookContent>(LogicBookContent.class);
        return util.exportExcel(list, "书内容数据");
    }

    /**
     * 新增书内容
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存书内容
     */
    @RequiresPermissions("logic:content:add")
    @Log(title = "书内容", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(LogicBookContent logicBookContent)
    {
        return toAjax(logicBookContentService.insertLogicBookContent(logicBookContent));
    }

    /**
     * 修改书内容
     */
    @RequiresPermissions("logic:content:edit")
    @GetMapping("/edit/{contentId}")
    public String edit(@PathVariable("contentId") Long contentId, ModelMap mmap)
    {
        LogicBookContent logicBookContent = logicBookContentService.selectLogicBookContentByContentId(contentId);
        mmap.put("logicBookContent", logicBookContent);
        return prefix + "/edit";
    }

    /**
     * 修改保存书内容
     */
    @RequiresPermissions("logic:content:edit")
    @Log(title = "书内容", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(LogicBookContent logicBookContent)
    {
        return toAjax(logicBookContentService.updateLogicBookContent(logicBookContent));
    }

    /**
     * 删除书内容
     */
    @RequiresPermissions("logic:content:remove")
    @Log(title = "书内容", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(logicBookContentService.deleteLogicBookContentByContentIds(ids));
    }

}
