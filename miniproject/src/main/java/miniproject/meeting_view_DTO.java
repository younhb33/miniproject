package miniproject;

import org.springframework.stereotype.Repository;

import lombok.Data;

@Data
@Repository("meeting_view_DTO")
public class meeting_view_DTO {
	int meeting_id,member_id;
	String member_name,member_email,member_tel,rent_type
	,house_type,meeting_date,mcontent,add_date;
}
