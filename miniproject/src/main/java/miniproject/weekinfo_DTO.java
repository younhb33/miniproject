package miniproject;

import org.springframework.stereotype.Repository;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Repository("weekinfo_DTO")
public class weekinfo_DTO {
	int aidx, house_mem, build;
	String apart_nm,addr,type,rent_type,sale_date,
	in_date,img,heat_type,comp_nm,situ,data_date;
	
}
