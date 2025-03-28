package miniproject;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class list_controller {
	@Resource(name = "index_DAO")
	index_DAO index_DAO;
	
	@Resource(name = "list_DAO")
	list_DAO list_DAO; 
	
	@Resource(name = "weekinfo_DTO")
	weekinfo_DTO weekinfo_DTO;
	
	
	List<copyright_DTO> cpList = null;
	
	@GetMapping("/week_tails")
	public String week_tails(@RequestParam int aidx, HttpServletRequest req, Model m) {
		this.cpList = this.index_DAO.copyright_select(); //카피라이트
	    m.addAttribute("cpList", cpList);  // copyright.jsp에서 사용
	   
	    weekinfo_DTO one = this.list_DAO.one_week(aidx);
	    m.addAttribute("info",one);
	    //로그인 상태일 경우 예약 정보도 같이 전달
	    HttpSession session = req.getSession(false);
	    if(session != null) {
	    	join_DTO dto = (join_DTO)session.getAttribute("dto");
	    	if(dto != null) {
	    		pre_visit_DTO vinfo = this.list_DAO.visit_select(one.getApart_nm(), dto.getMem_nm(), dto.getTel());
	    		m.addAttribute("vinfo", vinfo); //jsp체크용
	    		System.out.println("예약 여부 정보 : "+ vinfo);
	    	}
	    }
	    
	    
	    return "week_tails";
	}
	
	@GetMapping("/reservation")
	public String reservation(@RequestParam int aidx, HttpServletRequest req, Model m) {
		this.cpList = this.index_DAO.copyright_select(); //카피라이트
	    m.addAttribute("cpList", cpList); 
	    
	    String sessionck = m_session.check(req, m);
	    if(sessionck != null) {
	    	return sessionck;
	    }
	    
	    
	    //로그인 유지된 상태 -> 예약 정보 조회
	    weekinfo_DTO one = this.list_DAO.one_week(aidx);
	    m.addAttribute("info",one); 
	    
		return "reservation";
	}
	
	@PostMapping("/visitok.do")
	public String visitok(pre_visit_DTO dto, Model m) {
		int result = this.list_DAO.visit_insert(dto);
		String msg = "";
		if(result > 0) {
			msg = "alert('방문예약이 완료 되었습니다.'); "
					+ "location.href='./reservation_check?vapart=" + dto.getVapart()+ "';";
			System.out.println("db에 정상적으로 저장이 완료되었습니다.");
		}else {
			msg = "alert('시스템 오류로 예약이 실패되었습니다. 다시 시도하여 주세요'); "
					+ "history.go(-1);";
			System.out.println("db 저장 실패!");
		}
		m.addAttribute("msg",msg);
		return "load";
	}
	
	@GetMapping("/reservation_check")
	public String reservation_check(@RequestParam String vapart,HttpServletRequest req,Model m) {
		this.cpList = this.index_DAO.copyright_select(); //카피라이트
	    m.addAttribute("cpList", cpList);
		//세션 체크
	    String sessionck = m_session.check(req, m);
	    if(sessionck != null) return sessionck;
	    
	    //유저 정보 추출
	    HttpSession session = req.getSession();
	    join_DTO dto = (join_DTO) session.getAttribute("dto");
	    
	    //DB에서 예약 정보 조회
	    pre_visit_DTO vinfo = this.list_DAO.visit_select(vapart, dto.getMem_nm(), dto.getTel());
	    
	    if(vinfo != null) {
	    	m.addAttribute("vinfo",vinfo);
	    }
	    System.out.println("예약 정보 확인: " + vinfo);
	    return "reservation_check";
	}
	
	
	
}
