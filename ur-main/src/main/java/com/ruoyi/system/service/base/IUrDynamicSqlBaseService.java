package com.ruoyi.system.service.base;

import java.util.List;

import com.ruoyi.system.domain.UrDynamicSql;

/**
 * 动态sqlService接口
 *
 * @author natsuki_kining
 * @date 2020-10-14
 */
public interface IUrDynamicSqlBaseService {
    /**
     * 查询动态sql
     *
     * @param id 动态sqlID
     * @return 动态sql
     */
     UrDynamicSql selectUrDynamicSqlById(String id);

    /**
     * 查询动态sql列表
     *
     * @param urDynamicSql 动态sql
     * @return 动态sql集合
     */
    List<UrDynamicSql> selectUrDynamicSqlList(UrDynamicSql urDynamicSql);

    /**
     * 新增动态sql
     *
     * @param urDynamicSql 动态sql
     * @return 结果
     */
    int insertUrDynamicSql(UrDynamicSql urDynamicSql);

    /**
     * 修改动态sql
     *
     * @param urDynamicSql 动态sql
     * @return 结果
     */
    int updateUrDynamicSql(UrDynamicSql urDynamicSql);

    /**
     * 批量删除动态sql
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteUrDynamicSqlByIds(String ids);

    /**
     * 删除动态sql信息
     *
     * @param id 动态sqlID
     * @return 结果
     */
    int deleteUrDynamicSqlById(String id);
    }
