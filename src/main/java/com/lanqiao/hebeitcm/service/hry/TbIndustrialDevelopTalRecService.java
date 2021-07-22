package com.lanqiao.hebeitcm.service.hry;

import com.github.pagehelper.Page;
import com.lanqiao.hebeitcm.model.hry.TbIndustrialDevelopTalRec;

/**
 * @author 黄瑞颖
 * @create 2021-07-22 14:29
 */
public interface TbIndustrialDevelopTalRecService {
    Page<TbIndustrialDevelopTalRec> select(TbIndustrialDevelopTalRec talRec,
                                           int pageNum, int pageSize);

    int deleteByPrimaryKey(Integer itemid,String itemcode);

    int insert(TbIndustrialDevelopTalRec record);

    TbIndustrialDevelopTalRec selectByPrimaryKey(Integer itemid,String itemcode);

    int updateByPrimaryKey(TbIndustrialDevelopTalRec record);
}
