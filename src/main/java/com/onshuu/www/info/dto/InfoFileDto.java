package com.onshuu.www.info.dto;

import lombok.Data;

@Data
public class InfoFileDto {
	
	private int idx;
	private int boardIdx;
	private String originalFileName;
	private String storedFilePath;
	private long fileSize;
}
