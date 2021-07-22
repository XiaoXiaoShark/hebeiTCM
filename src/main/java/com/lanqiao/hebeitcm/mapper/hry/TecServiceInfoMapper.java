package com.lanqiao.hebeitcm.mapper.hry;

import com.github.pagehelper.Page;
import com.lanqiao.hebeitcm.model.hry.TecServiceInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author 黄瑞颖
 * @create 2021-07-21 16:31
 */
@Mapper
public interface TecServiceInfoMapper {
    // 查询
    Page<TecServiceInfo> select(@Param("tec") TecServiceInfo tecServiceInfo,
                                @Param("pageNum") int pageNum, @Param("pageSize") int pageSize);

    // 添加
    int addTecServiceInfo(TecServiceInfo tecServiceInfo);

    // 删除
    int deleteTecServiceInfo(int itemID,String itemCode);

    // 更新
    int  updateTecServiceInfo(TecServiceInfo tecServiceInfo);

    // 根据ID查询单条信息
    TecServiceInfo selectByItemID(int itemID,String itemCode);

}
