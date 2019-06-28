package com.pengbo.entity;

import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.Data;

/**
 * tb_user
 */
@Entity
@Table(name = "tb_user")
@DynamicUpdate
@DynamicInsert
@Data
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Integer age;
	private Double height;
	private Double weight;
}
