package miniproject;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository("list_DAO")
public class list_DAO {
	
	
	@Resource(name = "template")
	public SqlSessionTemplate st;
	
	public weekinfo_DTO one_week(int aidx){
		return this.st.selectOne("miniproject.index_mapper.weektail_one", aidx);
	}
	
	
}
