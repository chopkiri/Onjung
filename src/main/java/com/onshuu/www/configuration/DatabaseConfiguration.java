package com.onshuu.www.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;


@Configuration
@PropertySource("classpath:/application.properties")
//application.properties를 사용할 수 있도록 설정 파일의 위치를 지정해 준다.
//여기서는 기본으로 제공되는 application.properties 하나만 지정했는데, @PropertySource 어노테이션을 추가해서 다른 설정 파일도
//사용할 수 있다.

public class DatabaseConfiguration {
		
	@Autowired
	private ApplicationContext applicationContext;
	
	@Bean
	@ConfigurationProperties(prefix="spring.datasource.hikari")
	public HikariConfig hikariConfig() {
			return new HikariConfig();
	}
	//application.properties에 설정했던 데이터베이스 관련 정보를 사용하도록 지정한다.
	//@ConfigurationProperties 어노테이션에 prefix가 spring.datasource.hikari로 설정되어 있기 때문에
	//spring.datasource.hikari로 시작하는 설정을 이용해서 히카리의 cp의 설정파일을 만든다.
	
	@Bean
	public DataSource dataSource() throws Exception{
		DataSource dataSource = new HikariDataSource(hikariConfig());
		System.out.println(dataSource.toString());
		return dataSource;
	}
	//앞에서 만든 히카리cp의 설정 파일을 이용해서 데이터베이스와 연결하는 데이터 소스를 생성한다.
	//여기서는 데이터 소스가 정상적으로 생성되었는 지 확인하기 위해서 데이터 소스를 출력했습니다.
	
	@Bean
	@ConfigurationProperties(prefix="spring.jpa")
	public Properties hibernateConfig(){
		return new Properties();
	}
	//JPA 설정 빈
	
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception{
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);
		sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:/mapper/**/sql-*.xml"));
		//classpath = resources 폴더를 의미
		// /mapper/**/ = mapper 폴더 밑의 모든 폴더를 의미
		// /sql-*.xml 이름이 sql-로 시작하고 확장자가 xml인 모든 파일을 의미
		sqlSessionFactoryBean.setConfiguration(mybatisConfig());
		
		return sqlSessionFactoryBean.getObject();
	}
		
	@Bean
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory){
		return new SqlSessionTemplate(sqlSessionFactory);
		
	}
	
	@Bean
	@ConfigurationProperties(prefix="mybatis.configuration")
	//applicationProperties의 설정 중 마이바티스에 관련된 설정을 가져온다.
	public org.apache.ibatis.session.Configuration mybatisConfig() {
		return new org.apache.ibatis.session.Configuration();
		//가져온 마이바티스 설정을 자바 클래스로 만들어서 반환합니다.
		//카멜레터-스네이크레터 매핑하는 환경설정 적용
	}
	
	
}

//Maven의 root context