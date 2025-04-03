package miniproject;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface list_mapper {
	
	int visit_insert(pre_visit_DTO dto);
	
	pre_visit_view_DTO visit_select(String apart, String name, String tel);
	
	int list_new(mdchoice_DTO dto);
	
	List<mdchoice_DTO> list_select(Integer pgno);
	
	List<mdchoice_DTO> list_search(String search);
	
	int list_total();
	
	mdchoice_DTO view_list(int aidx);
	
	int update_view(int aidx);
	
	List<pre_visit_view_DTO> rsvlist_select(int midx);
	
	int visit_delete(int visit_id);
}
