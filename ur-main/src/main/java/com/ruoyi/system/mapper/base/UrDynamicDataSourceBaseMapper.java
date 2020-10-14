package com.ruoyi.system.mapper.base;

import java.util.List;
import com.ruoyi.system.domain.UrDynamicDataSource;

/**
 * 动态数据源Mapper接口
 * 
 * @author natsuki_kining
 * @date 2020-10-14
 */
public interface UrDynamicDataSourceBaseMapper {
    /**
     * 查询动态数据源
     * 
     * @param id 动态数据源ID
     * @return 动态数据源
     */
    UrDynamicDataSource selectUrDynamicDataSourceById(Long id);

    /**
     * 查询动态数据源列表
     * 
     * @param urDynamicDataSource 动态数据源
     * @return 动态数据源集合
     */
    List<UrDynamicDataSource> selectUrDynamicDataSourceList(UrDynamicDataSource urDynamicDataSource);

    /**
     * 新增动态数据源
     * 
     * @param urDynamicDataSource 动态数据源
     * @return 结果
     */
    int insertUrDynamicDataSource(UrDynamicDataSource urDynamicDataSource);

    /**
     * 修改动态数据源
     * 
     * @param urDynamicDataSource 动态数据源
     * @return 结果
     */
    int updateUrDynamicDataSource(UrDynamicDataSource urDynamicDataSource);

    /**
     * 删除动态数据源
     * 
     * @param id 动态数据源ID
     * @return 结果
     */
    int deleteUrDynamicDataSourceById(Long id);

    /**
     * 批量删除动态数据源
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteUrDynamicDataSourceByIds(String[] ids);
}
