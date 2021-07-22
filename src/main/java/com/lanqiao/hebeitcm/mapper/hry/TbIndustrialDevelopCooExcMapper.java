package com.lanqiao.hebeitcm.mapper.hry;

import com.github.pagehelper.Page;
import com.lanqiao.hebeitcm.model.hry.TbIndustrialDevelopCooExc;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TbIndustrialDevelopCooExcMapper {

    Page<TbIndustrialDevelopCooExc> select(@Param("TbI") TbIndustrialDevelopCooExc tbIndustrialDevelopCooExc,
                                           @Param("pageNum") int pageNum, @Param("pageSize") int pageSize);

    TbIndustrialDevelopCooExc selectByPrimaryKey(Integer itemid,String itemcode);

    int deleteByPrimaryKey(Integer itemid,String itemcode);

    int insert(TbIndustrialDevelopCooExc record);

    int update(TbIndustrialDevelopCooExc record);
}