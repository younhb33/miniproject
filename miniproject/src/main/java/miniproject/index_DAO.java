package miniproject;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository("index_DAO")
public class index_DAO  {
	
	@Resource(name = "template")
	private SqlSessionTemplate template;
	
	public List<weekinfo_DTO> weekinfo_select(){
		List<weekinfo_DTO> infoList = this.template.selectList("weekinfo_select");
		
		return infoList;
	}
	
	public List<mdchoice_DTO> mdchoice_select(){
		List<mdchoice_DTO> mdList = this.template.selectList("mdchoice_select");
		
		return mdList;
	}
	
	public List<copyright_DTO> copyright_select(){
		List<copyright_DTO> cpList = this.template.selectList("copyright_select");
		
		return cpList;
	}
	
	
	
}
