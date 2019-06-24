package com.pengbo.dao;

import com.pengbo.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @description: dao
 * @author: Mr.Liu
 * @version: v1.0
 * @create: 2019-06-24 23:20
 **/
public interface UserDao extends JpaRepository<UserEntity, Integer> {

}
