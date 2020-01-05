package aramusic.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import aramusic.dto.FreeboardDto;
import aramusic.service.FreeboardService;

@Controller
public class BoardController {
	
	@Autowired
	private FreeboardService freeboardService;
	
	
    @RequestMapping("/main")
    public String main() {
        return "/main";
    }	
    
    @RequestMapping("/")
    public String main2() {
        return "/main";
    }	    
	
	@RequestMapping("/FreeboardList")	//게시판 글목록
	public ModelAndView FreeboardList() throws Exception{
		ModelAndView mv = new ModelAndView("/FreeboardList");
		
		List<FreeboardDto> list = freeboardService.selectBoardList();
		mv.addObject("list", list);
		
		return mv;
		}
	
	@RequestMapping("/FreeboardCont")	//게시판 글내용조회
	public ModelAndView FreeboardCont(@RequestParam("idx") int idx) throws Exception{
		ModelAndView mv = new ModelAndView("/FreeboardCont");
		
        freeboardService.updateFreeBoardHit(idx);    //조회수증가
        FreeboardDto dto = freeboardService.selectFreeBoardCont(idx);    //글내용가져오기
		mv.addObject("dto", dto);
		
		return mv;
		}
	
	@RequestMapping("/FreeboardWrite")	//게시판 글작성 폼 입성
	public ModelAndView FreeboardWrite() throws Exception{
		ModelAndView mv = new ModelAndView("/FreeboardWrite");
		return mv;
		}	
	
	@RequestMapping("/FreeboardWriteOk")	//게시판 글작성 완료
	public String FreeboardWriteOk(FreeboardDto dto) throws Exception{
		//작성내용 db저장 로직 구현하기 
		freeboardService.insertBoard(dto);
        return "redirect:/FreeboardList";
		}		
	
}
