package com.ruoyi.system.controller.abs;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.UrDynamicSql;
import com.ruoyi.system.service.IUrDynamicSqlService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 动态sqlController 抽象层
 *
 * @author natsuki_kining
 * @date 2020-10-14
 */
public abstract class AbstractUrDynamicSqlController extends BaseController {
    protected final String prefix = "system/sql" ;

    @Autowired
    protected IUrDynamicSqlService urDynamicSqlService;

    @RequiresPermissions("system:sql:view" )
    @GetMapping()
    public String sql() {
        return prefix + "/sql" ;
    }

    /**
     * 查询动态sql列表
     */
    @RequiresPermissions("system:sql:list" )
    @PostMapping("/list" )
    @ResponseBody
    public TableDataInfo list(UrDynamicSql urDynamicSql) {
        startPage();
        List<UrDynamicSql> list = urDynamicSqlService.selectUrDynamicSqlList(urDynamicSql);
        return getDataTable(list);
    }

    /**
     * 导出动态sql列表
     */
    @RequiresPermissions("system:sql:export" )
    @Log(title = "动态sql" , businessType = BusinessType.EXPORT)
    @PostMapping("/export" )
    @ResponseBody
    public AjaxResult export(UrDynamicSql urDynamicSql) {
        List<UrDynamicSql> list = urDynamicSqlService.selectUrDynamicSqlList(urDynamicSql);
        ExcelUtil<UrDynamicSql> util = new ExcelUtil<UrDynamicSql>(UrDynamicSql. class);
        return util.exportExcel(list, "sql" );
    }

    /**
     * 新增动态sql
     */
    @GetMapping("/add" )
    public String add() {
        return prefix + "/add" ;
    }

    /**
     * 新增保存动态sql
     */
    @RequiresPermissions("system:sql:add" )
    @Log(title = "动态sql" , businessType = BusinessType.INSERT)
    @PostMapping("/add" )
    @ResponseBody
    public AjaxResult addSave(UrDynamicSql urDynamicSql) {
        return toAjax(urDynamicSqlService.insertUrDynamicSql(urDynamicSql));
    }

    /**
     * 修改动态sql
     */
    @GetMapping("/edit/{id}" )
    public String edit(@PathVariable("id" ) String id, ModelMap mmap) {
        UrDynamicSql urDynamicSql =urDynamicSqlService.selectUrDynamicSqlById(id);
        mmap.put("urDynamicSql" , urDynamicSql);
        return prefix + "/edit" ;
    }

    /**
     * 修改保存动态sql
     */
    @RequiresPermissions("system:sql:edit" )
    @Log(title = "动态sql" , businessType = BusinessType.UPDATE)
    @PostMapping("/edit" )
    @ResponseBody
    public AjaxResult editSave(UrDynamicSql urDynamicSql) {
        return toAjax(urDynamicSqlService.updateUrDynamicSql(urDynamicSql));
    }

    /**
     * 删除动态sql
     */
    @RequiresPermissions("system:sql:remove" )
    @Log(title = "动态sql" , businessType = BusinessType.DELETE)
    @PostMapping("/remove" )
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(urDynamicSqlService.deleteUrDynamicSqlByIds(ids));
    }

}
