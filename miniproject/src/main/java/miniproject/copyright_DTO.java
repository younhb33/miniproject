package miniproject;
import org.springframework.stereotype.Repository;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Repository("copyright_DTO")
public class copyright_DTO {
	int aidx;
	String comp_nm,ceo,addr,bus_no,e_no,info_sec,sale_cont,fax;
}
