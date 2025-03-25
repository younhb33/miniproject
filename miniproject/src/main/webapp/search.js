var t_regp = /^01\d{8,9}/g; //휴대번호
function mail_search(){
	if (frm.mem_nm.value == "") {
		alert("이름을 입력하세요");
		return false;
	}else if (frm.tel.value == "") {
		alert("휴대폰번호를 입력하세요");
		return false;
	} else if (!t_regp.test(frm.tel.value)) {
		alert("휴대폰 번호는 - 빼고 숫자만 입력하세요");
		return false;
	}else{
		frm.submit();		
	}
}


function pw_search(){
	if (frm.email.value == "") {
		alert("이메일을 입력하세요");
		return false;
	}else if (frm.tel.value == "") {
		alert("휴대폰번호를 입력하세요");
		return false;
	} else if (!t_regp.test(frm.tel.value)) {
		alert("휴대폰 번호는 - 빼고 숫자만 입력하세요");
		return false;
	}else {
		frm.submit();
	}
}