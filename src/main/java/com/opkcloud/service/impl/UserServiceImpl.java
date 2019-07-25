package com.opkcloud.service.impl;

import com.alibaba.fastjson.JSON;
import com.opkcloud.dao.TUserMapper;
import com.opkcloud.model.TUser;
import com.opkcloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service("UserService")
public class UserServiceImpl implements UserService {

    @Autowired
    private TUserMapper userMapper;

    @Override
    public TUser getUserById(int id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<TUser> findAllUser() {
        List<TUser> list = new ArrayList<>();
        TUser user = new TUser();
        user.setAge(111);
        user.setId(111);
        user.setName("111");
        list.add(user);
        System.out.println(JSON.toJSONString(list));
        return list;
    }

}
