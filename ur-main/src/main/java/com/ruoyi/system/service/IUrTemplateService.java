package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.UrTemplate;

/**
 * 模板Service接口
 * 
 * @author ruoyi
 * @date 2020-10-01
 */
public interface IUrTemplateService 
{
    /**
     * 查询模板
     * 
     * @param ID 模板ID
     * @return 模板
     */
    public UrTemplate selectUrTemplateById(String ID);

    /**
     * 查询模板列表
     * 
     * @param urTemplate 模板
     * @return 模板集合
     */
    public List<UrTemplate> selectUrTemplateList(UrTemplate urTemplate);

    /**
     * 新增模板
     * 
     * @param urTemplate 模板
     * @return 结果
     */
    public int insertUrTemplate(UrTemplate urTemplate);

    /**
     * 修改模板
     * 
     * @param urTemplate 模板
     * @return 结果
     */
    public int updateUrTemplate(UrTemplate urTemplate);

    /**
     * 批量删除模板
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteUrTemplateByIds(String ids);

    /**
     * 删除模板信息
     * 
     * @param ID 模板ID
     * @return 结果
     */
    public int deleteUrTemplateById(String ID);
}
