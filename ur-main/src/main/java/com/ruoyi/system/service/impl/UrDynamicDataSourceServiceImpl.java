package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.UrDynamicDataSourceMapper;
import com.ruoyi.system.domain.UrDynamicDataSource;
import com.ruoyi.system.service.IUrDynamicDataSourceService;
import com.ruoyi.common.core.text.Convert;

/**
 * 动态数据源Service业务层处理
 * 
 * @author natsuki_kining
 * @date 2020-10-10
 */
@Service
public class UrDynamicDataSourceServiceImpl implements IUrDynamicDataSourceService 
{
    @Autowired
    private UrDynamicDataSourceMapper urDynamicDataSourceMapper;

    /**
     * 查询动态数据源
     * 
     * @param id 动态数据源ID
     * @return 动态数据源
     */
    @Override
    public UrDynamicDataSource selectUrDynamicDataSourceById(Long id)
    {
        return urDynamicDataSourceMapper.selectUrDynamicDataSourceById(id);
    }

    /**
     * 查询动态数据源列表
     * 
     * @param urDynamicDataSource 动态数据源
     * @return 动态数据源
     */
    @Override
    public List<UrDynamicDataSource> selectUrDynamicDataSourceList(UrDynamicDataSource urDynamicDataSource)
    {
        return urDynamicDataSourceMapper.selectUrDynamicDataSourceList(urDynamicDataSource);
    }

    /**
     * 新增动态数据源
     * 
     * @param urDynamicDataSource 动态数据源
     * @return 结果
     */
    @Override
    public int insertUrDynamicDataSource(UrDynamicDataSource urDynamicDataSource)
    {
        urDynamicDataSource.setCreateTime(DateUtils.getNowDate());
        return urDynamicDataSourceMapper.insertUrDynamicDataSource(urDynamicDataSource);
    }

    /**
     * 修改动态数据源
     * 
     * @param urDynamicDataSource 动态数据源
     * @return 结果
     */
    @Override
    public int updateUrDynamicDataSource(UrDynamicDataSource urDynamicDataSource)
    {
        urDynamicDataSource.setUpdateTime(DateUtils.getNowDate());
        return urDynamicDataSourceMapper.updateUrDynamicDataSource(urDynamicDataSource);
    }

    /**
     * 删除动态数据源对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteUrDynamicDataSourceByIds(String ids)
    {
        return urDynamicDataSourceMapper.deleteUrDynamicDataSourceByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除动态数据源信息
     * 
     * @param id 动态数据源ID
     * @return 结果
     */
    @Override
    public int deleteUrDynamicDataSourceById(Long id)
    {
        return urDynamicDataSourceMapper.deleteUrDynamicDataSourceById(id);
    }
}
