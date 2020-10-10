package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 动态数据源对象 ur_dynamic_data_source
 * 
 * @author natsuki_kining
 * @date 2020-10-10
 */
public class UrDynamicDataSource extends BaseEntity
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

    /** 版本号 */
    @Excel(name = "版本号")
    private String version;

    /** 是否删除 */
    private Integer delFlag;

    /** 排序编号 */
    @Excel(name = "排序编号")
    private Long orderNum;

    /** 创建人名称 */
    @Excel(name = "创建人名称")
    private String createName;

    /** 创建人id */
    @Excel(name = "创建人id")
    private String createId;

    /** 修改人名称 */
    @Excel(name = "修改人名称")
    private String updateName;

    /** 修改人id */
    @Excel(name = "修改人id")
    private String updateId;

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
    public void setVersion(String version) 
    {
        this.version = version;
    }

    public String getVersion() 
    {
        return version;
    }
    public void setDelFlag(Integer delFlag) 
    {
        this.delFlag = delFlag;
    }

    public Integer getDelFlag() 
    {
        return delFlag;
    }
    public void setOrderNum(Long orderNum) 
    {
        this.orderNum = orderNum;
    }

    public Long getOrderNum() 
    {
        return orderNum;
    }
    public void setCreateName(String createName) 
    {
        this.createName = createName;
    }

    public String getCreateName() 
    {
        return createName;
    }
    public void setCreateId(String createId) 
    {
        this.createId = createId;
    }

    public String getCreateId() 
    {
        return createId;
    }
    public void setUpdateName(String updateName) 
    {
        this.updateName = updateName;
    }

    public String getUpdateName() 
    {
        return updateName;
    }
    public void setUpdateId(String updateId) 
    {
        this.updateId = updateId;
    }

    public String getUpdateId() 
    {
        return updateId;
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
            .append("version", getVersion())
            .append("delFlag", getDelFlag())
            .append("orderNum", getOrderNum())
            .append("createName", getCreateName())
            .append("createId", getCreateId())
            .append("createTime", getCreateTime())
            .append("updateName", getUpdateName())
            .append("updateId", getUpdateId())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
