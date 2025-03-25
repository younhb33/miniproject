var m_regp = /^[a-z0-9.-_]+@[a-z0-9ㄱ-힇]+\.[a-z0-9ㄱ-힇]{2,}/i;
function logincheck(){
	
	if(frm.email.value == ""){
		alert("이메일을 입력해주세요");
		return false;
	}else if(!m_regp.test(frm.email.value)){
		alert("이메일 형식이 올바르지 않습니다 \n다시 입력해주세요");
	}else if(frm.pw.value ==""){
		alert("비밀번호를 입력해주세요");
		return false;
	}else{
		frm.submit();
	}
	
}