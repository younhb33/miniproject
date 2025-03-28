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
	
	
	
	
}
