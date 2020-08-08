package com.onshuu.www.log.dto;

import lombok.Data;

@Data
public class LoginDto {
	
	private String memId;
	private String memPassword;
	private String memName;
	private String memNick;
	private String memEmail;
	private String memAdmin;
}	