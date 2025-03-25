package miniproject;

import org.springframework.stereotype.Repository;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Repository("join_DTO")
public class join_DTO {
	int aidx;
	String email,pw,mem_nm,tel,agree_all,agree_14,agree_terms,agree_privacy,agree_marketing,join_date;
}
