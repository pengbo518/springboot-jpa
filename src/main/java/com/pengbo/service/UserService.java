package com.pengbo.service;

import com.pengbo.entity.UserEntity;

import java.util.List;

/**
 * @description: service
 * @author: Mr.Liu
 * @version: v1.0
 * @create: 2019-06-24 23:25
 **/
public interface UserService {
    /**
     * 查询所有用户
     * @return
     */
    List<UserEntity> queryAllUsers();



}
