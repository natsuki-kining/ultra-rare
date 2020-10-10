package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.UrDynamicDataSource;

/**
 * 动态数据源Service接口
 * 
 * @author natsuki_kining
 * @date 2020-10-10
 */
public interface IUrDynamicDataSourceService 
{
    /**
     * 查询动态数据源
     * 
     * @param id 动态数据源ID
     * @return 动态数据源
     */
    public UrDynamicDataSource selectUrDynamicDataSourceById(Long id);

    /**
     * 查询动态数据源列表
     * 
     * @param urDynamicDataSource 动态数据源
     * @return 动态数据源集合
     */
    public List<UrDynamicDataSource> selectUrDynamicDataSourceList(UrDynamicDataSource urDynamicDataSource);

    /**
     * 新增动态数据源
     * 
     * @param urDynamicDataSource 动态数据源
     * @return 结果
     */
    public int insertUrDynamicDataSource(UrDynamicDataSource urDynamicDataSource);

    /**
     * 修改动态数据源
     * 
     * @param urDynamicDataSource 动态数据源
     * @return 结果
     */
    public int updateUrDynamicDataSource(UrDynamicDataSource urDynamicDataSource);

    /**
     * 批量删除动态数据源
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteUrDynamicDataSourceByIds(String ids);

    /**
     * 删除动态数据源信息
     * 
     * @param id 动态数据源ID
     * @return 结果
     */
    public int deleteUrDynamicDataSourceById(Long id);
}