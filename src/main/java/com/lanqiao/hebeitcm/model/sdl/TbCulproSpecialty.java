package com.lanqiao.hebeitcm.model.sdl;


import lombok.Data;
import lombok.ToString;
import java.io.Serializable;
/**
 * 科室信息记录表
 * @author 石都林
 * @TableName tb_culpro_specialty
 */

@Data
@ToString
public class TbCulproSpecialty implements Serializable{

  private long itemId;
  private String itemCode;
  private String specialtyName;
  private String specialtyIntroduce;
  private String specialtyPhone;
  private String specialtyAddressPro;
  private String specialtyAddressCity;
  private String specialtyAddressCounty;
  private String specialtyAddress;
  private String specialtyLink;
  private String specialtyStatus;
  private String creater;
  private java.sql.Timestamp itemCreateAt;
  private String updater;
  private java.sql.Timestamp itemUpdateAt;
  private String specialtyBriefIntroduce;

  private static final long serialVersionUID = 1L;
}
