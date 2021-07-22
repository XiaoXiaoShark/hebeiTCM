package com.lanqiao.hebeitcm.model.zcp;

import lombok.Data;

import java.io.Serializable;

/**
 * 
 * @TableName department
 */
@Data
public class Department implements Serializable {
    /**
     * 
     */
    private Integer deptno;

    /**
     * 
     */
    private String dname;

    /**
     * 
     */
    private String loc;

    private static final long serialVersionUID = 1L;
}