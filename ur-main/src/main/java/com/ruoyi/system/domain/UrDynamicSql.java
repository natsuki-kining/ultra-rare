package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 动态sql对象 ur_dynamic_sql
 *
 * @author natsuki_kining
 * @date 2020-10-13
 */
public class UrDynamicSql extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /** 主键 */
    private String id;

    /** code */
    @Excel(name = "code" )
    private String queryCode;

    /** 名称 */
    @Excel(name = "名称" )
    private String queryName;

    /** 类型 */
    @Excel(name = "类型" )
    private String queryType;

    /** 数据源名称 */
    @Excel(name = "数据源名称" )
    private String dataSourceName;

    /** sql模板 */
    private String sqlTemplate;

    /** 查前脚本 */
    private String beforeScript;

    /** 查后脚本 */
    private String afterScript;

    /** 版本号 */
    @Excel(name = "版本号" )
    private String version;

    /** 是否删除 */
    private Integer delFlag;

    /** 排序编号 */
    private Long orderNum;

    /** 创建人名称 */
    @Excel(name = "创建人名称" )
    private String createName;

    /** 创建人id */
    private String createId;

    /** 修改人名称 */
    @Excel(name = "修改人名称" )
    private String updateName;

    /** 修改人id */
    private String updateId;



    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
    public void setQueryCode(String queryCode) {
        this.queryCode = queryCode;
    }

    public String getQueryCode() {
        return queryCode;
    }
    public void setQueryName(String queryName) {
        this.queryName = queryName;
    }

    public String getQueryName() {
        return queryName;
    }
    public void setQueryType(String queryType) {
        this.queryType = queryType;
    }

    public String getQueryType() {
        return queryType;
    }
    public void setDataSourceName(String dataSourceName) {
        this.dataSourceName = dataSourceName;
    }

    public String getDataSourceName() {
        return dataSourceName;
    }
    public void setSqlTemplate(String sqlTemplate) {
        this.sqlTemplate = sqlTemplate;
    }

    public String getSqlTemplate() {
        return sqlTemplate;
    }
    public void setBeforeScript(String beforeScript) {
        this.beforeScript = beforeScript;
    }

    public String getBeforeScript() {
        return beforeScript;
    }
    public void setAfterScript(String afterScript) {
        this.afterScript = afterScript;
    }

    public String getAfterScript() {
        return afterScript;
    }
    public void setVersion(String version) {
        this.version = version;
    }

    public String getVersion() {
        return version;
    }
    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public Integer getDelFlag() {
        return delFlag;
    }
    public void setOrderNum(Long orderNum) {
        this.orderNum = orderNum;
    }

    public Long getOrderNum() {
        return orderNum;
    }
    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public String getCreateName() {
        return createName;
    }
    public void setCreateId(String createId) {
        this.createId = createId;
    }

    public String getCreateId() {
        return createId;
    }
    public void setUpdateName(String updateName) {
        this.updateName = updateName;
    }

    public String getUpdateName() {
        return updateName;
    }
    public void setUpdateId(String updateId) {
        this.updateId = updateId;
    }

    public String getUpdateId() {
        return updateId;
    }


    @Override
    public String toString(){
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
        .append("id" ,getId())
        .append("queryCode" ,getQueryCode())
        .append("queryName" ,getQueryName())
        .append("queryType" ,getQueryType())
        .append("dataSourceName" ,getDataSourceName())
        .append("sqlTemplate" ,getSqlTemplate())
        .append("beforeScript" ,getBeforeScript())
        .append("afterScript" ,getAfterScript())
        .append("version" ,getVersion())
        .append("delFlag" ,getDelFlag())
        .append("orderNum" ,getOrderNum())
        .append("createName" ,getCreateName())
        .append("createId" ,getCreateId())
        .append("createTime" ,getCreateTime())
        .append("updateName" ,getUpdateName())
        .append("updateId" ,getUpdateId())
        .append("updateTime" ,getUpdateTime())
        .append("remark" ,getRemark())
        .toString();
    }

}
