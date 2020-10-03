package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.UrDynamicDatasourceMapper;
import com.ruoyi.system.domain.UrDynamicDatasource;
import com.ruoyi.system.service.IUrDynamicDatasourceService;
import com.ruoyi.common.core.text.Convert;

/**
 * 动态数据源Service业务层处理
 * 
 * @author natsuki_kining
 * @date 2020-10-03
 */
@Service
public class UrDynamicDatasourceServiceImpl implements IUrDynamicDatasourceService 
{
    @Autowired
    private UrDynamicDatasourceMapper urDynamicDatasourceMapper;

    /**
     * 查询动态数据源
     * 
     * @param id 动态数据源ID
     * @return 动态数据源
     */
    @Override
    public UrDynamicDatasource selectUrDynamicDatasourceById(Long id)
    {
        return urDynamicDatasourceMapper.selectUrDynamicDatasourceById(id);
    }

    /**
     * 查询动态数据源列表
     * 
     * @param urDynamicDatasource 动态数据源
     * @return 动态数据源
     */
    @Override
    public List<UrDynamicDatasource> selectUrDynamicDatasourceList(UrDynamicDatasource urDynamicDatasource)
    {
        return urDynamicDatasourceMapper.selectUrDynamicDatasourceList(urDynamicDatasource);
    }

    /**
     * 新增动态数据源
     * 
     * @param urDynamicDatasource 动态数据源
     * @return 结果
     */
    @Override
    public int insertUrDynamicDatasource(UrDynamicDatasource urDynamicDatasource)
    {
        return urDynamicDatasourceMapper.insertUrDynamicDatasource(urDynamicDatasource);
    }

    /**
     * 修改动态数据源
     * 
     * @param urDynamicDatasource 动态数据源
     * @return 结果
     */
    @Override
    public int updateUrDynamicDatasource(UrDynamicDatasource urDynamicDatasource)
    {
        return urDynamicDatasourceMapper.updateUrDynamicDatasource(urDynamicDatasource);
    }

    /**
     * 删除动态数据源对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteUrDynamicDatasourceByIds(String ids)
    {
        return urDynamicDatasourceMapper.deleteUrDynamicDatasourceByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除动态数据源信息
     * 
     * @param id 动态数据源ID
     * @return 结果
     */
    @Override
    public int deleteUrDynamicDatasourceById(Long id)
    {
        return urDynamicDatasourceMapper.deleteUrDynamicDatasourceById(id);
    }
}
