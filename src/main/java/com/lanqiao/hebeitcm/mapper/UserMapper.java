package com.lanqiao.hebeitcm.mapper;

import com.lanqiao.hebeitcm.model.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Entity com.lanqiao.hebeitcm.model.User
 */
@Mapper
public interface UserMapper  {

    public User selectByName(String username);

    public Boolean insertUser(User user);

}
