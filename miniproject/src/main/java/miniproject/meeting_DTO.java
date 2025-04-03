package miniproject;

import org.springframework.stereotype.Repository;

import lombok.Data;

@Data
@Repository("meeting_DTO")
public class meeting_DTO {
	int midx, maidx;
	String mname,memail,mtel,rent_type,house_type,meeting_date
	,mcontent,add_date;
}
