package com.lanqiao.hebeitcm.model.sdl;


import lombok.Data;
import lombok.ToString;
import java.io.Serializable;
/**
 * 医院信息记录表
 * @author 石都林
 * @TableName tb_culpro_hosp
 */
@Data
@ToString
public class TbCulproHosp implements Serializable{

  private long itemId;
  private String itemCode;
  private String hospitalName;
  private String hospitalLevel;
  private String hospitalKeySpecialty;
  private String hospitalBriefIntroduce;
  private String hospitalIntroduce;
  private String hospitalTelephone;
  private String hospitalAddressPro;
  private String hospitalAddressCity;
  private String hospitalAddressCountry;
  private String hospitalAddress;
  private String hospitalLink;
  private String hospitalStatus;
  private String creater;
  private java.sql.Timestamp itemCreateAt;
  private String updater;
  private java.sql.Timestamp itemUpdateAt;
  private String orgCode;

  private static final long serialVersionUID = 1L;
}
