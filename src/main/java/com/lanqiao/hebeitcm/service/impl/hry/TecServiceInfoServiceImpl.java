package com.lanqiao.hebeitcm.service.impl.hry;

import com.github.pagehelper.Page;
import com.lanqiao.hebeitcm.mapper.hry.TecServiceInfoMapper;
import com.lanqiao.hebeitcm.model.hry.TecServiceInfo;
import com.lanqiao.hebeitcm.service.hry.TecServiceInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * @author 黄瑞颖
 * @create 2021-07-21 15:41
 */
@Service("tecServiceInfoService")
// 支持事务，增加、删除、更新操作单独使用 propagation = Propagation.REQUIRED
@Transactional(propagation = Propagation.SUPPORTS,rollbackFor = Exception.class)
public class TecServiceInfoServiceImpl implements TecServiceInfoService {

    @Autowired
    private TecServiceInfoMapper tecServiceInfoMapper;

    // 查询
    @Override
    public Page<TecServiceInfo> select(TecServiceInfo tecServiceInfo, int pageNum, int pageSize) {
        return this.tecServiceInfoMapper.select(tecServiceInfo,pageNum,pageSize);
    }

    // 添加
    @Override
    public int addTecServiceInfo(TecServiceInfo tecServiceInfo) {

        String uuid = UUID.randomUUID().toString();
        tecServiceInfo.setItemCode(uuid);

       return this.tecServiceInfoMapper.addTecServiceInfo(tecServiceInfo);
    }

    // 删除
    @Override
    public int deleteTecServiceInfo(int itemID,String itemCode) {
       return this.tecServiceInfoMapper.deleteTecServiceInfo(itemID,itemCode);
    }

    // 更新
    @Override
    public int updateTecServiceInfo(TecServiceInfo tecServiceInfo) {
       return   this.tecServiceInfoMapper.updateTecServiceInfo(tecServiceInfo);
    }

    // 根据ID查询单条信息
    @Override
    public TecServiceInfo selectByItemID(int itemID,String itemCode) {
        return this.tecServiceInfoMapper.selectByItemID(itemID,itemCode);
    }
}
