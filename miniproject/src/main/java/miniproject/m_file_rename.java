package miniproject;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Repository;

@Repository("m_file_rename")
public class m_file_rename {
	
	public String rename(String filenm) {
		
		int com = filenm.lastIndexOf(".");
		String fnm = filenm.substring(com);
		System.out.println(fnm);
		
		//날짜 
		Date day = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
		String today = sf.format(day); //년월일
		
		//랜덤값
		int no = (int)Math.ceil(Math.random()*1000);
		String makefile = today + no + fnm; //파일명ex) 2025032715
		
		
		
		
		return makefile;
	}
}
