package com.lanqiao.hebeitcm.service.dcw.chineseMedicalInstitution;

import com.lanqiao.hebeitcm.model.dcw.chineseMedicalInstitution.CMIInfo;
import org.apache.ibatis.annotations.Mapper;

public interface ICMIService {
    public int CMIEntry(CMIInfo cmi);

}
