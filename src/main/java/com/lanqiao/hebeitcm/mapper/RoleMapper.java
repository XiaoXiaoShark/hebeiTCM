package com.lanqiao.hebeitcm.mapper;


import org.apache.ibatis.annotations.Mapper;

/**
 * @Entity com.lanqiao.hebeitcm.domain.Role
 */
@Mapper
public interface RoleMapper  {

    public String selectTypeName(String roleId);

}
