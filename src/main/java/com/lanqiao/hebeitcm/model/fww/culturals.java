package com.lanqiao.hebeitcm.model.fww;

import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@ToString
public class culturals {
    private int itemID;
    private String itemCode;
    private String culturalname;
    private String culturalcontent;
    private String culturalsource;
    private String culturalauthor;
    private int visitnum;
    private String culturaltype;
    private String culturalstatus;
    private String creater;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date itemCreateAt;
    private String updater;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date itemupdateAt;
}
