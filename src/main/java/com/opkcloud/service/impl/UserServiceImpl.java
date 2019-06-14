package com.opkcloud.service.impl;

import com.opkcloud.mapper.TUserMapper;
import com.opkcloud.model.TUser;
import com.opkcloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: http://www.bjsxt.com
 * @Date: 2019/6/14
 * @Description: com.opkcloud.service.impl
 * @version: 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private TUserMapper userMapper;

    @Override
    public TUser getUserById(int id) {
        return userMapper.selectByPrimaryKey(id);
    }

}
