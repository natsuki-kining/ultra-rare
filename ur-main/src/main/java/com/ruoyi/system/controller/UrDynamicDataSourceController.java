package com.ruoyi.system.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.UrDynamicDataSource;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ruoyi.system.controller.abs.AbstractUrDynamicDataSourceController;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 动态数据源Controller
 * 
 * @author natsuki_kining
 * @date 2020-10-14
 */
@Controller
@RequestMapping("/system/datasource")
public class UrDynamicDataSourceController extends AbstractUrDynamicDataSourceController {

    /**
     * 启动数据源
     *
     * @param urDynamicDataSource
     * @return
     */
    @RequiresPermissions("system:datasource:startDataSource")
    @Log(title = "启动数据源", businessType = BusinessType.OTHER)
    @PostMapping("/startDataSource")
    @ResponseBody
    public AjaxResult startDataSource(UrDynamicDataSource urDynamicDataSource) {
        UrDynamicDataSource dynamicDataSource = urDynamicDataSourceService.selectUrDynamicDataSourceById(urDynamicDataSource.getId());
        return toAjax(super.urDynamicDataSourceService.startDataSource(dynamicDataSource));
    }

    /**
     * 关闭数据源
     *
     * @param dataSourceName 数据源名称
     * @return
     */
    @RequiresPermissions("system:datasource:shutdownDataSource")
    @Log(title = "关闭数据源", businessType = BusinessType.OTHER)
    @PostMapping("/shutdownDataSource")
    @ResponseBody
    public AjaxResult shutdownDataSource(String dataSourceName) {
        return toAjax(super.urDynamicDataSourceService.shutdownDataSource(dataSourceName));
    }

}
