package com.pengbo.dto;

import lombok.Data;

/**
 * @description: userDto
 * @author: Mr.Liu
 * @version: v1.0
 * @create: 2019-06-25 23:57
 **/
@Data
public class UserDto {
    private Long id;
    private String name;
    private Integer age;
    private Double height;
    private Double weight;
}
