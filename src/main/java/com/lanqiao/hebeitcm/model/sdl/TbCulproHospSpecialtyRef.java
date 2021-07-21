package com.lanqiao.hebeitcm.model.sdl;


import lombok.Data;
import lombok.ToString;
import java.io.Serializable;
/**
 * 医院和科室关联信息记录表
 * @author 石都林
 * @TableName tb_culpro_hosp_specialty_ref
 */
@Data
@ToString
public class TbCulproHospSpecialtyRef implements Serializable{

  private long itemId;
  private String itemCode;
  private String hospitalCode;
  private String specialtyCode;
  private String creater;
  private java.sql.Timestamp itemCreateAt;
  private String updater;
  private java.sql.Timestamp itemUpdateAt;

  private static final long serialVersionUID = 1L;
}
