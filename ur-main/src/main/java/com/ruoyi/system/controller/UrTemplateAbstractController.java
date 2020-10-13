package com.ruoyi.system.controller;

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
import com.ruoyi.system.domain.UrTemplate;
import com.ruoyi.system.service.IUrTemplateService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 模板Controller 抽象层
 *
 * @author natsuki_kining
 * @date 2020-10-13
 */
public abstract class UrTemplateAbstractController extends BaseController {
    private final String prefix = "system/template" ;

    @Autowired
    private IUrTemplateService urTemplateService;

    @RequiresPermissions("system:template:view" )
    @GetMapping()
    public String template() {
        return prefix + "/template" ;
    }

    /**
     * 查询模板列表
     */
    @RequiresPermissions("system:template:list" )
    @PostMapping("/list" )
    @ResponseBody
    public TableDataInfo list(UrTemplate urTemplate) {
        startPage();
        List<UrTemplate> list = urTemplateService.selectUrTemplateList(urTemplate);
        return getDataTable(list);
    }

    /**
     * 导出模板列表
     */
    @RequiresPermissions("system:template:export" )
    @Log(title = "模板" , businessType = BusinessType.EXPORT)
    @PostMapping("/export" )
    @ResponseBody
    public AjaxResult export(UrTemplate urTemplate) {
        List<UrTemplate> list = urTemplateService.selectUrTemplateList(urTemplate);
        ExcelUtil<UrTemplate> util = new ExcelUtil<UrTemplate>(UrTemplate. class);
        return util.exportExcel(list, "template" );
    }

    /**
     * 新增模板
     */
    @GetMapping("/add" )
    public String add() {
        return prefix + "/add" ;
    }

    /**
     * 新增保存模板
     */
    @RequiresPermissions("system:template:add" )
    @Log(title = "模板" , businessType = BusinessType.INSERT)
    @PostMapping("/add" )
    @ResponseBody
    public AjaxResult addSave(UrTemplate urTemplate) {
        return toAjax(urTemplateService.insertUrTemplate(urTemplate));
    }

    /**
     * 修改模板
     */
    @GetMapping("/edit/{id}" )
    public String edit(@PathVariable("id" ) String id, ModelMap mmap) {
        UrTemplate urTemplate =urTemplateService.selectUrTemplateById(id);
        mmap.put("urTemplate" , urTemplate);
        return prefix + "/edit" ;
    }

    /**
     * 修改保存模板
     */
    @RequiresPermissions("system:template:edit" )
    @Log(title = "模板" , businessType = BusinessType.UPDATE)
    @PostMapping("/edit" )
    @ResponseBody
    public AjaxResult editSave(UrTemplate urTemplate) {
        return toAjax(urTemplateService.updateUrTemplate(urTemplate));
    }

    /**
     * 删除模板
     */
    @RequiresPermissions("system:template:remove" )
    @Log(title = "模板" , businessType = BusinessType.DELETE)
    @PostMapping("/remove" )
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(urTemplateService.deleteUrTemplateByIds(ids));
    }

}
