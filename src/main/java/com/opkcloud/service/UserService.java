package com.opkcloud.service;

import com.opkcloud.model.TUser;

import java.util.List;

/**
 * @Auther: http://www.bjsxt.com
 * @Date: 2019/6/14
 * @Description: com.opkcloud.service
 * @version: 1.0
 */
public interface UserService {

    public TUser getUserById(int id);

    public List<TUser> findAllUser();

}
