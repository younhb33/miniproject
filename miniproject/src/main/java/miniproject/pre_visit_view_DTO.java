package miniproject;

import org.springframework.stereotype.Repository;

import lombok.Data;

@Data
@Repository("pre_visit_view_DTO")
public class pre_visit_view_DTO {
	int visit_id;
	String mem_nm,member_tel,apartment_name,visit_date
	,visit_time,people_count;
}
