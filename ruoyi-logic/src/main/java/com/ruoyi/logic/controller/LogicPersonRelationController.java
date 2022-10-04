package com.ruoyi.logic.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.ruoyi.common.core.domain.entity.SysDictData;
import com.ruoyi.common.utils.DictUtils;
import com.ruoyi.logic.domain.LogicMeta;
import com.ruoyi.logic.domain.LogicPersonRelationTreeVo;
import com.ruoyi.logic.domain.LogicPersonRelationVo;
import com.ruoyi.logic.service.ILogicMetaService;
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
import com.ruoyi.logic.domain.LogicPersonRelation;
import com.ruoyi.logic.dto.LogicPersonRelationDTO;
import com.ruoyi.logic.service.ILogicPersonRelationService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 人物关系Controller
 * 
 * @author ruoyi
 * @date 2022-02-18
 */
@Controller
@RequestMapping("/logic/relation")
public class LogicPersonRelationController extends BaseController
{
    private String prefix = "logic/relation";

    @Autowired
    private ILogicPersonRelationService logicPersonRelationService;

    @Autowired
    private ILogicMetaService metaService;

    @RequiresPermissions("logic:relation:view")
    @GetMapping()
    public String relation(Long metaId, ModelMap mmap)
    {
        LogicMeta meta = metaService.selectLogicMetaByMetaId(metaId);
        mmap.addAttribute("name", meta.getName());
        mmap.addAttribute("metaId", metaId);
        mmap.addAttribute("bookKey", meta.getBookKey());
        return prefix + "/relation";
    }

    @GetMapping("/tree")
    @ResponseBody
    public List<LogicPersonRelationTreeVo> tree (String bookKey){
        List<LogicPersonRelationTreeVo> treeVos = new ArrayList<>();
        //获取元素类型
        List<SysDictData> dictDatas = DictUtils.getDictCache("book_meta");
        LogicPersonRelationTreeVo treeRoot = new LogicPersonRelationTreeVo();
        treeRoot.setId(99999999L);
        treeRoot.setpId(0L);
        treeRoot.setName("元素");
        treeRoot.setTitle("元素");
        treeVos.add(treeRoot);
        for (SysDictData dictData : dictDatas){
            LogicPersonRelationTreeVo treeBranch = new LogicPersonRelationTreeVo();
            treeBranch.setId(dictData.getDictCode()+90000000L);
            treeBranch.setpId(99999999L);
            treeBranch.setName(dictData.getDictLabel());
            treeBranch.setTitle(dictData.getDictLabel());
            treeVos.add(treeBranch);
            //按照元素分类查询
            LogicMeta metaParm = new LogicMeta();
            metaParm.setBookKey(bookKey);
            metaParm.setState(dictData.getDictValue());
            List<LogicMeta> metas = metaService.selectLogicMetaList(metaParm);
            for (LogicMeta meta : metas){
                LogicPersonRelationTreeVo treeLeaf = new LogicPersonRelationTreeVo();
                treeLeaf.setId(meta.getMetaId());
                treeLeaf.setpId(treeBranch.getId());
                treeLeaf.setName(meta.getName());
                treeLeaf.setTitle(meta.getName());
                treeVos.add(treeLeaf);
            }
        }

        return treeVos;
    }

    /**
     * 查询人物关系列表
     */
    @RequiresPermissions("logic:relation:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(LogicPersonRelationDTO logicPersonRelation)
    {
        startPage();
        List<LogicPersonRelation> list = logicPersonRelationService.selectLogicPersonRelationList(logicPersonRelation);
        return getDataTable(list);
    }

    @RequiresPermissions("logic:relation:list")
    @PostMapping("/listAll")
    @ResponseBody
    public List<LogicPersonRelationVo> queryAllRelation(LogicPersonRelationDTO logicPersonRelation){
        return logicPersonRelationService.queryAllList(logicPersonRelation);
    }

    /**
     * 导出人物关系列表
     */
    @RequiresPermissions("logic:relation:export")
    @Log(title = "人物关系", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(LogicPersonRelationDTO logicPersonRelation)
    {
        List<LogicPersonRelation> list = logicPersonRelationService.selectLogicPersonRelationList(logicPersonRelation);
        ExcelUtil<LogicPersonRelation> util = new ExcelUtil<LogicPersonRelation>(LogicPersonRelation.class);
        return util.exportExcel(list, "人物关系数据");
    }

    /**
     * 新增人物关系
     */
    @GetMapping("/add")
    public String add(Long personIdA, Long personIdB, String bookKey, ModelMap mmap)
    {
        mmap.addAttribute("personIdA", personIdA);
        mmap.addAttribute("personIdB", personIdB);
        mmap.addAttribute("bookKey", bookKey);
        return prefix + "/add";
    }

    /**
     * 新增保存人物关系
     */
    @RequiresPermissions("logic:relation:add")
    @Log(title = "人物关系", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(LogicPersonRelation logicPersonRelation)
    {
        return toAjax(logicPersonRelationService.insertLogicPersonRelation(logicPersonRelation));
    }

    /**
     * 修改人物关系
     */
    @RequiresPermissions("logic:relation:edit")
    @GetMapping("/edit/{relationId}")
    public String edit(@PathVariable("relationId") Long relationId, ModelMap mmap)
    {
        LogicPersonRelation logicPersonRelation = logicPersonRelationService.selectLogicPersonRelationByRelationId(relationId);
        mmap.put("logicPersonRelation", logicPersonRelation);
        return prefix + "/edit";
    }

    /**
     * 修改保存人物关系
     */
    @RequiresPermissions("logic:relation:edit")
    @Log(title = "人物关系", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(LogicPersonRelation logicPersonRelation)
    {
        return toAjax(logicPersonRelationService.updateLogicPersonRelation(logicPersonRelation));
    }

    /**
     * 删除人物关系
     */
    @RequiresPermissions("logic:relation:remove")
    @Log(title = "人物关系", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(logicPersonRelationService.deleteLogicPersonRelationByRelationIds(ids));
    }
}
