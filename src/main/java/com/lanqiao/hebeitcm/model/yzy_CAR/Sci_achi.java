package com.lanqiao.hebeitcm.model.yzy_CAR;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author:YangZiYang
 * @create 2021/7/21 15:02
 */
@Data
@ToString
public class Sci_achi implements Serializable {
    private Integer itemID;
    private String itemCode;
    private String INDUSTRIAL_DEVELOP_NAME;
    private String INDUSTRIAL_DEVELOP_LEADER;
    private Integer VISIT_NUM;
    private String INDUSTRIAL_DEVELOP_STATUS;
    private String CREATER;
    private Date itemCreateAt;
    private String UPDATER;
    private Date itemUpdateAt;
    private String CONTEXT;
    private String PROJECT_NAME;
    private String CONTACTS;
    private String PHONE;
    private String ORG_CODE;
    private static final long serialVersionUID = 1L;
}
