package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.UrTemplate;

/**
 * 模板Mapper接口
 * 
 * @author natsuki_kining
 * @date 2020-10-13
 */
public interface UrTemplateBaseMapper {
    /**
     * 查询模板
     * 
     * @param id 模板ID
     * @return 模板
     */
    UrTemplate selectUrTemplateById(String id);

    /**
     * 查询模板列表
     * 
     * @param urTemplate 模板
     * @return 模板集合
     */
    List<UrTemplate> selectUrTemplateList(UrTemplate urTemplate);

    /**
     * 新增模板
     * 
     * @param urTemplate 模板
     * @return 结果
     */
    int insertUrTemplate(UrTemplate urTemplate);

    /**
     * 修改模板
     * 
     * @param urTemplate 模板
     * @return 结果
     */
    int updateUrTemplate(UrTemplate urTemplate);

    /**
     * 删除模板
     * 
     * @param id 模板ID
     * @return 结果
     */
    int deleteUrTemplateById(String id);

    /**
     * 批量删除模板
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteUrTemplateByIds(String[] ids);
}
