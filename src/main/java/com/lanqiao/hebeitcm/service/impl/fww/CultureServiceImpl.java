package com.lanqiao.hebeitcm.service.impl.fww;

import com.lanqiao.hebeitcm.mapper.fww.CultureMapper;
import com.lanqiao.hebeitcm.service.fww.CultureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("cultureService")
@Transactional(propagation = Propagation.SUPPORTS,rollbackFor = Exception.class)
public class CultureServiceImpl implements CultureService {
    @Autowired
    CultureMapper cultureMapper;

}
