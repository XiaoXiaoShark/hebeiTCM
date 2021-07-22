package com.lanqiao.hebeitcm.service.impl.fww;

import com.github.pagehelper.Page;
import com.lanqiao.hebeitcm.mapper.fww.CultureMapper;
import com.lanqiao.hebeitcm.model.fww.culturals;
import com.lanqiao.hebeitcm.service.fww.CultureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("cultureService")
@Transactional(propagation = Propagation.SUPPORTS,rollbackFor = Exception.class)
public class CultureServiceImpl implements CultureService {
    @Autowired
    CultureMapper cultureMapper;

    @Override
    public List<culturals> selectAllFilms() {
        return this.cultureMapper.selectAllFilms();
    }
}
