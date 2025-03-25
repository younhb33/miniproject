<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="cr" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" type="text/css" href="./css/index.css?v=1">
<link rel="stylesheet" type="text/css"
	href="./css/search_myinfo.css?v=2">

	<section class="sub">
		<div>
			<ul>
				<li>회원가입 정보에 따른 패스워드 변경</li>
			</ul>
		</div>
		<div class="text1 repass">
			<div>
				<input type="password" id="pw" name="pw" value=""
					placeholder="최소 10 ~ 16자 (영문,숫자,특수 문자 조합)로 입력해주세요." maxlength="16"
					class="passin" autocomplete="none">
			</div>
			<div>
				<input type="password" id="pw2" name="pw2" placeholder="동일한 비밀번호를 입력하세요"
					maxlength="16" class="passin" autocomplete="none">
			</div>
		</div>
		<div>
			<input type="button" value="비밀번호 변경" class="search_submit"
				onclick="pw_update('${email}')">
		</div>
	</section>
<!-- hidden from 삽입할 위치 -->
<div id="pw_area" style="display: none;"></div>

<script>
function pw_update(email) {
	var pw1 = document.getElementById("pw");
	var pw2 = document.getElementById("pw2");
	var pwrule = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[~`!@#$%^&*()_\-+=]).{10,16}$/;

	
	if(pw1.value == ""){
		alert("변경하실 비밀번호를 입력하세요");
		return false;
	}else if(pw2.value == ""){
		return false;
		alert("동일한 비밀번호를 입력하세요");
	}else if(!pwrule.test(pw1.value)){
		alert("비밀번호는 영문, 숫자, 특수문자를 포함하여 10~16자여야 합니다");
		return false;
	}else if(pw1.value != pw2.value){
		alert("비밀번호가 일치하지 않습니다");
		return false;
	}else{
		
	var area = document.getElementById("pw_area");
	area.innerHTML = `
		<form id="hide_f" method="post" action="./update_pw.do">
	      <input type="hidden" name="email" value="` + email+ `">
	      <input type="hidden" name="pw" value="`+ pw1.value +`">
	    </form>
		`;
		console.log("👉 암호화 전 비밀번호:", pw1.value);
		console.log("👉 hidden email 값:", email);
	document.getElementById("hide_f").submit();
	}
	
}
</script>
