package com.pengbo.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {
	SUCCESS(0, "成功"),
	USER_NOT_EXIST(-1, "暂无该用户");

	private Integer code;

	private String message;

	ResultEnum(Integer code, String message) {
		this.code = code;
		this.message = message;
	}
}
