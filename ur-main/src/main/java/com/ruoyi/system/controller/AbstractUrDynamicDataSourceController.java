package com.ruoyi.system.controller;

import com.natsuki_kining.ssr.core.config.properties.SSRDruidProperties;
import com.natsuki_kining.ur.manager.datasource.DynamicDataSourceService;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.UrDynamicDataSource;
import com.ruoyi.system.service.IUrDynamicDataSourceService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 动态数据源Controller
 *
 * @author natsuki_kining
 * @date 2020-10-10
 */
public abstract class AbstractUrDynamicDataSourceController extends BaseController {

    @Autowired
    private DynamicDataSourceService dynamicDataSourceService;

    @Autowired
    protected IUrDynamicDataSourceService urDynamicDataSourceService;

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
        return toAjax(dynamicDataSourceService.startDataSource(dynamicDataSource));
    }

}
