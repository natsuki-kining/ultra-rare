package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 动态数据源对象 ur_dynamic_datasource
 * 
 * @author natsuki_kining
 * @date 2020-10-03
 */
public class UrDynamicDatasource extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 数据源名称 */
    @Excel(name = "数据源名称")
    private String datasourceName;

    /** 数据库账号 */
    @Excel(name = "数据库账号")
    private String userName;

    /** 数据库密码 */
    @Excel(name = "数据库密码")
    private String password;

    /** 数据库链接 */
    @Excel(name = "数据库链接")
    private String url;

    /** 驱动名称 */
    @Excel(name = "驱动名称")
    private String driverClassName;

    /** 其他配置信息 */
    private String otherConfig;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setDatasourceName(String datasourceName) 
    {
        this.datasourceName = datasourceName;
    }

    public String getDatasourceName() 
    {
        return datasourceName;
    }
    public void setUserName(String userName) 
    {
        this.userName = userName;
    }

    public String getUserName() 
    {
        return userName;
    }
    public void setPassword(String password) 
    {
        this.password = password;
    }

    public String getPassword() 
    {
        return password;
    }
    public void setUrl(String url) 
    {
        this.url = url;
    }

    public String getUrl() 
    {
        return url;
    }
    public void setDriverClassName(String driverClassName) 
    {
        this.driverClassName = driverClassName;
    }

    public String getDriverClassName() 
    {
        return driverClassName;
    }
    public void setOtherConfig(String otherConfig) 
    {
        this.otherConfig = otherConfig;
    }

    public String getOtherConfig() 
    {
        return otherConfig;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("datasourceName", getDatasourceName())
            .append("userName", getUserName())
            .append("password", getPassword())
            .append("url", getUrl())
            .append("driverClassName", getDriverClassName())
            .append("otherConfig", getOtherConfig())
            .toString();
    }
}
