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
import com.ruoyi.logic.domain.LogicMeta;
import com.ruoyi.logic.service.ILogicMetaService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 书中元素Controller
 * 
 * @author ruoyi
 * @date 2022-02-22
 */
@Controller
@RequestMapping("/logic/meta")
public class LogicMetaController extends BaseController
{
    private String prefix = "logic/meta";

    @Autowired
    private ILogicMetaService logicMetaService;

    @RequiresPermissions("logic:meta:view")
    @GetMapping()
    public String meta(String bookKey, ModelMap mmap)
    {
        mmap.addAttribute("bookKey", bookKey);

        return prefix + "/meta";
    }

    /**
     * 查询书中元素列表
     */
    @RequiresPermissions("logic:meta:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(LogicMeta logicMeta)
    {
        startPage();
        List<LogicMeta> list = logicMetaService.selectLogicMetaList(logicMeta);
        return getDataTable(list);
    }

    /**
     * 导出书中元素列表
     */
    @RequiresPermissions("logic:meta:export")
    @Log(title = "书中元素", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(LogicMeta logicMeta)
    {
        List<LogicMeta> list = logicMetaService.selectLogicMetaList(logicMeta);
        ExcelUtil<LogicMeta> util = new ExcelUtil<LogicMeta>(LogicMeta.class);
        return util.exportExcel(list, "书中元素数据");
    }

    /**
     * 新增书中元素
     */
    @GetMapping("/add")
    public String add(String bookKey, ModelMap mmap)
    {
        mmap.addAttribute("bookKey", bookKey);
        return prefix + "/add";
    }

    /**
     * 新增保存书中元素
     */
    @RequiresPermissions("logic:meta:add")
    @Log(title = "书中元素", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(LogicMeta logicMeta)
    {
        return toAjax(logicMetaService.insertLogicMeta(logicMeta));
    }

    /**
     * 修改书中元素
     */
    @RequiresPermissions("logic:meta:edit")
    @GetMapping("/edit/{metaId}")
    public String edit(@PathVariable("metaId") Long metaId, ModelMap mmap)
    {
        LogicMeta logicMeta = logicMetaService.selectLogicMetaByMetaId(metaId);
        mmap.put("logicMeta", logicMeta);
        return prefix + "/edit";
    }

    /**
     * 修改保存书中元素
     */
    @RequiresPermissions("logic:meta:edit")
    @Log(title = "书中元素", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(LogicMeta logicMeta)
    {
        return toAjax(logicMetaService.updateLogicMeta(logicMeta));
    }

    /**
     * 删除书中元素
     */
    @RequiresPermissions("logic:meta:remove")
    @Log(title = "书中元素", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(logicMetaService.deleteLogicMetaByMetaIds(ids));
    }
}