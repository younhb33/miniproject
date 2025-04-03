package miniproject;

import org.springframework.stereotype.Repository;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Repository("mdchoice_DTO")
public class mdchoice_DTO {
	int aidx,lview;
	String mtitle,details,img,img_path,link,lname,file_new,file_url,ldate;
}
