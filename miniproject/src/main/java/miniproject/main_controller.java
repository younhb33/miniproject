package miniproject;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class main_controller {
	
	
	@Resource(name="index_DAO")
	public index_DAO index_DAO;
	
	
	@GetMapping("/index.do")
	public String index(Model m) {
	    List<weekinfo_DTO> infoList = this.index_DAO.weekinfo_select();
	    List<mdchoice_DTO> mdList = this.index_DAO.mdchoice_select();
	    List<copyright_DTO> cpList = this.index_DAO.copyright_select();
	    
	    
	    m.addAttribute("weekList", infoList);
	    m.addAttribute("mdList", mdList);
	    m.addAttribute("cpList", cpList);
	    
	    return "index"; // index.jsp
	}
	
	@GetMapping("/login.do")
	public String login(Model m) {
	    List<copyright_DTO> cpList = this.index_DAO.copyright_select();
	    m.addAttribute("cpList", cpList); // copyright.jsp에서 사용하는 변수명 그대로
	    
	    return "login"; // login.jsp
	}
	
	
	@GetMapping("/member_join.do")
	public String join(Model m) {
		List<copyright_DTO> cpList = this.index_DAO.copyright_select();
	    m.addAttribute("cpList", cpList); // copyright.jsp에서 사용하는 변수명 그대로
	    
	    return "member_join"; // member_join.jsp
	}
	
	
	@GetMapping("/email_search.do")
	public String search(Model m) {
	    List<copyright_DTO> cpList = this.index_DAO.copyright_select();
	    m.addAttribute("cpList", cpList); // copyright.jsp에서 사용하는 변수명 그대로
	    
	    return "email_search"; // email_search.jsp
	}
	@GetMapping("search_myinfo.do")
	public String search_myinfo(Model m) {
	    List<copyright_DTO> cpList = this.index_DAO.copyright_select();
	    m.addAttribute("cpList", cpList); // copyright.jsp에서 사용하는 변수명 그대로
	    
	    return "/WEB-INF/info/search_myinfo"; // search_myinfo.jsp
	}
	
	@GetMapping("/passwd_search.do")
	public String passwd_search(Model m) {
	    List<copyright_DTO> cpList = this.index_DAO.copyright_select();
	    m.addAttribute("cpList", cpList); // copyright.jsp에서 사용하는 변수명 그대로
	    
	    return "passwd_search"; 
	}
	/*
	@GetMapping("/search_mypass.do")
	public String search_mypass(Model m) {
	    List<copyright_DTO> cpList = this.index_DAO.copyright_select();
	    m.addAttribute("cpList", cpList); // copyright.jsp에서 사용하는 변수명 그대로
	    
	    return "search_mypass"; // email_search.jsp
	}
	*/
	/*
	@GetMapping("/counsel.do")
	public String counsel(Model m) {
		List<copyright_DTO> cpList = this.index_DAO.copyright_select();
	    m.addAttribute("cpList", cpList); // copyright.jsp에서 사용하는 변수명 그대로
	    
	    return "counsel";
	}
	*/
}
