package miniproject;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface join_mapper {
	public int join_insert(join_DTO dto);
	
	public int check_email(String email);
	
	join_DTO login_select(join_DTO dto);
	
	//String m_search_select(join_DTO dto);
	
	public String pw_update(String pw, String email);
	
}
