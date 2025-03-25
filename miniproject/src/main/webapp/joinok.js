    var regp = /^[a-z0-9.-_]+@[a-z0-9ㄱ-힣]+\.[a-z0-9ㄱ-힣]{2,}/i;
    var pwrule = /^(?=.*[a-zA-Z])(?=.*\d)(?=.*[!@#$%^&*()\-_=+]).{10,16}$/;
	var tel_regp = /^01\d{8,9}$/;
	
	
	
function check_email(){
	var em = document.getElementById("email");
	// 이메일 형식 검사
	if (!regp.test(em.value)) {
		alert("올바른 이메일 형식을 입력해주세요");
		return false;
	} else {

		this.em_ajax(em.value);
	}
}
	
	
//ajax활용 이메일 중복체크
function em_ajax(email) {
	var http = new XMLHttpRequest();
	http.onreadystatechange = function() {
		if (http.readyState == 4 && http.status == 200) {
	var result = http.responseText;
			console.log("서버 응답값: " + this.response);
			if (result == "ok") {
				alert("사용 가능한 이메일입니다.");
				document.getElementById("emailck").value = "Y"; //중복체크 완료 표시
				document.getElementById("email").readOnly = true; //이메일 수정 못하게 막기
				return true;
			} else if (result == "no") {
				alert("이미 사용 중인 이메일입니다.");
				document.getElementById("emailck").value = "N";  // 초기화
				return false;
			} else {
				alert("오류 발생!");
				return false;
			}
		} else if (http.status == 404) {
			console.log("경로 오류 발생!!");

		} else if (http.status == 405) {
			console.log("통신규격 오류 발생!!");
		} 
	}
	http.open("GET", "/ck_mail.do?email=" + email, false); // GET 방식으로 수정
	http.send(); // GET이니까 send에 파라미터 안 넣어도 됨
}







//이용약관 txt집어넣기
window.onload = function() {
	var http = new XMLHttpRequest;
	http.open("GET","./agree1.txt",false); //GET 통신을 이용하여 해당 파일을 로드
	http.send();
	document.getElementById("ag1").innerHTML = http.response;
	
	
	var http2 = new XMLHttpRequest;
	http2.open("GET","./agree2.txt",false);
	http2.send();
	document.getElementById("ag2").innerHTML = http2.response;
}

function joinok() {
	
	
    if (f.email.value == "") {
        alert("사용하실 이메일 주소를 입력해주세요");
        return false;
    } else if (f.pw.value == "") {
        alert("사용하실 비밀번호를 입력해주세요");
        return false;
    } else if (f.pw_ok.value == "") {
        alert("비밀번호 확인란을 입력해주세요");
        return false;
    } else if (f.pw.value != f.pw_ok.value) {
        alert("비밀번호가 일치하지 않습니다");
        return false;
    } else if (f.mem_nm.value == "") {
        alert("성함을 입력해주세요");
        return false;
    } else if (f.tel.value == "") {
        alert("휴대번호를 입력해주세요");
        return false;
	} else if(isNaN(f.tel.value)){
		alert("숫자만 입력해주세요");
        return false;
	}
	else {


		// 비밀번호 규칙 검사
		if (!pwrule.test(f.pw.value)) {
			alert("비밀번호는 영문, 숫자, 특수문자를 조합하여 10~16자로 입력해주세요.");
			return false;
		}

		// 약관 필수 동의 체크
		var agree14 = document.getElementById("ok_14").checked;
		var agreeTerms = document.getElementById("serviceok").checked;
		var agreePrivacy = document.getElementById("infook").checked;

		if (!agree14 || !agreeTerms || !agreePrivacy) {
			alert("모든 필수 항목을 동의해야 회원가입이 가능합니다.");
			return false;
		}
		f.submit(); // 모든 조건 만족 시 폼 전송

	}

}

            

// -- [전체 동의 체크 시 개별 체크박스 모두 제어] --
function all_check(z) {
	var ob = document.querySelectorAll("input[name^='agree_']");
	var ea = ob.length;
	var w = 0;
	do {
		ob[w].checked = z;
		w++;
	} while (w < ea);
}

// -- [개별 체크 상태 변화 시 전체 선택 체크박스 상태도 갱신] --
function ag_check() {
	var ob = document.querySelectorAll("input[name^='agree_']");
	var ea = ob.length;
	var count = 0;
	for (var i = 0; i < ea; i++) {
		if (ob[i].checked) {
			count++;
		}
	}
	document.getElementById("allselect").checked = (count == ea);
}