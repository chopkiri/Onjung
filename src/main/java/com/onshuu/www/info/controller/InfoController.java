package com.onshuu.www.info.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.onshuu.www.info.dto.InfoDto;
import com.onshuu.www.info.service.InfoService;

@Controller
//스프링 MVC의 컨트롤러를 의미. @Controller 어노테이션을 붙여줌으로써 해당 클래스를 컨트롤러로 동작하게 한다.
public class InfoController {
			
	@Autowired
	private InfoService infoService; 
	//비즈니스 로직을 처리하는 서비스 빈을 연결
			
	@RequestMapping(value = "/main")
	public String main() {
		return "index";
	}

			
	@RequestMapping("/info/openNewsList")
	//웹브라우저에서 /board/openBoardList.do라는 주소를 호출하면 스프링 디스패처는 호출된 주소와 @RequestMappng 어노테이션의 값이
	//동일한 메소드를 찾아서 실행한다. 즉, 클라이언트에서 호출한 주소와 그것을 수행할 메소드를 연결
	public ModelAndView openNewsList() throws Exception{
		ModelAndView mv = new ModelAndView("/newsList");
		//호출된 요청의 결과를 보여줄 뷰를 지정
		//여기서 지정한 값은 templates 폴더 아래의 board/board.html을 의미
		//Thymeleaf와 같은 템플릿을 사용할 경우 스프링 부트의 자동 설정 기능으로 .html과 같은 접미사를 생략할 수 있다.
				
		List<InfoDto> list = infoService.selectNewsList();
		//게시글 목록을 조회
		//"게시글 목록을 조회한다"는 비즈니스 로직을 수행하기 위해 BoardService 클래스의 selectBoardList 메소드를 호출한다.
		//게시글 목록을 조회하기 위해 List 인터페이스 사용
		mv.addObject("list", list);
		//실행된 비즈니스 로직의 결과 값을 뷰에 list라는 이름으로 저장
		//뷰에서 사용할 경우 list라는 이름으로 조회 결과를 사용할 수 있다.
				
		return mv;
	}
			
	@RequestMapping("/info/openNewsWrite")
	public String openNewsWrite() throws Exception{
		return "/newsWrite";
	}
	//게시글 등록 화면을 호출
			
	@RequestMapping("/info/insertNews")
	//폼에서 action 속성에 insertBoard.do를 지정
	public String insertNews(InfoDto board) throws Exception{
		infoService.insertNews(board);
		//service영역의 insert 메소드 호출
		return "redirect:/info/openNewsList";
		//뷰 호출x, 리다이렉트 해서 목록 화면으로 돌아간다.
	}
	//게시글을 등록
			
	@RequestMapping("/info/openNewsDetail")
	//요기서 요청이 오면
	public ModelAndView openNewsDetail(@RequestParam int newsNum) throws Exception{
		//요청 파라미터는 글번호
		ModelAndView mv = new ModelAndView("/newsDetail");
		//보드 디테일로 결과를 전송할거다
		
		InfoDto board = infoService.selectNewsDetail(newsNum);
		//글번호 파라미터로 받는 서비스 메소드 실행해서 결과를 DTO에 담을거다
		mv.addObject("board", board);
		//결과를 모델엔뷰에 담는다
		
		return mv;
		//그 모델앤뷰를 반환해서 아까 저 주소로 보낸다.
	}
			
	@RequestMapping("/info/updateNews")
	public String updateNews(InfoDto board) throws Exception{
		infoService.updateNews(board);
		return "redirect:/info/openNewsList";
	}
			
	@RequestMapping("/info/deleteNews")
	public String deleteNews(int newsNum) throws Exception{
		infoService.deleteNews(newsNum);
		return "redirect:/info/openNewsList";
	}
	
	
	
	
	
	@RequestMapping("/info/openRecList")
	//웹브라우저에서 /board/openBoardList.do라는 주소를 호출하면 스프링 디스패처는 호출된 주소와 @RequestMappng 어노테이션의 값이
	//동일한 메소드를 찾아서 실행한다. 즉, 클라이언트에서 호출한 주소와 그것을 수행할 메소드를 연결
	public ModelAndView openRecList() throws Exception{
		ModelAndView mv = new ModelAndView("/info/recruitList");
		//호출된 요청의 결과를 보여줄 뷰를 지정
		//여기서 지정한 값은 templates 폴더 아래의 board/board.html을 의미
		//Thymeleaf와 같은 템플릿을 사용할 경우 스프링 부트의 자동 설정 기능으로 .html과 같은 접미사를 생략할 수 있다.
				
		List<InfoDto> list = infoService.selectRecList();
		//게시글 목록을 조회
		//"게시글 목록을 조회한다"는 비즈니스 로직을 수행하기 위해 BoardService 클래스의 selectBoardList 메소드를 호출한다.
		//게시글 목록을 조회하기 위해 List 인터페이스 사용
		mv.addObject("list", list);
		//실행된 비즈니스 로직의 결과 값을 뷰에 list라는 이름으로 저장
		//뷰에서 사용할 경우 list라는 이름으로 조회 결과를 사용할 수 있다.
				
		return mv;
	}
			
	@RequestMapping("/info/openRecWrite")
	public String openRecWrite() throws Exception{
		return "/info/recruitWrite";
	}
	//게시글 등록 화면을 호출
			
	@RequestMapping("/info/insertRec")
	//폼에서 action 속성에 insertBoard.do를 지정
	public String insertRec(InfoDto board) throws Exception{
		infoService.insertRec(board);
		//service영역의 insert 메소드 호출
		return "redirect:/info/openRecList";
		//뷰 호출x, 리다이렉트 해서 목록 화면으로 돌아간다.
	}
	//게시글을 등록
			
	@RequestMapping("/info/openRecDetail")
	//요기서 요청이 오면
	public ModelAndView openRecDetail(@RequestParam int recNum) throws Exception{
		//요청 파라미터는 글번호
		ModelAndView mv = new ModelAndView("/info/recruitDetail");
		//보드 디테일로 결과를 전송할거다
		
		InfoDto board = infoService.selectRecDetail(recNum);
		//글번호 파라미터로 받는 서비스 메소드 실행해서 결과를 DTO에 담을거다
		mv.addObject("board", board);
		//결과를 모델엔뷰에 담는다
		
		return mv;
		//그 모델앤뷰를 반환해서 아까 저 주소로 보낸다.
	}
			
	@RequestMapping("/info/updateRec")
	public String updateRec(InfoDto board) throws Exception{
		infoService.updateRec(board);
		return "redirect:/info/openRecList";
	}
			
	@RequestMapping("/info/deleteRec")
	public String deleteRec(int recNum) throws Exception{
		infoService.deleteRec(recNum);
		return "redirect:/info/openRecList";
	}
	
	

}