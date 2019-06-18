package com.opkcloud.service.impl;

import com.opkcloud.dao.TUserMapper;
import com.opkcloud.model.TUser;
import com.opkcloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("UserService")
public class UserServiceImpl implements UserService {

    @Autowired
    private TUserMapper userMapper;

    @Override
    public TUser getUserById(int id) {
        return userMapper.selectByPrimaryKey(id);
    }

}
