package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 模板对象 ur_template
 * 
 * @author ruoyi
 * @date 2020-10-01
 */
public class UrTemplate extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private String ID;

    /** 模板code */
    @Excel(name = "模板code")
    private String templateCode;

    /** 模板 */
    @Excel(name = "模板")
    private String TEMPLATE;

    /** 脚本 */
    @Excel(name = "脚本")
    private String JAVASCRIPT;

    /** 版本号 */
    @Excel(name = "版本号")
    private String VERSION;

    /** 是否删除。1：是，0：否。 */
    @Excel(name = "是否删除。1：是，0：否。")
    private Integer delFlag;

    /** 排序编号。正序。 */
    @Excel(name = "排序编号。正序。")
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

    public void setID(String ID) 
    {
        this.ID = ID;
    }

    public String getID() 
    {
        return ID;
    }
    public void setTemplateCode(String templateCode) 
    {
        this.templateCode = templateCode;
    }

    public String getTemplateCode() 
    {
        return templateCode;
    }
    public void setTEMPLATE(String TEMPLATE) 
    {
        this.TEMPLATE = TEMPLATE;
    }

    public String getTEMPLATE() 
    {
        return TEMPLATE;
    }
    public void setJAVASCRIPT(String JAVASCRIPT) 
    {
        this.JAVASCRIPT = JAVASCRIPT;
    }

    public String getJAVASCRIPT() 
    {
        return JAVASCRIPT;
    }
    public void setVERSION(String VERSION) 
    {
        this.VERSION = VERSION;
    }

    public String getVERSION() 
    {
        return VERSION;
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
            .append("ID", getID())
            .append("templateCode", getTemplateCode())
            .append("TEMPLATE", getTEMPLATE())
            .append("JAVASCRIPT", getJAVASCRIPT())
            .append("VERSION", getVERSION())
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
