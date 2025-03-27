package miniproject;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class list_controller {
	@Resource(name = "index_DAO")
	index_DAO index_DAO;
	
	@Resource(name = "list_DAO")
	list_DAO list_DAO; 
	
	@Resource(name = "weekinfo_DTO")
	weekinfo_DTO weekinfo_DTO;
	
	
	
	@GetMapping("/week_tails")
	public String week_tails(@RequestParam int aidx, Model m) {
		List<copyright_DTO> cpList = this.index_DAO.copyright_select(); //카피라이트
	    m.addAttribute("cpList", cpList);  // copyright.jsp에서 사용
	   
	    weekinfo_DTO one = this.list_DAO.one_week(aidx);
	    m.addAttribute("info",one);
	    
	    
	    return "week_tails";
	}
	
	
	
}
