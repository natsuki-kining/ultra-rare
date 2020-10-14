package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 模板对象 ur_template
 *
 * @author natsuki_kining
 * @date 2020-10-14
 */
public class UrTemplate extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /** 主键 */
    private String id;

    /** 模板code */
    @Excel(name = "模板code" )
    private String templateCode;

    /** 模板 */
    @Excel(name = "模板" )
    private String template;

    /** 脚本 */
    @Excel(name = "脚本" )
    private String javascript;

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
    @Excel(name = "创建人id" )
    private String createId;

    /** 修改人名称 */
    @Excel(name = "修改人名称" )
    private String updateName;

    /** 修改人id */
    @Excel(name = "修改人id" )
    private String updateId;



    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
    public void setTemplateCode(String templateCode) {
        this.templateCode = templateCode;
    }

    public String getTemplateCode() {
        return templateCode;
    }
    public void setTemplate(String template) {
        this.template = template;
    }

    public String getTemplate() {
        return template;
    }
    public void setJavascript(String javascript) {
        this.javascript = javascript;
    }

    public String getJavascript() {
        return javascript;
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
        .append("templateCode" ,getTemplateCode())
        .append("template" ,getTemplate())
        .append("javascript" ,getJavascript())
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
