package miniproject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository("list_DAO")
public class list_DAO implements list_mapper {
	
	
	@Resource(name = "template")
	public SqlSessionTemplate st;
	
	public weekinfo_DTO one_week(int aidx){
		return this.st.selectOne("miniproject.index_mapper.weektail_one", aidx);
	}
	@Override
	public int visit_insert(pre_visit_DTO dto) {
		int result  = this.st.insert("visit_insert", dto);
		return result;
	}
	
	@Override
	public pre_visit_view_DTO visit_select (String apart, String name, String tel) {
		Map<String, String> data = new HashMap<String, String>();
		data.put("apart", apart);
		data.put("name", name);
		data.put("tel", tel);
		pre_visit_view_DTO dto = this.st.selectOne("visit_select", data);
		return dto;
	}
	@Override
	public int list_new(mdchoice_DTO dto) {
		int result = this.st.insert("list_new", dto);
		return result;
	}
	Integer page_ea = 10; //한 페이지당 10개씩 출력
	
	
	//전체 데이터 + Pageing추가
	//Integer pgno - 클릭한 페이지 번호 받는 변수
	@Override
	public List<mdchoice_DTO> list_select(Integer pgno){	
		 int spage = (pgno - 1) * this.page_ea;//페이지 번호에 맞는 limit 적용
		
		//limit 사용 >Map형태 구성 > Mapper전달
		Map<String, Integer> data = new HashMap<String, Integer>();
		data.put("spage", spage); //limit첫번째 번호
		data.put("epage", this.page_ea); //두번째
		List<mdchoice_DTO> all = this.st.selectList("list_select",data);
		System.out.println("첫번째 게시물 조회수 : " + all.get(0).getLview());
		return all;
	}
	
	@Override
	public int list_total() {
		int total = this.st.selectOne("list_total");
		return total;
	}
	
	@Override
	public List<mdchoice_DTO> list_search(String search){
		List<mdchoice_DTO> all = this.st.selectList("list_search",search);
		return all;
	}
	
	@Override
	public mdchoice_DTO view_list(int aidx) {
		mdchoice_DTO dto = this.st.selectOne("view_list", aidx);
		return dto;
	}
	
	@Override
	public int update_view(int aidx) {
		int view = this.st.update("update_view", aidx);
		return view;
	}
	
	@Override
	public List<pre_visit_view_DTO> rsvlist_select(int midx){
		return this.st.selectList("rsvlist_select",midx);
		
	}
	@Override
	public int visit_delete(int visit_id) {
		return this.st.delete("visit_delete", visit_id);
	}
	
	
}
