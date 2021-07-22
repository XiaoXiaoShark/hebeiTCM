package com.lanqiao.hebeitcm.service.impl;

import com.lanqiao.hebeitcm.mapper.RoleMapper;
import com.lanqiao.hebeitcm.mapper.UserMapper;
import com.lanqiao.hebeitcm.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service("userService")
public class UserServiceImpl implements UserDetailsService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;
    /**
     * 我们自己写的根据用户名从数据库查询用户信息
     * @param username
     * @return
     */
    public User findUserByName(String username) {
        return userMapper.selectByName(username);
    }

    /**
     * UserDetailsService 接口提供的根据用户名获取用户信息的方法
     *
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 调用我们自己的findUserByName 方法
        return this.findUserByName(username);
    }

    /**
     * @description: TODO
     * @params: [id]
     * @return: 权限名
     * @author: 小小
     * @dateTime: 2021/7/22 11:34
     */
    public String getTypeName(Integer id){
        return roleMapper.selectTypeName(String.valueOf(id));
    }
}
