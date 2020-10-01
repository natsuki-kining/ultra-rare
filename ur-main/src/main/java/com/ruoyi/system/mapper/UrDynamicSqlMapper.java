package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.UrDynamicSql;

/**
 * 动态sqlMapper接口
 * 
 * @author ruoyi
 * @date 2020-10-01
 */
public interface UrDynamicSqlMapper 
{
    /**
     * 查询动态sql
     * 
     * @param id 动态sqlID
     * @return 动态sql
     */
    public UrDynamicSql selectUrDynamicSqlById(String id);

    /**
     * 查询动态sql列表
     * 
     * @param urDynamicSql 动态sql
     * @return 动态sql集合
     */
    public List<UrDynamicSql> selectUrDynamicSqlList(UrDynamicSql urDynamicSql);

    /**
     * 新增动态sql
     * 
     * @param urDynamicSql 动态sql
     * @return 结果
     */
    public int insertUrDynamicSql(UrDynamicSql urDynamicSql);

    /**
     * 修改动态sql
     * 
     * @param urDynamicSql 动态sql
     * @return 结果
     */
    public int updateUrDynamicSql(UrDynamicSql urDynamicSql);

    /**
     * 删除动态sql
     * 
     * @param id 动态sqlID
     * @return 结果
     */
    public int deleteUrDynamicSqlById(String id);

    /**
     * 批量删除动态sql
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteUrDynamicSqlByIds(String[] ids);
}
