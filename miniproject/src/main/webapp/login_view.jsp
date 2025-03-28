<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="cr" uri="http://java.sun.com/jsp/jstl/core" %>    
<link rel="stylesheet" type="text/css" href="./css/index.css?v=120">
<link rel="stylesheet" type="text/css" href="./css/login.css?v=20">

<style>
.box {
   width: 800px;
   height: 300px;
   border: 1px solid black;
   overflow: auto;
}

</style>
    
		<form id="frm" method="post" action="./loginok.do">
	<aside class="login_pg">	
		<p>이메일로 시작하기</p>
		<div><input type="text" name="email" placeholder="이메일 주소"></div>
		<div><input type="password" name="pw" placeholder="비밀번호"></div>
		<div><input type="button" value="로그인" onclick="logincheck()"></div>
		<div><input type="button" value="카카오로그인" class="kakao_btn"></div>
		<div>
			<span onclick="location.href='member_join.do'">회원가입</span>
			<span onclick="location.href='email_search.do'">이메일 찾기</span>
			<span onclick="location.href='passwd_search.do'">비밀번호 찾기</span>
		</div>
	</aside>
		</form>
	
<script src="loginok.js?v=2"></script>