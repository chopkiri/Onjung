package com.onshuu.www.info.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="jpa_rec")
@NoArgsConstructor
@Data
public class RecEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int recNum;

	@Column(nullable=false)
	private String recCompany;
	
	@Column(nullable=false)
	private String recPosit;
	
	@Column(nullable=false)
	private String recQual;
	
	@Column(nullable=false)
	private String recSal;
	
	@Column(nullable=false)
	private String recDeadline;
	
	@Column(nullable=false)
	private String recInput;
	
	@Column(nullable=false)
	private int recView = 0;
	
	@Column(nullable=false)
	private String creatorId;
	
}
