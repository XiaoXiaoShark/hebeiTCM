package com.lanqiao.hebeitcm.service.hry;

import com.github.pagehelper.Page;
import com.lanqiao.hebeitcm.model.hry.TecServiceInfo;

/**
 * @author 黄瑞颖
 * @create 2021-07-21 15:41
 */
public interface TecServiceInfoService {

    // 查询
    Page<TecServiceInfo> select(TecServiceInfo tecServiceInfo, int pageNum, int pageSize);

    // 添加
    int addTecServiceInfo(TecServiceInfo tecServiceInfo);

    // 删除
    int deleteTecServiceInfo(int itemID,String itemCode);

    // 更新
    int updateTecServiceInfo(TecServiceInfo tecServiceInfo);

    // 根据ID查询单条信息
    TecServiceInfo selectByItemID(int itemID,String itemCode);
}
