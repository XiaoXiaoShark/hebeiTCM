package com.lanqiao.hebeitcm.service.wxy;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.lanqiao.hebeitcm.model.wxy.DataInformation;

import java.util.List;

/**
 * @author 森木
 * @date 2021/7/22 10:55
 */
public interface NewsCenterService {

    public Page<DataInformation> selectByDataType(Integer pageNum,Integer pageSize,String data_type);

    public DataInformation dataDetails(int itemID);

    public void updateVisit(int visit_num, int itemID);
}
