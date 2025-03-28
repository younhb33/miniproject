package miniproject;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface list_mapper {
	
	int visit_insert(pre_visit_DTO dto);
	
	pre_visit_DTO visit_select(String vapart, String vname, String vtel);
}
