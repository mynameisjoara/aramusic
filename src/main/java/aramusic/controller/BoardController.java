package aramusic.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

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
		freeboardService.insertBoard(dto);
        return "redirect:/FreeboardList";
		}		
	
	@RequestMapping("/FreeboardEdit")	//게시판 글수정 폼 입성
	public ModelAndView FreeboardEdit(@RequestParam("idx") int idx) throws Exception{
		ModelAndView mv = new ModelAndView("/FreeboardEdit");
        FreeboardDto dto = freeboardService.selectFreeBoardCont(idx);	//원래내용 가져와서 띄우기
		mv.addObject("dto", dto);
		return mv;
		}	
	
	@RequestMapping("/FreeboardEditOk")	//게시판 글수정 완료
	public void FreeboardEditOk(FreeboardDto dto, HttpServletResponse response) throws Exception{
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		if(dto.getWritepwd().equals(dto.getCheckpwd())) { //비밀번호 체크
			freeboardService.updateBoard(dto);//수정된 글 저장
			
            out.println("<script>");
            out.println("alert('수정이 완료되었습니다.')");
	        out.println("location.href='FreeboardCont?idx="+dto.getIdx()+"'");
            out.println("</script>");			
		}else {
            out.println("<script>");
            out.println("alert('비밀번호가 틀립니다.')");
            out.println("history.back()");
            out.println("</script>");
		}
		}	
	
	@RequestMapping("/FreeboardDelete")	//글삭제 비밀번호 입력받는 jsp페이지 입성
	public ModelAndView FreeboardDelete(@RequestParam("idx") int idx) throws Exception{
		ModelAndView mv = new ModelAndView("/FreeboardDelete");
        FreeboardDto dto = freeboardService.selectFreeBoardCont(idx);	//비밀번호 비교위해 dto 가져오기
		mv.addObject("dto", dto);
		return mv;
		}
	
	@RequestMapping("/FreeboardDeleteOk")	//게시판 글삭제 완료
	public void FreeboardDeleteOk(FreeboardDto dto, HttpServletResponse response) throws Exception{
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		if(dto.getWritepwd().equals(dto.getCheckpwd())) { //비밀번호 체크
			freeboardService.deleteBoard(dto);//글 삭제
			
            out.println("<script>");
            out.println("alert('삭제가 완료되었습니다.')");
	        out.println("location.href='FreeboardList'");
            out.println("</script>");			
		}else {
            out.println("<script>");
            out.println("alert('비밀번호가 틀립니다.')");
            out.println("history.back()");
            out.println("</script>");
		}
		}	
	
	
	
	
}
