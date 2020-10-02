package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.UrTemplateMapper;
import com.ruoyi.system.domain.UrTemplate;
import com.ruoyi.system.service.IUrTemplateService;
import com.ruoyi.common.core.text.Convert;

/**
 * 模板Service业务层处理
 * 
 * @author natsuki_kining
 * @date 2020-10-02
 */
@Service
public class UrTemplateServiceImpl implements IUrTemplateService 
{
    @Autowired
    private UrTemplateMapper urTemplateMapper;

    /**
     * 查询模板
     * 
     * @param id 模板ID
     * @return 模板
     */
    @Override
    public UrTemplate selectUrTemplateById(String id)
    {
        return urTemplateMapper.selectUrTemplateById(id);
    }

    /**
     * 查询模板列表
     * 
     * @param urTemplate 模板
     * @return 模板
     */
    @Override
    public List<UrTemplate> selectUrTemplateList(UrTemplate urTemplate)
    {
        return urTemplateMapper.selectUrTemplateList(urTemplate);
    }

    /**
     * 新增模板
     * 
     * @param urTemplate 模板
     * @return 结果
     */
    @Override
    public int insertUrTemplate(UrTemplate urTemplate)
    {
        urTemplate.setCreateTime(DateUtils.getNowDate());
        return urTemplateMapper.insertUrTemplate(urTemplate);
    }

    /**
     * 修改模板
     * 
     * @param urTemplate 模板
     * @return 结果
     */
    @Override
    public int updateUrTemplate(UrTemplate urTemplate)
    {
        urTemplate.setUpdateTime(DateUtils.getNowDate());
        return urTemplateMapper.updateUrTemplate(urTemplate);
    }

    /**
     * 删除模板对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteUrTemplateByIds(String ids)
    {
        return urTemplateMapper.deleteUrTemplateByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除模板信息
     * 
     * @param id 模板ID
     * @return 结果
     */
    @Override
    public int deleteUrTemplateById(String id)
    {
        return urTemplateMapper.deleteUrTemplateById(id);
    }
}
