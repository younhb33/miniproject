<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Date today = new Date();
%>
<style>
.box {
   width: 800px;
   height: 300px;
   border: 1px solid black;
   overflow: auto;
}
</style>
	<form id="f" method="post" action="./join_ok.do">
	<input type="hidden" name="mjoin" value="WEB"> <!-- 기본값 <!-- 1 : 자회사회원가입 / 2 : 카카오 -->
	<input type="hidden" name="mcode" value="1">    <!-- 기본값 WEB, KAKAO, NAVER -->
	
		<p>이메일로 회원가입</p>
		<div>
			<a>이메일</a> <input type="text" id="email" name="email" placeholder=" 이메일 주소를 입력해주세요." autocomplete="none" style="width:400px; float:left;"> 
			<input type="button" value="중복체크" class="mail_btn" onclick="check_email()">
			<input type="hidden" id="emailck" value=""> <!-- 중복체크 -->
		</div>
		<div>
			<a>비밀번호</a> <input type="password" name="pw" placeholder=" 10~16자(영문,숫자,특수 문자 조합)로 입력해주세요." autocomplete="none">
		</div>
		<div>
			<a>비밀번호 확인</a> <input type="password" name="pw_ok" placeholder=" 비밀번호를 다시 한 번 입력해주세요." autocomplete="none">
		</div>
		<div>
		    <a>이름</a> <input type="text" name="mem_nm" placeholder=" 이름을 입력해주세요." autocomplete="none">
		</div>
		<div>
		    <a>휴대폰번호</a> <input type="text" name="tel" maxlength="11" placeholder=" -없이 숫자만 입력해주세요." autocomplete="none">
		</div>
		<div>
		<input type="checkbox" id="allselect" name="agree_all" onclick="all_check(this.checked)" value="Y"> <span>전체 동의</span> </div>
		
		<div class="line"></div>
		
	<div class="bottom">	
		<div class="box1"><input type="checkbox" id="ok_14" name="agree_14" onclick="ag_check()" value="Y"> <a class="a1">(필수) <span>만 14세 이상입니다.</span></a></div>
		<div class="box2"><input type="checkbox" id="serviceok" name="agree_terms" onclick="ag_check()" value="Y"> <a class="a2">(필수) <span><u>이용약관</u>에 동의</span></a></div>
		<div class="box3"><input type="checkbox" id="infook" name="agree_privacy" onclick="ag_check()" value="Y"> <a class="a3">(필수) <span><u>개인정보 수집 및 이용</u>에 동의</span></a></div>
		<section class="text1" id="ag1">   </section>
		<div class="box4"><input type="checkbox" id="addok" name="agree_marketing" onclick="ag_check()" value="Y"> <span>(선택) 마케팅 수신에 동의</span></div>
		<section class="text2" id="ag2">   </section>
	</div>
		<div><input type="button" value="가입 하기" onclick="joinok()"></div>
	</form>
	
	
	
<script src = "./joinok.js?v=<%=today%>"></script>
