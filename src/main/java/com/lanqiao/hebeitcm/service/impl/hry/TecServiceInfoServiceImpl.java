package com.lanqiao.hebeitcm.service.impl.hry;

import com.github.pagehelper.Page;
import com.lanqiao.hebeitcm.mapper.hry.TecServiceInfoMapper;
import com.lanqiao.hebeitcm.model.hry.TecServiceInfo;
import com.lanqiao.hebeitcm.service.hry.TecServiceInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 黄瑞颖
 * @create 2021-07-21 15:41
 */
@Service("tecServiceInfoService")
// 支持事务，增加、删除、更新操作单独使用 propagation = Propagation.REQUIRED
@Transactional(propagation = Propagation.SUPPORTS,rollbackFor = Exception.class)
public class TecServiceInfoServiceImpl implements TecServiceInfoService {

    @Autowired
    TecServiceInfoMapper tecServiceInfoMapper;

    // 查询
    @Override
    public Page<TecServiceInfo> select(TecServiceInfo tecServiceInfo, int pageNum, int pageSize) {
        return this.tecServiceInfoMapper.select(tecServiceInfo,pageNum,pageSize);
    }

    // 添加
    @Override
    public void addTecServiceInfo(TecServiceInfo tecServiceInfo) {
        this.tecServiceInfoMapper.addTecServiceInfo(tecServiceInfo);
    }

    // 删除
    @Override
    public void deleteTecServiceInfo(int itemID) {
        this.tecServiceInfoMapper.deleteTecServiceInfo(itemID);
    }

    // 更新
    @Override
    public void updateTecServiceInfo(TecServiceInfo tecServiceInfo) {
        this.tecServiceInfoMapper.updateTecServiceInfo(tecServiceInfo);
    }

    // 根据ID查询单条信息
    @Override
    public TecServiceInfo selectByItemID(int itemID) {
        return this.tecServiceInfoMapper.selectByItemID(itemID);
    }
}
