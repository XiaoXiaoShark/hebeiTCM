package com.lanqiao.hebeitcm.service.dcw.chineseMedicalInstitution.impl;

import com.lanqiao.hebeitcm.mapper.dcw.chineseMedicalInstitution.CMIMapper;
import com.lanqiao.hebeitcm.model.dcw.chineseMedicalInstitution.CMIInfo;
import com.lanqiao.hebeitcm.service.dcw.chineseMedicalInstitution.ICMIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("cMIService")
@Transactional(propagation = Propagation.SUPPORTS,rollbackFor = Exception.class)
public class CMIServiceImpl implements ICMIService{
    @Autowired
    CMIMapper cMIMapper;

    @Override
    public int CMIEntry(CMIInfo cmi) {
        return this.cMIMapper.CMIEntry(cmi);
    }
}
