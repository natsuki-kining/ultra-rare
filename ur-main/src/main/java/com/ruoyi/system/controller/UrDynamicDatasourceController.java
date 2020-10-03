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
import com.ruoyi.system.domain.UrDynamicDatasource;
import com.ruoyi.system.service.IUrDynamicDatasourceService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 动态数据源Controller
 * 
 * @author natsuki_kining
 * @date 2020-10-03
 */
@Controller
@RequestMapping("/system/datasource")
public class UrDynamicDatasourceController extends BaseController
{
    private String prefix = "system/datasource";

    @Autowired
    private IUrDynamicDatasourceService urDynamicDatasourceService;

    @RequiresPermissions("system:datasource:view")
    @GetMapping()
    public String datasource()
    {
        return prefix + "/datasource";
    }

    /**
     * 查询动态数据源列表
     */
    @RequiresPermissions("system:datasource:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(UrDynamicDatasource urDynamicDatasource)
    {
        startPage();
        List<UrDynamicDatasource> list = urDynamicDatasourceService.selectUrDynamicDatasourceList(urDynamicDatasource);
        return getDataTable(list);
    }

    /**
     * 导出动态数据源列表
     */
    @RequiresPermissions("system:datasource:export")
    @Log(title = "动态数据源", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(UrDynamicDatasource urDynamicDatasource)
    {
        List<UrDynamicDatasource> list = urDynamicDatasourceService.selectUrDynamicDatasourceList(urDynamicDatasource);
        ExcelUtil<UrDynamicDatasource> util = new ExcelUtil<UrDynamicDatasource>(UrDynamicDatasource.class);
        return util.exportExcel(list, "datasource");
    }

    /**
     * 新增动态数据源
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存动态数据源
     */
    @RequiresPermissions("system:datasource:add")
    @Log(title = "动态数据源", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(UrDynamicDatasource urDynamicDatasource)
    {
        return toAjax(urDynamicDatasourceService.insertUrDynamicDatasource(urDynamicDatasource));
    }

    /**
     * 修改动态数据源
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        UrDynamicDatasource urDynamicDatasource = urDynamicDatasourceService.selectUrDynamicDatasourceById(id);
        mmap.put("urDynamicDatasource", urDynamicDatasource);
        return prefix + "/edit";
    }

    /**
     * 修改保存动态数据源
     */
    @RequiresPermissions("system:datasource:edit")
    @Log(title = "动态数据源", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(UrDynamicDatasource urDynamicDatasource)
    {
        return toAjax(urDynamicDatasourceService.updateUrDynamicDatasource(urDynamicDatasource));
    }

    /**
     * 删除动态数据源
     */
    @RequiresPermissions("system:datasource:remove")
    @Log(title = "动态数据源", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(urDynamicDatasourceService.deleteUrDynamicDatasourceByIds(ids));
    }
}
