package miniproject;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository("join_DAO")
public class join_DAO  {
	
	@Resource(name = "template")
	private SqlSessionTemplate st;
	//회원가입
	public int join_insert(join_DTO dto) {
		int result = this.st.insert("join_insert", dto);
		return result;
		
	}

	// 이메일 중복체크
	public int check_email(String email) {
		int result = this.st.selectOne("check_email", email);
		return result;
	}
	
	//로그인
	join_DTO login_select(join_DTO dto) {
		join_DTO result = this.st.selectOne("login_select",dto);
		return result;
	}

	//이메일아이디 찾기
	public join_DTO m_search_select(String name, String tel) {
		Map<String, String> code = new HashMap<String, String>();
		code.put("mem_nm", name);
	    code.put("tel", tel);
		join_DTO result = this.st.selectOne("miniproject.join_mapper.m_search_select", code);
		System.out.println("검색결과 : "+ result);
		return result;
	}
	
	//비밀번호 찾기 (이메일 + 전화번호 일치 여부)
	public join_DTO pw_select(String email, String tel) {
		Map<String, String> data = new HashMap<String, String>();
		data.put("email", email);
		data.put("tel", tel);
		join_DTO result = this.st.selectOne("miniproject.join_mapper.pw_select",data);
		System.out.println("검색결과 : " + result);
		return result;
	}
	
	
	//비밀번호 변경
	public int pw_update(String pw, String email) {
		Map<String, String> data = new HashMap<String, String>();
		data.put("pw", pw);
		data.put("email", email);
		
		int result = this.st.update("pw_update",data);
		return result;
	}
	//상담 신청insert
	public int meet_in(meeting_DTO dto) {
		int result = this.st.insert("miniproject.join_mapper.meet_in",dto);
		return result;
	}
}
