package com.lanqiao.hebeitcm.mapper.hry;

import com.github.pagehelper.Page;
import com.lanqiao.hebeitcm.model.hry.TbIndustrialDevelopTalRec;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TbIndustrialDevelopTalRecMapper {

    Page<TbIndustrialDevelopTalRec> select(@Param("talRec") TbIndustrialDevelopTalRec talRec,
                                           @Param("pageNum") int pageNum, @Param("pageSize") int pageSize);

    int deleteByPrimaryKey(Integer itemid,String itemcode);

    int insert(TbIndustrialDevelopTalRec record);

    TbIndustrialDevelopTalRec selectByPrimaryKey(Integer itemid,String itemcode);

    int updateByPrimaryKey(TbIndustrialDevelopTalRec record);
}