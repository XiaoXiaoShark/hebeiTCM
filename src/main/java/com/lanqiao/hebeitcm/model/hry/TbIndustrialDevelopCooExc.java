package com.lanqiao.hebeitcm.model.hry;

import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * tb_industrial_develop_coo_exc
 * @author 
 */
@Data
@ToString
public class TbIndustrialDevelopCooExc implements Serializable {
    /**
     * 自增id
     */
    private Integer itemid;

    /**
     * UUID
     */
    private String itemcode;
    /**
     * 合作交流名称
     */
    private String cooperationExchangeName;

    /**
     * 主研人
     */
    private String cooperationExchangeLeader;

    /**
     * 浏览次数
     */
    private Integer visitNum;

    /**
     * 项目简介
     */
    private String projectIntroduce;

    /**
     * 联系人
     */
    private String contacts;

    /**
     * 联系电话
     */
    private String phone;

    /**
     * 预期合作机构
     */
    private String cooperativeOrg;

    /**
     * 数据状态
     */
    private String status;

    /**
     * 创建者
     */
    private String creater;

    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date itemcreateat;

    /**
     * 修改人
     */
    private String updater;

    /**
     * 修改时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date itemupdateat;

    /**
     * 用户所在机构code
     */
    private String orgCode;

    private static final long serialVersionUID = 1L;


}