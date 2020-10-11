package com.natsuki_kining.ur.manager.datasource;

import com.alibaba.fastjson.JSON;
import com.natsuki_kining.ssr.core.config.multisource.MultiSourceConfig;
import com.natsuki_kining.ssr.core.config.properties.SSRDruidProperties;
import com.natsuki_kining.ssr.core.utils.CollectionUtils;
import com.natsuki_kining.ssr.core.utils.StringUtils;
import com.ruoyi.system.domain.UrDynamicDataSource;
import com.ruoyi.system.service.IUrDynamicDataSourceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * TODO
 *
 * @Author natsuki_kining
 * @Date 2020/10/9 12:33
 **/
@Component
public class DynamicDataSourceService {

    protected Logger logger = LoggerFactory.getLogger(DynamicDataSourceService.class);

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
            return true;
        }
    }

    /**
     * 启动数据源
     * @param urDynamicDataSource
     * @return
     */
    public boolean startDataSource(UrDynamicDataSource urDynamicDataSource){
        StringBuilder info = new StringBuilder();
        boolean flag = addDataSource(info, urDynamicDataSource);
        logger.info(info.toString());
        return flag;
    }
}
