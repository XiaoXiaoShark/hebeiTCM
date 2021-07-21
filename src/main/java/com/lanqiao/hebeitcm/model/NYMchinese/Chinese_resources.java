package com.lanqiao.hebeitcm.model.NYMchinese;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author 宁有漫  on 2021/7/21 16:02
 */
//定义实体类，文化资源
@Data
@ToString
public class Chinese_resources implements Serializable {

    private Integer itemID;

    private Integer itemCode;

    private String CHINESE_CULTURAL_NAME;

    private String CHINESE_CULTURAL_CONTENT;

    private String CHINESE_CULTURAL_SOURCE;

    private String CHINESE_CULTURAL_AUTHOR;

    private Integer VISIT_NUM;


}
