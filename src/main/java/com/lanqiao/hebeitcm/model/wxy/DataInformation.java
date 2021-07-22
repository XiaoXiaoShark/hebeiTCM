package com.lanqiao.hebeitcm.model.wxy;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * @author 森木
 * @date 2021/7/22 9:00
 */
@Data
public class DataInformation {
    private Integer itemID;//编号
    private String data_title;//标题
    private String data_author;//作者
    private String data_source;//来源
    private Integer visit_num;//浏览次数
    private String data_content;//内容
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String data_delayed_release;//延时发布
    private String data_status;//状态
    private String data_type;//类型
    private String release_or_not;//是否录入中医药网
}
