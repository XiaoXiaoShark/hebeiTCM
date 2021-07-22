package com.lanqiao.hebeitcm.mapper.zcp;


import com.lanqiao.hebeitcm.model.zcp.Users;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UsersMapper  {

    Users selectForLogin(Users user);

}
