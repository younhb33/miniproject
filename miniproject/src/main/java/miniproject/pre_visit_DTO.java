package miniproject;

import org.springframework.stereotype.Repository;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Repository("pre_visit_DTO")
public class pre_visit_DTO {
	int vidx,waidx,maidx;
	String vapart,vdate,vtime,vname,vcount,vtel,add_date;
}
