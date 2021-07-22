package com.lanqiao.hebeitcm.service.hry;

import com.github.pagehelper.Page;
import com.lanqiao.hebeitcm.model.hry.TbIndustrialDevelopCooExc;
import org.apache.ibatis.annotations.Param;

/**
 * @author 黄瑞颖
 * @create 2021-07-22 11:18
 */
public interface TbIndustrialDevelopCooExcService {

    Page<TbIndustrialDevelopCooExc> select(TbIndustrialDevelopCooExc tbIndustrialDevelopCooExc,int pageNum,int pageSize);

    TbIndustrialDevelopCooExc selectByPrimaryKey(Integer key,String uuid);

    int deleteByPrimaryKey(Integer itemid,String itemcode);

    int insert(TbIndustrialDevelopCooExc record);

    int update(TbIndustrialDevelopCooExc record);
}
