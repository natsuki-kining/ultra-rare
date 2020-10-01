package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.system.mapper.UrDynamicSqlMapper;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.domain.UrDynamicSql;
import com.ruoyi.system.service.IUrDynamicSqlService;
import com.ruoyi.common.core.text.Convert;

/**
 * 动态sqlService业务层处理
 * 
 * @author ruoyi
 * @date 2020-10-01
 */
@Service
public class UrDynamicSqlServiceImpl implements IUrDynamicSqlService 
{
    @Autowired
    private UrDynamicSqlMapper urDynamicSqlMapper;

    /**
     * 查询动态sql
     * 
     * @param ID 动态sqlID
     * @return 动态sql
     */
    @Override
    public UrDynamicSql selectUrDynamicSqlById(String ID)
    {
        return urDynamicSqlMapper.selectUrDynamicSqlById(ID);
    }

    /**
     * 查询动态sql列表
     * 
     * @param urDynamicSql 动态sql
     * @return 动态sql
     */
    @Override
    public List<UrDynamicSql> selectUrDynamicSqlList(UrDynamicSql urDynamicSql)
    {
        return urDynamicSqlMapper.selectUrDynamicSqlList(urDynamicSql);
    }

    /**
     * 新增动态sql
     * 
     * @param urDynamicSql 动态sql
     * @return 结果
     */
    @Override
    public int insertUrDynamicSql(UrDynamicSql urDynamicSql)
    {
        urDynamicSql.setCreateTime(DateUtils.getNowDate());
        return urDynamicSqlMapper.insertUrDynamicSql(urDynamicSql);
    }

    /**
     * 修改动态sql
     * 
     * @param urDynamicSql 动态sql
     * @return 结果
     */
    @Override
    public int updateUrDynamicSql(UrDynamicSql urDynamicSql)
    {
        urDynamicSql.setUpdateTime(DateUtils.getNowDate());
        return urDynamicSqlMapper.updateUrDynamicSql(urDynamicSql);
    }

    /**
     * 删除动态sql对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteUrDynamicSqlByIds(String ids)
    {
        return urDynamicSqlMapper.deleteUrDynamicSqlByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除动态sql信息
     * 
     * @param ID 动态sqlID
     * @return 结果
     */
    @Override
    public int deleteUrDynamicSqlById(String ID)
    {
        return urDynamicSqlMapper.deleteUrDynamicSqlById(ID);
    }
}
