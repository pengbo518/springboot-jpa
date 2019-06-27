package com.pengbo.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @description: userVo
 * @author: Mr.Liu
 * @version: v1.0
 * @create: 2019-06-25 23:55
 **/
@Data
public class UserVo implements Serializable {
    @NotNull
    private Long id;
    private String name;
    private Integer age;
    private Double height;
    private Double weight;
}
