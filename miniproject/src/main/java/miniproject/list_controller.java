package miniproject;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class list_controller {
	@Resource(name = "index_DAO")
	index_DAO index_DAO;
	
	@Resource(name = "list_DAO")
	list_DAO list_DAO; 
	
	@Resource(name = "weekinfo_DTO")
	weekinfo_DTO weekinfo_DTO;
	
	@Resource(name = "mdchoice_DTO")
	mdchoice_DTO mdchoice_DTO; 
	
	@Resource(name = "m_file_rename") //파일명 변경
	m_file_rename fname;
	
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
	    		pre_visit_view_DTO  vinfo = this.list_DAO.visit_select(one.getApart_nm(), dto.getMem_nm(), dto.getTel());
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
	public String visitok(@ModelAttribute pre_visit_DTO dto, 
			@SessionAttribute(name = "dto", required = false) join_DTO join_DTO,
			Model m) {
		//waidx = info.aidx(아파트일련번호) / maidx = 현재 로그인한 회원의 aidx
		dto.setWaidx(dto.getWaidx()); //전달받았는지 확인
		dto.setMaidx(join_DTO.getAidx());
		
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
	    pre_visit_view_DTO vinfo = this.list_DAO.visit_select(vapart, dto.getMem_nm(), dto.getTel());
	    
	    if(vinfo != null) {
	    	m.addAttribute("vinfo",vinfo);
	    }
	    System.out.println("예약 정보 확인: " + vinfo);
	    return "reservation_check";
	}
	
	
	@GetMapping("/md_board")
	public String md_board(Model m,
			@RequestParam(name = "search", defaultValue = "", required = false)String search,
			@RequestParam(defaultValue = "1", required = false)Integer pageno
			){
		this.cpList = this.index_DAO.copyright_select(); //카피라이트
	    m.addAttribute("cpList", cpList);
		
	    //데이터 총 개수 확인 코드
	    int total = this.list_DAO.list_total();
	    //System.out.println(total);
	    int userpage = 0;//사용자가 클릭한 페이지
	    if(pageno == 1) {
	    	userpage = 0;
	    }else {
	    	userpage = (pageno - 1) * 10;
	    }
	    //해당 일련번호 계산하여 jsp에 전달
	    m.addAttribute("userpage", userpage);
	    
	    List<mdchoice_DTO> all = null;
	    if(search.intern()=="") { //검색어가 없을 경우
	    	all = this.list_DAO.list_select(pageno); //페이지 번호 클릭한 값
	    }else {
	    	all = this.list_DAO.list_search(search);
	    }
	    m.addAttribute("total",total); //데이터 전체 개수
	    m.addAttribute("search",search); //검색어 jsp로 전달
	    m.addAttribute("all", all);
		return null;
	}
	
	@GetMapping("/md_board_view")
	public String md_board_view(@RequestParam int aidx, Model m) {
		this.cpList = this.index_DAO.copyright_select(); //카피라이트
	    m.addAttribute("cpList", cpList);
		//조회수 증가
		int view = this.list_DAO.update_view(aidx); //조회수 증가 먼저
		System.out.println("글 목록 조회 전 조회수 확인 : " + this.list_DAO.view_list(aidx).getLview());
		//상세 게시물 정보 조회
		mdchoice_DTO dto = this.list_DAO.view_list(aidx); //게시물 상세정보
		System.out.println("조회수 업데이트 결과 : " + view); //1 성공, 0 실패
		m.addAttribute("dto", dto); //jsp전달
		return "md_board_view";
	}
	
	@GetMapping("/md_board_write")
	public String md_board_write(Model m) {
		this.cpList = this.index_DAO.copyright_select(); //카피라이트
	    m.addAttribute("cpList", cpList);
		return null;
	}
	
	int callback = 0;
	
	//게시물 전체 데이터
	@PostMapping("/md_boardok")
	public String md_boardok(@ModelAttribute(name = "dto")mdchoice_DTO dto,
			MultipartFile lfile, HttpServletRequest req,
			Model m ) {
		
		String file_new = null;
		String msg = "";

		String filenm = lfile.getOriginalFilename();
		String fileExt = filenm.substring(filenm.lastIndexOf(".")+1).toLowerCase();
		if(!fileExt.matches("jpg|jpeg|png|gif")) {
			msg = "alert('이미지 파일(jpg, png, gif)만 업로드 가능합니다.');"
					+ "history.go(-1);";
			m.addAttribute("msg", msg);
			return "load";
		}
		
		//파일용량체크
		if(lfile.getSize() > (2 * 1024 * 1024)) {
			msg = "alert('이미지 용량은 2MB 이하로 업로드해주세요');"
					+ "history.go(-1);";
			m.addAttribute("msg", msg);
			return "load";
		}
		try {
			if(lfile.getSize() > 0) { //용량체크
				file_new = this.fname.rename(lfile.getOriginalFilename()); //file_name.java로 값 보냄
				//웹 디렉토리 > 내가 생성한 파일명으로 저장
				//저장될 경로 -  C:\younhb33\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\miniproject\
				String url = req.getServletContext().getRealPath("/upload/");
				//System.out.println(url);
				FileCopyUtils.copy(lfile.getBytes(), new File(url + file_new));//새로운 파일명으로 저장
				
				dto.setFile_url("/upload/" + file_new); //웹 디렉토리 경로 및 파일명
				dto.setFile_new(file_new); //모델에 저장한 방식으로 파일명 변경값
				dto.setImg(lfile.getOriginalFilename());//사용자가 적용한 파일명
				
				int result = this.list_DAO.list_new(dto);//파일 저장
				
				msg = "alert('추천분양 정보 게시판 게시물이 추가 되었습니다.');"
						+ "location.href='md_board';";
			}else {
				msg = "alert('게시물 추가 안됨 - 문제발생');"
						+ "history.go(-1);";
			}
			
		} catch (Exception e) {
			msg = "alert('게시물 추가 안됨 - 문제발생');"
					+ "history.go(-1);";
			e.printStackTrace();
		}
		m.addAttribute("msg", msg);
		return "load";
	}
	
	@GetMapping("/reservation_list")
	public String reservation_list(@SessionAttribute(name = "dto", required = false)join_DTO loginDTO,
	Model m) {
		this.cpList = this.index_DAO.copyright_select(); //카피라이트
	    m.addAttribute("cpList", cpList);
	    
	    
	    
	    if(loginDTO == null) {
	    	m.addAttribute("msg", "alert('로그인 후 이용 가능합니다.'); location.href='index.do';");
	    	return "load";
	    }
	    int midx = loginDTO.getAidx();
	    List<pre_visit_view_DTO> rsvlist = this.list_DAO.rsvlist_select(midx);
	    m.addAttribute("rsvlist", rsvlist);
	    
		return "reservation_list";
	}
	@PostMapping("/rsvlist_del")
	public String rsvlist_del(@RequestParam int visit_id, Model m) {
		int result = this.list_DAO.visit_delete(visit_id);
		String msg = "";
		
		if(result > 0) {
			msg = "alert('예약이 정상적으로 취소되었습니다.'); location.href='reservation_list';";
		}else {
			msg = "alert('예약 취소 실패. 다시 시도해 주세요.'); history.go(-1);";
		}
		m.addAttribute("msg", msg);
		return "load";
		
	}
	
	
	
}
