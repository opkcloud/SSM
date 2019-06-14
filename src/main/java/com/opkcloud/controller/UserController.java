package com.opkcloud.controller;

import com.opkcloud.model.TUser;
import com.opkcloud.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Auther: http://www.bjsxt.com
 * @Date: 2019/6/14
 * @Description: com.opkcloud.controller
 * @version: 1.0
 */
@Controller
@RequestMapping("/user")
public class UserController {

    /**
     * url: https://www.cnblogs.com/zyw-205520/p/4771253.html
     */
    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Resource
    private UserService userService;

    @RequestMapping(value = "/getUserById", method = RequestMethod.GET)
    public TUser getUserById(@RequestParam int id) {
        return userService.getUserById(id);
    }

}
