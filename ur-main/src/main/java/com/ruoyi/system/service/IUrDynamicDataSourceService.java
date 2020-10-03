package com.ruoyi.system.service;

import com.ruoyi.system.domain.UrDynamicDataSource;
import com.ruoyi.system.service.base.IUrDynamicDataSourceBaseService;

/**
 * 动态数据源Service接口
 * 
 * @author natsuki_kining
 * @date 2020-10-14
 */
public interface IUrDynamicDataSourceService extends IUrDynamicDataSourceBaseService {

    /**
     * 启动数据源
     * @param urDynamicDataSource
     * @return
     */
    boolean startDataSource(UrDynamicDataSource urDynamicDataSource);

    /**
     * 关闭数据源
     * @param urDynamicDataSource
     * @return
     */
    boolean shutdownDataSource(UrDynamicDataSource urDynamicDataSource);
}
