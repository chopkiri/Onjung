package com.onshuu.www.log.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="shuu_mem")
@NoArgsConstructor
@Data
public class ShuMem {
	
	@Id
	private String id;
	
	@Column(nullable=false)
	private String password;
	
	@Column(nullable=false)
	private String name;
	
	@Column(nullable=false)
	private String nick;
	
	@Column(nullable=false)
	private String email;
	
	@Column
	private String admin;
	
}
	
