package com.lanqiao.hebeitcm.mapper.wxy;

import com.github.pagehelper.Page;
import com.lanqiao.hebeitcm.model.wxy.DataInformation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 森木
 * @date 2021/7/22 10:49
 */
public interface NewsCenterMapper {

    public List<DataInformation> selectByDataType(String data_type);

    public void updateVisit(@Param("visit_num") int visit_num,
                            @Param("itemID") int itemID);
}
