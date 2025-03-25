package miniproject;

import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class join_controller  {
	
	@Resource(name = "join_DAO")
	public join_DAO dao;
	
	@Resource(name = "index_DAO")
	private index_DAO index_DAO;
	
	@Resource(name = "join_DTO")
	public join_DTO dto;
	

	@PostMapping("/join_ok.do")
	public String join_ok(join_DTO dto, Model m) throws Exception {
			String msg = "";
			
			//암호화 하기
			String m_pw = dto.getPw();  // 평문 비밀번호
			// 2. 암호화 클래스 호출
			m_md5 md5 = new m_md5(); // md5 암호화 클래스 객체 생성
			// 3. 암호화 실행
			String md_pw = md5.md5_code(m_pw); // 암호화된 비밀번호 얻기
			// 4. DTO에 암호화된 비밀번호 저장
			dto.setPw(md_pw);
			
			// 마케팅 동의가 null이면 "N"으로 설정하기
			if(dto.getAgree_marketing()== null) {
				dto.setAgree_marketing("N");
			}

			int result = this.dao.join_insert(dto);
			
			if(result > 0) {
				msg = "alert('회원가입이 정상적으로 완료되었습니다.');"
						+ "location.href='./login.do';";	
			}m.addAttribute("msg", msg);
			System.out.println("1. 회원가입 평문 비밀번호 : "+ dto.getPw());
			System.out.println("2. 비밀번호 평문 : " + m_pw);
			System.out.println("3. 비밀번호 암호화 후 : "+ md_pw);
			return "load";
		
	}
	

	// 이메일 중복 체크 처리
	//@PostMapping("/ck_mail.do")
	@GetMapping("/ck_mail.do")
	public void ck_mail(@RequestParam("email") String email, join_DTO dto, HttpServletResponse response) throws Exception {
	    response.setContentType("text/html; charset=UTF-8");
	    PrintWriter pw = response.getWriter();
	        
	    int result = this.dao.check_email(email);
	    try {
	    	if (result > 0) {
	            pw.write("no");
	        } else {
	            pw.write("ok");
	        }
		} catch (Exception e) {
			pw.write("error!!");
			e.printStackTrace();
		}finally {
			pw.close();
		}
    	     
	}
	
	//로그인
	@PostMapping("/loginok.do")
	public String loginok(join_DTO dto, Model m, HttpServletRequest request)throws Exception {
		String msg = "";
				
		if(dto.getPw() == null || dto.getPw().isEmpty()) {
			msg = "alert('비밀번호가 비어있습니다.');"
					+ "history.go(-1);";
			m.addAttribute("msg",msg);
			return "load";		
		}
		//비밀번호가 null이 아니면 md5 암호화
		dto.setPw(new m_md5().md5_code(dto.getPw()));
		join_DTO sel_dto = this.dao.login_select(dto);
		if(sel_dto == null) {
			msg = "alert('아이디 또는 패스워드를 다시 확인해주세요');"
					+ "history.go(-1)";
		}else {
			HttpSession session = request.getSession();
			session.setAttribute("dto", sel_dto);
			
			msg = "location.href='./index.do';";
		}
		
		m.addAttribute("msg", msg);
		return "load";
	}
	
	//이메일 아이디 찾기
	@PostMapping("/msearch_ok.do")
	public String msearch_ok(join_DTO dto, Model m) throws Exception{
		join_DTO data = this.dao.m_search_select(dto.mem_nm, dto.tel);
		List<copyright_DTO> cpList = this.index_DAO.copyright_select();
	    m.addAttribute("cpList", cpList);  // copyright.jsp에서 사용
		
		System.out.println("입력 이름: " + dto.getMem_nm());
		System.out.println("입력 전화번호: " + dto.getTel());
		String msg = "";
		
		if(data == null) {
			msg = "가입하신 정보는 확인 되지 않습니다.";
		}else {
			msg = data.email;
		}
		System.out.println("[[[[[[[[[[이메일 주소]]]]]]]] : "+ data.email);
		m.addAttribute("msg", msg);
		return "/WEB-INF/info/search_myinfo";
	}
	
	//비밀번호 찾기
	@PostMapping("/psearch_ok.do")
	public String psearch_ok(join_DTO dto, Model m) {
		join_DTO result = this.dao.pw_select(dto.email, dto.tel);
		List<copyright_DTO> cpList = this.index_DAO.copyright_select();
	    m.addAttribute("cpList", cpList);  // copyright.jsp에서 사용
		System.out.println("입력 이메일 : "+ dto.getEmail());
		System.out.println("입력 전화번호 : " + dto.getTel());
		String msg = "";
		
		if(result == null) {
			msg = "alert('입력하신 정보와 일치하는 계정이 없습니다.');"
					+ "history.go(-1);";
			m.addAttribute("msg", msg);
			return "load";
		}else {
			
			m.addAttribute("email", result.getEmail());
			
		}
		return "/WEB-INF/info/search_mypass";
	}
	
	
	//비밀번호 변경
	@PostMapping("/update_pw.do")
	public String update_pw(String pw, String email, Model m) throws Exception {
		System.out.println("🔐 [디버깅] 사용자 입력 평문 비밀번호: " + pw);
	    System.out.println("📧 [디버깅] 사용자 이메일: " + email);
		
		//비밀번호 암호화
		m_md5 md5 = new m_md5();
		String enc_pw = md5.md5_code(pw);
		System.out.println("🔒 [디버깅] 암호화된 비밀번호: " + enc_pw);
		
		//DAO호출 /DB업데이트
		int result = this.dao.pw_update(enc_pw, email);
		System.out.println("✅ [디버깅] DB 업데이트 결과: " + result);
		
		String msg="";
		if(result > 0) {
			msg = "alert('비밀번호가 성공적으로 변경되었습니다.');"
					+ "location.href='./login.do';";
		}else {
			msg = "alert('비밀번호 변경에 실패했습니다. 다시 시도해주세요.'); "
					+ "history.go(-1);";
		}
		m.addAttribute("msg", msg);
		return "load";
	}
	
}
