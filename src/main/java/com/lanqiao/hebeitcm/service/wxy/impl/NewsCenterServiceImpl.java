package com.lanqiao.hebeitcm.service.wxy.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lanqiao.hebeitcm.mapper.wxy.NewsCenterMapper;
import com.lanqiao.hebeitcm.model.wxy.DataInformation;
import com.lanqiao.hebeitcm.service.wxy.NewsCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 森木
 * @date 2021/7/22 10:58
 */
@Service("newsCenterService")
@Transactional(propagation = Propagation.SUPPORTS,rollbackFor = Exception.class)
public class NewsCenterServiceImpl implements NewsCenterService {

    @Autowired
    NewsCenterMapper newsCenterMapper;

    @Override
    public Page<DataInformation> selectByDataType(Integer pageNum, Integer pageSize, String data_type) {
        return this.newsCenterMapper.selectByDataType(pageNum,pageSize,data_type);
    }

    @Override
    public DataInformation dataDetails(int itemID) {
        return this.newsCenterMapper.dataDetails(itemID);
    }

    @Override
    public void updateVisit(int visit_num, int itemID) {
        this.newsCenterMapper.updateVisit(visit_num, itemID);
    }
}
