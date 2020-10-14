package com.ruoyi.system.service.impl.abs;

import java.util.List;
                                                        import com.ruoyi.common.utils.DateUtils;
        import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.base.UrDynamicDataSourceBaseMapper;
import com.ruoyi.system.mapper.UrDynamicDataSourceMapper;
import com.ruoyi.system.domain.UrDynamicDataSource;
import com.ruoyi.system.service.base.IUrDynamicDataSourceBaseService;
import com.ruoyi.common.core.text.Convert;

/**
 * 动态数据源Service业务抽象层处理
 *
 * @author natsuki_kining
 * @date 2020-10-14
 */
public abstract class AbstractUrDynamicDataSourceServiceImpl implements IUrDynamicDataSourceBaseService {

    @Autowired
    protected UrDynamicDataSourceBaseMapper urDynamicDataSourceBaseMapper;
    @Autowired
    protected UrDynamicDataSourceMapper urDynamicDataSourceMapper;

    /**
     * 查询动态数据源
     *
     * @param id 动态数据源ID
     * @return 动态数据源
     */
    @Override
    public UrDynamicDataSource selectUrDynamicDataSourceById(Long id) {
        return urDynamicDataSourceBaseMapper.selectUrDynamicDataSourceById(id);
    }

    /**
     * 查询动态数据源列表
     *
     * @param urDynamicDataSource 动态数据源
     * @return 动态数据源
     */
    @Override
    public List<UrDynamicDataSource> selectUrDynamicDataSourceList(UrDynamicDataSource urDynamicDataSource) {
        return urDynamicDataSourceBaseMapper.selectUrDynamicDataSourceList(urDynamicDataSource);
    }

    /**
     * 新增动态数据源
     *
     * @param urDynamicDataSource 动态数据源
     * @return 结果
     */
    @Override
    public int insertUrDynamicDataSource(UrDynamicDataSource urDynamicDataSource) {
        urDynamicDataSource.setCreateTime(DateUtils.getNowDate());
        return urDynamicDataSourceBaseMapper.insertUrDynamicDataSource(urDynamicDataSource);
    }

    /**
     * 修改动态数据源
     *
     * @param urDynamicDataSource 动态数据源
     * @return 结果
     */
    @Override
    public int updateUrDynamicDataSource(UrDynamicDataSource urDynamicDataSource) {
        urDynamicDataSource.setUpdateTime(DateUtils.getNowDate());
        return urDynamicDataSourceBaseMapper.updateUrDynamicDataSource(urDynamicDataSource);
    }

    /**
     * 删除动态数据源对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteUrDynamicDataSourceByIds(String ids) {
        return urDynamicDataSourceBaseMapper.deleteUrDynamicDataSourceByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除动态数据源信息
     *
     * @param id 动态数据源ID
     * @return 结果
     */
    @Override
    public int deleteUrDynamicDataSourceById(Long id) {
        return urDynamicDataSourceBaseMapper.deleteUrDynamicDataSourceById(id);
    }


}
