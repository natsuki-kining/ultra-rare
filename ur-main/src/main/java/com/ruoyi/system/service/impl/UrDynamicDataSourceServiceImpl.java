package com.ruoyi.system.service.impl;

import com.alibaba.fastjson.JSON;
import com.natsuki_kining.ssr.core.config.multisource.MultiSourceConfig;
import com.natsuki_kining.ssr.core.config.properties.SSRDruidProperties;
import com.natsuki_kining.ssr.core.utils.CollectionUtils;
import com.natsuki_kining.ssr.core.utils.StringUtils;
import com.ruoyi.system.domain.UrDynamicDataSource;
import com.ruoyi.system.service.IUrDynamicDataSourceService;
import com.ruoyi.system.service.impl.abs.AbstractUrDynamicDataSourceServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * 动态数据源Service业务层处理
 * 
 * @author natsuki_kining
 * @date 2020-10-14
 */
@Service
public class UrDynamicDataSourceServiceImpl extends AbstractUrDynamicDataSourceServiceImpl implements IUrDynamicDataSourceService {

    private static final Logger logger = LoggerFactory.getLogger(UrDynamicDataSourceServiceImpl.class);

    @Autowired
    private IUrDynamicDataSourceService urDynamicDataSourceService;

    @Autowired
    private MultiSourceConfig multiSourceConfig;

    @PostConstruct
    public void initDataSource() {
        UrDynamicDataSource urDynamicDatasource = new UrDynamicDataSource();
        urDynamicDatasource.setDelFlag(0);
        List<UrDynamicDataSource> urDynamicDataSources = urDynamicDataSourceService.selectUrDynamicDataSourceList(urDynamicDatasource);
        if (CollectionUtils.isEmpty(urDynamicDataSources) || urDynamicDataSources.size() == 0) {
            logger.info("没有需要设置的数据源。");
            return;
        }
        StringBuilder info = new StringBuilder();
        urDynamicDataSources.forEach(ds -> {
            addDataSource(info,ds);
        });
        logger.info("初始化动态数据源表中的配置：");
        logger.info(info.toString());
    }

    @Override
    public boolean startDataSource(UrDynamicDataSource urDynamicDataSource) {
        StringBuilder info = new StringBuilder();
        boolean flag = addDataSource(info, urDynamicDataSource);
        logger.info(info.toString());
        return flag;
    }

    @Override
    public boolean shutdownDataSource(String dataSourceName) {
        return multiSourceConfig.removeDataSource(dataSourceName);
    }

    private boolean addDataSource(StringBuilder info,UrDynamicDataSource ds) {
        if (multiSourceConfig.containsDataSourceName(ds.getDataSourceName())){
            info.append("数据源");
            info.append(ds.getDataSourceName());
            info.append("已存在。");
            return false;
        }else{
            SSRDruidProperties druidProperties = null;
            if (StringUtils.isNotBlank(ds.getOtherConfig())) {
                druidProperties = JSON.parseObject(ds.getOtherConfig(), SSRDruidProperties.class);
            }
            if (druidProperties == null) {
                druidProperties = new SSRDruidProperties();
            }
            druidProperties.setDriverClassName(ds.getDriverClassName());
            druidProperties.setDataSourceName(ds.getDataSourceName());
            druidProperties.setPassword(ds.getPassword());
            druidProperties.setUsername(ds.getUserName());
            druidProperties.setUrl(ds.getUrl());
            boolean flag = multiSourceConfig.addDataSource(druidProperties);
            String message = flag ? "成功" : "失败";
            info.append(ds.getDataSourceName());
            info.append(" 数据源 新增 ");
            info.append(message);
            info.append("。");
            return flag;
        }
    }

}
