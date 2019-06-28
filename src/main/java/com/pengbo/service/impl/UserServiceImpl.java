package com.pengbo.service.impl;

import com.pengbo.dao.UserDao;
import com.pengbo.dto.UserDto;
import com.pengbo.entity.UserEntity;
import com.pengbo.enums.ResultEnum;
import com.pengbo.exception.BaseException;
import com.pengbo.service.UserService;
import com.pengbo.utils.IdGenerator;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.sound.midi.Soundbank;
import java.util.List;
import java.util.Optional;

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

    @Override
    public Page<UserEntity> queryAllUsersPaging(PageRequest request) {
        Page<UserEntity> page = userDao.findAll(request);
        return page;
    }

    @Override
    public UserEntity findById(Long id) {
        Optional<UserEntity> userEntity = userDao.findById(id);
        if(!userEntity.isPresent()){
            throw new BaseException(ResultEnum.USER_NOT_EXIST);
        }
        return userEntity.get();
    }

    @Override
    public UserDto updateUserById(UserDto userDto) {
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(userDto, userEntity);
        UserEntity user = userDao.save(userEntity);
        BeanUtils.copyProperties(user, userDto);
        return userDto;
    }

    @Override
    public UserDto addUser(UserDto userDto) {
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(userDto, userEntity);
        UserEntity user = userDao.save(userEntity);
        BeanUtils.copyProperties(user, userDto);
        return userDto;
    }

    @Override
    public boolean deleteById(Long id) {
        boolean result = false;
        Optional<UserEntity> userEntity = userDao.findById(id);
        if(userEntity.isPresent()){
            userDao.deleteById(id);
            result = true;
        }
        return result;
    }
}
