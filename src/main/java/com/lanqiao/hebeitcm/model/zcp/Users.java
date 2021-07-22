package com.lanqiao.hebeitcm.model.zcp;

import lombok.Data;

import java.io.Serializable;

/**
 * 
 * @TableName users
 */
@Data
public class Users implements Serializable {
    /**
     * 
     */
    private Integer userId;

    /**
     * 
     */
    private String userName;

    /**
     * 
     */
    private String password;

    private static final long serialVersionUID = 1L;
}