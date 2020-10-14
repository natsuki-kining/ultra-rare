package com.ruoyi.system.service.impl.abs;

import java.util.List;
                                                            import com.ruoyi.common.utils.DateUtils;
        import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.base.UrDynamicSqlBaseMapper;
import com.ruoyi.system.mapper.UrDynamicSqlMapper;
import com.ruoyi.system.domain.UrDynamicSql;
import com.ruoyi.system.service.base.IUrDynamicSqlBaseService;
import com.ruoyi.common.core.text.Convert;

/**
 * 动态sqlService业务抽象层处理
 *
 * @author natsuki_kining
 * @date 2020-10-14
 */
public abstract class AbstractUrDynamicSqlServiceImpl implements IUrDynamicSqlBaseService {

    @Autowired
    protected UrDynamicSqlBaseMapper urDynamicSqlBaseMapper;
    @Autowired
    protected UrDynamicSqlMapper urDynamicSqlMapper;

    /**
     * 查询动态sql
     *
     * @param id 动态sqlID
     * @return 动态sql
     */
    @Override
    public UrDynamicSql selectUrDynamicSqlById(String id) {
        return urDynamicSqlBaseMapper.selectUrDynamicSqlById(id);
    }

    /**
     * 查询动态sql列表
     *
     * @param urDynamicSql 动态sql
     * @return 动态sql
     */
    @Override
    public List<UrDynamicSql> selectUrDynamicSqlList(UrDynamicSql urDynamicSql) {
        return urDynamicSqlBaseMapper.selectUrDynamicSqlList(urDynamicSql);
    }

    /**
     * 新增动态sql
     *
     * @param urDynamicSql 动态sql
     * @return 结果
     */
    @Override
    public int insertUrDynamicSql(UrDynamicSql urDynamicSql) {
        urDynamicSql.setCreateTime(DateUtils.getNowDate());
        return urDynamicSqlBaseMapper.insertUrDynamicSql(urDynamicSql);
    }

    /**
     * 修改动态sql
     *
     * @param urDynamicSql 动态sql
     * @return 结果
     */
    @Override
    public int updateUrDynamicSql(UrDynamicSql urDynamicSql) {
        urDynamicSql.setUpdateTime(DateUtils.getNowDate());
        return urDynamicSqlBaseMapper.updateUrDynamicSql(urDynamicSql);
    }

    /**
     * 删除动态sql对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteUrDynamicSqlByIds(String ids) {
        return urDynamicSqlBaseMapper.deleteUrDynamicSqlByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除动态sql信息
     *
     * @param id 动态sqlID
     * @return 结果
     */
    @Override
    public int deleteUrDynamicSqlById(String id) {
        return urDynamicSqlBaseMapper.deleteUrDynamicSqlById(id);
    }


}
