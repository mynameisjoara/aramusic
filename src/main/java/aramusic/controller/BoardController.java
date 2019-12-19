package aramusic.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	@RequestMapping("/FreeboardList")
	public ModelAndView FreeboardList() throws Exception{
		ModelAndView mv = new ModelAndView("/FreeboardList");
		
		List<FreeboardDto> list = freeboardService.selectBoardList();
		
		System.out.println("제목??"+list.get(0).getTitle());
		mv.addObject("list", list);
		
		return mv;
		}
	
	
	
	
	
}
