package com.pengbo.service;

import com.pengbo.dto.UserDto;
import com.pengbo.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

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

    /**
     * 分页查询所有用户
     * @param requests
     * @return
     */
    Page<UserEntity> queryAllUsersPaging(PageRequest requests);

    /**
     * 通过ID查询用户
     * @param id
     * @return
     */
    UserEntity findById(Long id);

    UserDto updateUserById(UserDto userDto);

}
