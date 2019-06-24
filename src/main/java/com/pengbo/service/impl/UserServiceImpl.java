package com.pengbo.service.impl;

import com.pengbo.dao.UserDao;
import com.pengbo.entity.UserEntity;
import com.pengbo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description: service impl
 * @author: Mr.Liu
 * @version: v1.0
 * @create: 2019-06-24 23:26
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public List<UserEntity> queryAllUsers() {
        return userDao.findAll();
    }
}
