package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.UrDynamicDatasource;

/**
 * 动态数据源Mapper接口
 * 
 * @author natsuki_kining
 * @date 2020-10-03
 */
public interface UrDynamicDatasourceMapper 
{
    /**
     * 查询动态数据源
     * 
     * @param id 动态数据源ID
     * @return 动态数据源
     */
    public UrDynamicDatasource selectUrDynamicDatasourceById(Long id);

    /**
     * 查询动态数据源列表
     * 
     * @param urDynamicDatasource 动态数据源
     * @return 动态数据源集合
     */
    public List<UrDynamicDatasource> selectUrDynamicDatasourceList(UrDynamicDatasource urDynamicDatasource);

    /**
     * 新增动态数据源
     * 
     * @param urDynamicDatasource 动态数据源
     * @return 结果
     */
    public int insertUrDynamicDatasource(UrDynamicDatasource urDynamicDatasource);

    /**
     * 修改动态数据源
     * 
     * @param urDynamicDatasource 动态数据源
     * @return 结果
     */
    public int updateUrDynamicDatasource(UrDynamicDatasource urDynamicDatasource);

    /**
     * 删除动态数据源
     * 
     * @param id 动态数据源ID
     * @return 结果
     */
    public int deleteUrDynamicDatasourceById(Long id);

    /**
     * 批量删除动态数据源
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteUrDynamicDatasourceByIds(String[] ids);
}
