package miniproject;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

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
			
			if(dto.getMcode() == null || dto.getMcode().isEmpty()) {
				dto.setMcode("1"); // 기본값 1
				dto.setMjoin("WEB"); // 기본값 WEB
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
	            pw.write("no"); //중복
	        } else {
	            pw.write("ok"); //사용
	        }
		} catch (Exception e) {
			pw.write("error!!");
			e.printStackTrace();
		}finally {
			pw.close();
		}
    	     
	}
	
	//로그인
	@RequestMapping("/loginok.do")
	public String loginok(join_DTO dto, Model m, 
			HttpServletRequest req 
			)throws Exception {
		String msg = "";
		HttpSession session = null;
		if(dto.getMcode().equals("1")) {
			//비밀번호 공백처리		
			if(dto.getPw() == null || dto.getPw().isEmpty()) {
				msg = "alert('비밀번호가 비어있습니다.');"
						+ "history.go(-1);";
				m.addAttribute("msg",msg);
				return "load";		
			}
			//비밀번호가 null이 아니면 md5 암호화
			dto.setPw(new m_md5().md5_code(dto.getPw()));
			//로그인 정보 조회
			join_DTO sel_dto = this.dao.login_select(dto);
			if(sel_dto == null) {
				msg = "alert('아이디 또는 패스워드를 다시 확인해주세요');"
						+ "history.go(-1)";
			}else {
				//로그인 성공시 세션에 저장
				session = req.getSession();
				session.setAttribute("dto", sel_dto);
				session.setAttribute("logtime", System.currentTimeMillis());
				
				System.out.println("로그인 성공 - 이름: " + sel_dto.getMem_nm());
				System.out.println("로그인 성공 - 이메일: " + sel_dto.getEmail());
				System.out.println("로그인 성공 - 전화번호: " + sel_dto.getTel());

				msg = "location.href='./index.do';";
			}
		}else if(dto.getMcode().equals("2")) { //카카오 로그인
			
			dto.setEmail(dto.getKakao_id()); //이메일 자리에 kakao_id 사용 (동일하게 저장돼 있으니까)
			dto.setPw(new m_md5().md5_code(dto.getKakao_id())); 
			join_DTO sel_dto = this.dao.login_select(dto);
			 if(sel_dto == null) { //로그인 실패시
				msg = "alert('카카오 사용자로 로그인시 간편회원가입이 필요합니다.');"
						+ "sessionStorage.setItem('email','"+ dto.getKakao_id() +"');"
						+ "location.href='./member_join.do';";
				}else { //로그인 성공시
					session = req.getSession();
					session.setAttribute("dto", sel_dto);
					msg = "alert('로그인 하셨습니다.'); location.href='./index.do';";
				}
			 m.addAttribute("msg", msg);
		}else {
			msg = "alert('잘못된 접근입니다.');" + "history.go(-1);";
		}
		
		return "load";
	}
	
	//이메일 아이디 찾기
	@PostMapping("/msearch_ok.do")
	public String msearch_ok(join_DTO dto, Model m) throws Exception{
		join_DTO data = this.dao.m_search_select(dto.mem_nm, dto.tel);
		
		//하단 copyright정보
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
		//하단 copyright 정보
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
		System.out.println("🔐 [디버깅] 사용자 입력 평문 비밀번호: " + pw); //암호화
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
	
	//상담신청 페이지 진입 핸들링(세션/로그인상태)확인 포함
		@GetMapping("/counsel.do")
		public String counsel(@SessionAttribute(name = "dto", required = false)join_DTO dto, HttpSession ss, Model m) {
			//카피라이트 세팅
			List<copyright_DTO> cpList = this.index_DAO.copyright_select();
		    m.addAttribute("cpList", cpList);  // copyright.jsp에서 사용
		    if(dto == null) {
		    	m.addAttribute("msg", "alert('로그인 후에 이용 가능합니다.'); location.href='index.do';");
		    	return "load";
		    }

		    // 로그인 상태면 상담신청 페이지로 이동
		    return "counsel";
		}
	
	//상담신청 완료 처리(DB저장 + 이메일 전송)
	@PostMapping("/counselok.do")
	public String counselok(@ModelAttribute meeting_DTO dto,
							@SessionAttribute(name = "dto", required = false)join_DTO join_DTO,
	                        @RequestParam(name = "rent_type") ArrayList<String> rentTypes,
	                        @RequestParam(name = "house_type") ArrayList<String> houseTypes,
	                        Model m ) {

	    String msg = "";
	    
	    try {
	    	//세션 기반 회원번호 설정
	    	dto.setMaidx(join_DTO.getAidx());
	    	//다중 선택값은 문자열로 변환하여 저장
	    	dto.setRent_type(String.join(",", rentTypes));
	    	dto.setHouse_type(String.join(",", houseTypes));
	    	
	    	int result = this.dao.meet_in(dto);
	    	System.out.println("DB 저장 결과: " + result);
	    	
	        // 이메일 전송 시도
	        m_MailSender.sendMail(dto.getMemail(), dto.getMname(), dto.getMcontent());
	        msg = "alert('담당자가 확인 후 해당 상담일시에 맞춰서 연락 드립니다.'); "
	        		+ "location.href='./index.do';";

	    } catch (Exception e) {
	        e.printStackTrace();
	        msg = "alert('이메일 발송 중 오류가 발생했습니다. 잠시 후 다시 시도해주세요.'); "
	        		+ "history.go(-1);";
	    }
	    m.addAttribute("msg", msg);
	    return "load";
	}

	
	
}
