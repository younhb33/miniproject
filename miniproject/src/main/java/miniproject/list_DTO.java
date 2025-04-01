package miniproject;

import org.springframework.stereotype.Repository;

import lombok.Data;

@Data
@Repository("list_DTO")
public class list_DTO {
	int lidx;
	String lsubject,lname,lview,lcontext,ldate;
}
