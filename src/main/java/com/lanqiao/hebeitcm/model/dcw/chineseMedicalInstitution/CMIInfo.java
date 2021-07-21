package com.lanqiao.hebeitcm.model.dcw.chineseMedicalInstitution;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class CMIInfo {
    private String hospital_name;
    private String hospital_level;
    private String hospital_key_specialty;
    private String hospital_brief_introduce;
    private String hospital_introduce;
    private String hospital_telephone;
    private String hospital_addredd_pro;
    private String hospital_address_city;
    private String hospital_address_country;
    private String hospital_address;
    private String hospital_link;
    private Integer hospital_status;
    private String creater;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date itemCreateAt;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date itemUpdateAt;
    private String org_code;

}
