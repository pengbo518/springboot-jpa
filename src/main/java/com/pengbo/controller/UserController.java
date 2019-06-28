package com.pengbo.controller;

import com.pengbo.dto.UserDto;
import com.pengbo.entity.UserEntity;
import com.pengbo.enums.ResultEnum;
import com.pengbo.service.UserService;
import com.pengbo.utils.ResultVOUtil;
import com.pengbo.vo.ResponseEntity;
import com.pengbo.vo.UserVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

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

    /**
     * 查询所有用户
     * @return
     */
    @GetMapping("/queryAllUsers")
    public ResponseEntity queryAllUsers(){
        List<UserEntity> userList = userService.queryAllUsers();
        return ResultVOUtil.success(userList);
    }

    /**
     * 分页查询所有用户
     * @param page
     * @param size
     * @return
     */
    @SuppressWarnings("deprecation")
    @GetMapping("/queryAllUsersPaging")
    public ResponseEntity queryAllUsersPaging(@RequestParam(value = "page", defaultValue = "0") Integer page, @RequestParam(value = "size", defaultValue = "3") Integer size){
        PageRequest request = new PageRequest(page, size);
        Page<UserEntity> paging = userService.queryAllUsersPaging(request);
        return ResultVOUtil.success(paging);
    }

    /**
     * 通过ID查询用户
     * @param id 主键ID
     * @return
     */
    @GetMapping("/findById/{id}")
    public ResponseEntity findById(@PathVariable Long id){
        UserEntity user = userService.findById(id);
        return  ResultVOUtil.success(user);
    }

    /**
     * 通过ID修改用户信息
     * @param userVo
     * @return
     */
    @PostMapping(value = "/updateUserById")
    public ResponseEntity updateUserById(@RequestBody UserVo userVo){
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userVo, userDto);
        UserDto result = userService.updateUserById(userDto);
        return ResultVOUtil.success(result);
    }

    /**
     * 添加用户信息
     * @param name
     * @param age
     * @param height
     * @param weight
     * @return
     */
    @PostMapping("/addUser")
    public ResponseEntity addUser(String name, Integer age, Double height, Double weight){
        UserDto userDto = new UserDto();
        userDto.setName(name);
        userDto.setAge(age);
        userDto.setHeight(height);
        userDto.setWeight(weight);
        UserDto result = userService.addUser(userDto);
        return ResultVOUtil.success(result);
    }

    /**
     * 通过ID删除用户信息
     * @param id
     * @return
     */
    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity deleteById(@PathVariable Long id){
        boolean result = userService.deleteById(id);
        if(!result){
            return ResultVOUtil.error(ResultEnum.DELETE_FAILED);
        }
        return ResultVOUtil.success(result);
    }

}
