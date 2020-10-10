package com.natsuki_kining.ur.manager.datasource;

import com.alibaba.fastjson.JSON;
import com.natsuki_kining.ssr.core.config.multisource.DynamicDataSourceHandle;
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
    private DynamicDataSourceHandle dynamicDataSourceHandle;

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
            if (multiSourceConfig.containsDataSourceName(ds.getDatasourceName())){
                info.append("数据源");
                info.append(ds.getDatasourceName());
                info.append("已存在。");
            }else{
                SSRDruidProperties druidProperties = null;
                if (StringUtils.isNotBlank(ds.getOtherConfig())) {
                    druidProperties = JSON.parseObject(ds.getOtherConfig(), SSRDruidProperties.class);
                }
                if (druidProperties == null) {
                    druidProperties = new SSRDruidProperties();
                }
                druidProperties.setDriverClassName(ds.getDriverClassName());
                druidProperties.setDataSourceName(ds.getDatasourceName());
                druidProperties.setPassword(ds.getPassword());
                druidProperties.setUsername(ds.getUserName());
                druidProperties.setUrl(ds.getUrl());
                boolean flag = dynamicDataSourceHandle.addDatasource(druidProperties);
                String message = flag ? "成功" : "失败";
                info.append(ds.getDatasourceName());
                info.append(" 数据源 新增 ");
                info.append(message);
                info.append("。");
            }
        });
        logger.info(info.toString());
    }
}
