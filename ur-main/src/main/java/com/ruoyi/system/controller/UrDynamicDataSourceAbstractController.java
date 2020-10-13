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
import com.ruoyi.system.domain.UrDynamicDataSource;
import com.ruoyi.system.service.IUrDynamicDataSourceService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 动态数据源Controller 抽象层
 *
 * @author natsuki_kining
 * @date 2020-10-13
 */
public abstract class UrDynamicDataSourceAbstractController extends BaseController {
    private final String prefix = "system/datasource" ;

    @Autowired
    private IUrDynamicDataSourceService urDynamicDataSourceService;

    @RequiresPermissions("system:datasource:view" )
    @GetMapping()
    public String datasource() {
        return prefix + "/datasource" ;
    }

    /**
     * 查询动态数据源列表
     */
    @RequiresPermissions("system:datasource:list" )
    @PostMapping("/list" )
    @ResponseBody
    public TableDataInfo list(UrDynamicDataSource urDynamicDataSource) {
        startPage();
        List<UrDynamicDataSource> list = urDynamicDataSourceService.selectUrDynamicDataSourceList(urDynamicDataSource);
        return getDataTable(list);
    }

    /**
     * 导出动态数据源列表
     */
    @RequiresPermissions("system:datasource:export" )
    @Log(title = "动态数据源" , businessType = BusinessType.EXPORT)
    @PostMapping("/export" )
    @ResponseBody
    public AjaxResult export(UrDynamicDataSource urDynamicDataSource) {
        List<UrDynamicDataSource> list = urDynamicDataSourceService.selectUrDynamicDataSourceList(urDynamicDataSource);
        ExcelUtil<UrDynamicDataSource> util = new ExcelUtil<UrDynamicDataSource>(UrDynamicDataSource. class);
        return util.exportExcel(list, "datasource" );
    }

    /**
     * 新增动态数据源
     */
    @GetMapping("/add" )
    public String add() {
        return prefix + "/add" ;
    }

    /**
     * 新增保存动态数据源
     */
    @RequiresPermissions("system:datasource:add" )
    @Log(title = "动态数据源" , businessType = BusinessType.INSERT)
    @PostMapping("/add" )
    @ResponseBody
    public AjaxResult addSave(UrDynamicDataSource urDynamicDataSource) {
        return toAjax(urDynamicDataSourceService.insertUrDynamicDataSource(urDynamicDataSource));
    }

    /**
     * 修改动态数据源
     */
    @GetMapping("/edit/{id}" )
    public String edit(@PathVariable("id" ) Long id, ModelMap mmap) {
        UrDynamicDataSource urDynamicDataSource =urDynamicDataSourceService.selectUrDynamicDataSourceById(id);
        mmap.put("urDynamicDataSource" , urDynamicDataSource);
        return prefix + "/edit" ;
    }

    /**
     * 修改保存动态数据源
     */
    @RequiresPermissions("system:datasource:edit" )
    @Log(title = "动态数据源" , businessType = BusinessType.UPDATE)
    @PostMapping("/edit" )
    @ResponseBody
    public AjaxResult editSave(UrDynamicDataSource urDynamicDataSource) {
        return toAjax(urDynamicDataSourceService.updateUrDynamicDataSource(urDynamicDataSource));
    }

    /**
     * 删除动态数据源
     */
    @RequiresPermissions("system:datasource:remove" )
    @Log(title = "动态数据源" , businessType = BusinessType.DELETE)
    @PostMapping("/remove" )
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(urDynamicDataSourceService.deleteUrDynamicDataSourceByIds(ids));
    }

}
