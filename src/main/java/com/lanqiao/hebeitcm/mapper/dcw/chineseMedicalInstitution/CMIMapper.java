package com.lanqiao.hebeitcm.mapper.dcw.chineseMedicalInstitution;

import com.lanqiao.hebeitcm.model.dcw.chineseMedicalInstitution.CMIInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CMIMapper {
    public int CMIEntry(CMIInfo cmi);
}
