package com.practice.exception;

import java.util.Date;

import lombok.Data;

@Data
public class ExceptionMessage {
	
	private String code;
	private String msg;
	private Date date;


}
