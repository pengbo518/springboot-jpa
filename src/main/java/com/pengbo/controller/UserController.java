package com.pengbo.controller;

import com.pengbo.entity.UserEntity;
import com.pengbo.service.UserService;
import com.pengbo.utils.ResultVOUtil;
import com.pengbo.vo.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description: controller
 * @author: Mr.Liu
 * @version: v1.0
 * @create: 2019-06-24 23:29
 **/
// @Controller
// @ResponseBody
// @RestController相当于@Controller + @ResponseBody
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/queryAllUsers")
    public ResponseEntity queryAllUsers(){
        List<UserEntity> userList = userService.queryAllUsers();
        return ResultVOUtil.success(userList);
    }



}
