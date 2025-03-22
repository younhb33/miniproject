package miniproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.mysql.cj.xdevapi.Result;

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


	
}
