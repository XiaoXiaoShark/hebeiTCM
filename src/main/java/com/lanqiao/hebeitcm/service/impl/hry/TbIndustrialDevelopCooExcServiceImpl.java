package com.lanqiao.hebeitcm.service.impl.hry;

import com.github.pagehelper.Page;
import com.lanqiao.hebeitcm.mapper.hry.TbIndustrialDevelopCooExcMapper;
import com.lanqiao.hebeitcm.model.hry.TbIndustrialDevelopCooExc;
import com.lanqiao.hebeitcm.service.hry.TbIndustrialDevelopCooExcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 黄瑞颖
 * @create 2021-07-22 11:21
 */
@Service("tbIndustrialDevelopCooExcService")
// 支持事务，增加、删除、更新操作单独使用 propagation = Propagation.REQUIRED
@Transactional(propagation = Propagation.SUPPORTS,rollbackFor = Exception.class)
public class TbIndustrialDevelopCooExcServiceImpl implements TbIndustrialDevelopCooExcService {

    @Autowired
    private TbIndustrialDevelopCooExcMapper tbIndustrialDevelopCooExcMapper;

    @Override
    public Page<TbIndustrialDevelopCooExc> select(TbIndustrialDevelopCooExc tbIndustrialDevelopCooExc, int pageNum, int pageSize) {

        return this.tbIndustrialDevelopCooExcMapper.select(tbIndustrialDevelopCooExc,pageNum,pageSize);
    }

    @Override
    public TbIndustrialDevelopCooExc selectByPrimaryKey(Integer key,String uuid) {
        return this.tbIndustrialDevelopCooExcMapper.selectByPrimaryKey(key,uuid);
    }

    @Override
    public int deleteByPrimaryKey(Integer key,String uuid) {
        return this.tbIndustrialDevelopCooExcMapper.deleteByPrimaryKey(key,uuid);
    }

    @Override
    public int insert(TbIndustrialDevelopCooExc record) {
        return this.tbIndustrialDevelopCooExcMapper.insert(record);
    }

    @Override
    public int update(TbIndustrialDevelopCooExc record) {
        return this.tbIndustrialDevelopCooExcMapper.update(record);
    }
}
