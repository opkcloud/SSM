package com.opkcloud.controller;

import com.opkcloud.model.TUser;
import com.opkcloud.service.UserService;
import com.opkcloud.util.JsonResult;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 搭建教程：https://blog.csdn.net/yeyazhishang/article/details/86650053
 * swagger 配置: https://blog.csdn.net/panda_in5/article/details/78843205
 *              https://blog.csdn.net/zzq272804553/article/details/85393152
 * swagger api url: http://localhost:8080/ssm/swagger-ui.html
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getUserById", method = RequestMethod.GET)
    @ApiOperation(value = "根据id查询用户信息", httpMethod = "GET", notes = "根据id查询用户信息")
    public TUser getUserById(@RequestParam int id) {
        return userService.getUserById(id);
    }

    @RequestMapping(value = "/getUserById2", method = RequestMethod.GET)
    @ApiOperation(value = "返回格式化结果", httpMethod = "GET", notes = "返回格式化结果")
    public JsonResult<TUser> getUserById2(@RequestParam int id) {
        JsonResult result = new JsonResult();
        result.setSuccess(true);
        result.setMsg("查询数据成功");
        result.setData(userService.getUserById(id));
        return result;
    }

}
