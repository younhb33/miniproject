<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<link rel="stylesheet" type="text/css" href="./css/index.css?v=1">
<link rel="stylesheet" type="text/css" href="./css/login.css?v=2">
<style>
.box {
   width: 800px;
   height: 300px;
   border: 1px solid black;
   overflow: auto;
}

</style>
    
	<aside class="login_pg">	
		<p>이메일로 시작하기</p>
		<div><input type="text" name="lemail" placeholder="이메일 주소"></div>
		<div><input type="password" name="lpass" placeholder="비밀번호"></div>
		<div><input type="button" value="로그인" onclick="login.logincheck()"></div>
		<div>
			<span>이메일 찾기</span>
			<span>비밀번호 찾기</span>
		</div>
	</aside>