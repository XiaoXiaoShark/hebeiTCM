package com.lanqiao.hebeitcm.model.sdl;


import lombok.Data;
import lombok.ToString;
import java.io.Serializable;

/**
 * 老中医信息记录表
 * @author 石都林
 * @TableName employee
 */
@Data
@ToString
public class TbCulproChineseMedicine implements Serializable {

  private long itemId;
  private String itemCode;
  private String chineseMedicineName;
  private String chineseMedicineType;
  private String chineseMedicineTitle;
  private String deptCode;
  private String hospCode;
  private String visitTime;
  private String phone;
  private String expertIntroduce;
  private String expertBriefIntroduce;
  private String mainVisit;
  private String medicineRecords;
  private String chineseMedicineStatus;
  private String creater;
  private java.sql.Timestamp itemCreateAt;
  private String updater;
  private java.sql.Timestamp itemUpdateAt;

  private static final long serialVersionUID = 1L;
}
