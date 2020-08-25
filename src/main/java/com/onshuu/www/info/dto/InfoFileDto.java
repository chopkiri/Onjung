package com.onshuu.www.info.dto;

import lombok.Data;

@Data
public class InfoFileDto {
	
	private int num;
	private int newsNum;
	private String originalFileName;
	private String storedFilePath;
	private long fileSize;
}
