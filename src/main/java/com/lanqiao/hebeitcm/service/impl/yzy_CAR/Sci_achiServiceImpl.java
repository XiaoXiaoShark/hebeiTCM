package com.lanqiao.hebeitcm.service.impl.yzy_CAR;

import com.lanqiao.hebeitcm.mapper.yzy_CAR.Sci_achiMapper;
import com.lanqiao.hebeitcm.service.yzy_CAR.Sci_achiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:YangZiYang
 * @create 2021/7/21 16:00
 */
@Service("sci_achiService")
public class Sci_achiServiceImpl implements Sci_achiService {
    @Autowired
    Sci_achiMapper sci_achiMapper;
    @Override
    public List selectForAll() {
        return sci_achiMapper.selectForAll();
    }
}
