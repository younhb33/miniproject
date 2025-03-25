<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="cr" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" type="text/css" href="./css/index.css?v=1">
<link rel="stylesheet" type="text/css" href="./css/email_search.css?v=2">

<form id="frm" method="post" action="./msearch_ok.do">
	<section class="sub">
		<div>
			<ul>
				<li onclick="location.href='./email_search.do'">이메일 찾기</li>
				<li onclick="location.href='./passwd_search.do'">비밀번호 찾기</li>
			</ul>
		</div>
		<div class="text1">
			<div>
				<input type="text" name="mem_nm" placeholder="이름을 입력하세요">
			</div>
			<div>
				<input type="text" name="tel" placeholder="휴대폰 번호는 - 빼고 숫자만 입력하세요"
					maxlength="11">
			</div>
		</div>
		<div>
			<input type="button" value="이메일 찾기" onclick="mail_search()">
		</div>
	</section>
</form>

<script src="./search.js?v=2"></script>