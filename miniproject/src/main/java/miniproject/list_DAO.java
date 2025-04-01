package miniproject;

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
	public pre_visit_DTO visit_select (String vapart, String vname, String vtel) {
		Map<String, String> data = new HashMap<String, String>();
		data.put("vapart", vapart);
		data.put("vname", vname);
		data.put("vtel", vtel);
		pre_visit_DTO dto = this.st.selectOne("visit_select", data);
		return dto;
	}
	@Override
	public int list_new(list_DTO dto) {
		int result = this.st.insert("list_new", dto);
		return result;
	}
	Integer page_ea = 10; //한 페이지당 10개씩 출력
	
	
	//전체 데이터 + Pageing추가
	//Integer pgno - 클릭한 페이지 번호 받는 변수
	@Override
	public List<list_DTO> list_select(Integer pgno){	
		 int spage = (pgno - 1) * this.page_ea;//페이지 번호에 맞는 limit 적용
		
		//limit 사용 >Map형태 구성 > Mapper전달
		Map<String, Integer> data = new HashMap<String, Integer>();
		data.put("spage", spage); //limit첫번째 번호
		data.put("epage", this.page_ea); //두번째
		List<list_DTO> all = this.st.selectList("list_select",data);
		return all;
	}
	
	@Override
	public int list_total() {
		int total = this.st.selectOne("list_total");
		return total;
	}
	
	@Override
	public List<list_DTO> list_search(String search){
		List<list_DTO> all = this.st.selectList("list_search",search);
		return all;
	}
	
	@Override
	public list_DTO view_list(int lidx) {
		list_DTO dto = this.st.selectOne("view_list", lidx);
		return dto;
	}
	
	@Override
	public int update_view(int lidx) {
		int view = this.st.update("update_view", lidx);
		return view;
	}
	
	
	
}
