package com.lanqiao.hebeitcm.service.impl.hry;

import com.github.pagehelper.Page;
import com.lanqiao.hebeitcm.mapper.hry.TbIndustrialDevelopTalRecMapper;
import com.lanqiao.hebeitcm.model.hry.TbIndustrialDevelopTalRec;
import com.lanqiao.hebeitcm.service.hry.TbIndustrialDevelopTalRecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 黄瑞颖
 * @create 2021-07-22 14:30
 */
@Service("tbIndustrialDevelopTalRecService")
// 支持事务，增加、删除、更新操作单独使用 propagation = Propagation.REQUIRED
@Transactional(propagation = Propagation.SUPPORTS,rollbackFor = Exception.class)
public class TbIndustrialDevelopTalRecServiceImpl implements TbIndustrialDevelopTalRecService {

    @Autowired
    private TbIndustrialDevelopTalRecMapper talRecMapper;

    // 查询
    @Override
    public Page<TbIndustrialDevelopTalRec> select(TbIndustrialDevelopTalRec talRec, int pageNum, int pageSize) {
        return this.talRecMapper.select(talRec,pageNum,pageSize);
    }

    // 根据主键查询单条记录
    @Override
    public TbIndustrialDevelopTalRec selectByPrimaryKey(Integer itemid, String itemcode) {
        return this.talRecMapper.selectByPrimaryKey(itemid,itemcode);
    }

    // 删除
    @Override
    public int deleteByPrimaryKey(Integer itemid, String itemcode) {
        return this.talRecMapper.deleteByPrimaryKey(itemid,itemcode);
    }

    // 插入
    @Override
    public int insert(TbIndustrialDevelopTalRec record) {
        return this.talRecMapper.insert(record);
    }

    // 更新
    @Override
    public int updateByPrimaryKey(TbIndustrialDevelopTalRec record) {
        return this.talRecMapper.updateByPrimaryKey(record);
    }
}
