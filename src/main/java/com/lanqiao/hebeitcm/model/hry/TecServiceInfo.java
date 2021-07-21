package com.lanqiao.hebeitcm.model.hry;

import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author 黄瑞颖
 * @create 2021-07-21 15:43
 */
@Data
@ToString
public class TecServiceInfo {
    // 自增id
    private Integer itemID;

    // UUID
    private String itemCode;

    // 服务项目名称
    private String SERVICE_PROJECT;

    // 项目收费
    private String PROJECT_COST;

    // 联系电话
    private String PHONE;

    // 联系人
    private String CONTACTS;

    // 服务项目介绍
    private String PROJECT_INTRODUCE;

    // 数据状态
    private String STATUS;

    // 用户所在机构code
    private String ORG_CODE;

    // 创建者
    private String CREATER;

    // 创建时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date itemCreateAt;

    // 修改人
    private String UPDATER;

    // 修改时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date itemUpdateAt;

    // 浏览次数
    private Integer VISIT_NUM;



}
