package com.onshuu.www.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoggerInterceptor extends HandlerInterceptorAdapter{
	//인터페이스 상속받아 구현

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		log.debug("======================================          START         ======================================");
		log.debug(" Request URI \t:  " + request.getRequestURI());
		return super.preHandle(request, response, handler);
		//컨트롤러 실행 전 수행된다.
		//컨트롤러의 시작을 표시하기 위해 Start라는 메시지와 호출된 uri를 출력한다.
	}
		
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		log.debug("======================================           END          ======================================\n");
		//컨트롤러가 정상적으로 실행된 후 수행된다.
		//컨트롤러의 끝을 표시하기 위해 End라는 메시지 출력
	}
}