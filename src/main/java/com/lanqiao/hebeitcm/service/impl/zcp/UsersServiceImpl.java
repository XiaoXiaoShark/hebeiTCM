package com.lanqiao.hebeitcm.service.impl.zcp;


import com.lanqiao.hebeitcm.mapper.zcp.UsersMapper;
import com.lanqiao.hebeitcm.model.zcp.Users;
import com.lanqiao.hebeitcm.service.zcp.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
*
*/
@Service("usersService")
@Transactional(propagation = Propagation.SUPPORTS, rollbackFor = Exception.class)
public class UsersServiceImpl implements UsersService {

    @Autowired
    UsersMapper usersMapper;

    @Override
    public Users selectForLogin(Users user) {
        return usersMapper.selectForLogin(user);
    }




}
