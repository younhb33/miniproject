package miniproject;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface list_mapper {
	
	int visit_insert(pre_visit_DTO dto);
	
	pre_visit_DTO visit_select(String vapart, String vname, String vtel);
	
	int list_new(list_DTO dto);
	
	List<list_DTO> list_select(Integer pgno);
	
	List<list_DTO> list_search(String search);
	
	int list_total();
	
	list_DTO view_list(int lidx);
	
	int update_view(int lidx);
}
