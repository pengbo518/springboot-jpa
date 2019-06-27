package com.pengbo.exception;

import com.pengbo.enums.ResultEnum;

import lombok.Getter;

@Getter
public class BaseException extends RuntimeException {
	private static final long serialVersionUID = -2008908830831638247L;
	private Integer code;
	
	public BaseException(ResultEnum resultEnum){
		super(resultEnum.getMessage());
		this.code = resultEnum.getCode();
	}
	
	public BaseException(String message) {
		super(message);
		this.code = 9999;
	}
	
}
