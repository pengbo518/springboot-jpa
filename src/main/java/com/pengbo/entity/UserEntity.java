package com.pengbo.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import lombok.Data;

/**
 * tb_user
 */
@Entity
@Table(name = "tb_user")
@DynamicUpdate
@Data
public class UserEntity {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private Integer age;
	private Double height;
	private Double weight;
}
