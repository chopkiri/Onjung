package com.onshuu.www.info.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
//엔티티 클래스는 테이블과 매핑된다.
@Table(name="jpa_news")
//jpa_news 테이블과 매핑되도록 한다.
@NoArgsConstructor
@Data
public class InfoEntity {
	@Id
	//엔티티의 기본키(PK)임을 나타낸다.
	@GeneratedValue(strategy=GenerationType.AUTO)
	//기본키의 생성 전략 설정. GeneratedType.AUTO로 지정할 경우 데이터베이스에서 제공하는 기본키 생성 전략을 따르게 된다.
	//MySQL은 자동 증가를 지원하므로 기본키가 자동으로 증가, 오라클의 경우 기본키에 사용할 시퀀스를 생성하게 된다.
	private int newsNum;

	@Column(nullable=false) //Not Null속성 지정
	private String newsTitle;
	
	@Column(nullable=false)
	private String newsInput;
	
	@Column(nullable=false)
	private int newsView = 0;
	
	@Column(nullable=false)
	private String creatorId;
	
	@Column(nullable=false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private LocalDateTime newsDate = LocalDateTime.now();
	//작성시간의 초기값 설정. 가능하면 특정 데이터베이스에 의존적인 초기값은 사용하지 않는 게 좋다.
}