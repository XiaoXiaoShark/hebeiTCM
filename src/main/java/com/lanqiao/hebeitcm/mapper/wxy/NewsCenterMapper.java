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

    public Page<DataInformation> selectByDataType(@Param("pageNum") int pageNum,
                                 @Param("pageSize")int pageSize,
                                  @Param("data_type") String data_type);

    public DataInformation dataDetails(int itemID);

    public void updateVisit(@Param("visit_num") int visit_num,
                            @Param("itemID") int itemID);
}
