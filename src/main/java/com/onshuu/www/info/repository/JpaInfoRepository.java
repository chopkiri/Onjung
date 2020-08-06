package com.onshuu.www.info.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.onshuu.www.info.entity.InfoEntity;

public interface JpaInfoRepository extends CrudRepository<InfoEntity, Integer> {
	//CrudRepository 인터페이스는 리포지터리에서 사용할 도메인 클래스, 도메인의 id타입을 파라미터로 받는다.
	
	List<InfoEntity> findAllByOrderByNewsNumDesc();
	
}
