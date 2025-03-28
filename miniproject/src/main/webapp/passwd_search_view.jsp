<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<form id="frm" method="post" action="./psearch_ok.do">
<section class="sub">
	<div>
		<ul>
			<li onclick="location.href='./email_search.do'">이메일 찾기</li>
			<li onclick="location.href='./passwd_search.do'">비밀번호 찾기</li>
		</ul>
	</div>
	<div class="text1">
		<div>
			<input type="text" name="email" placeholder="가입하신 이메일을 입력하세요">
		</div>
		<div>
			<input type="text" name="tel" placeholder="휴대폰 번호는 - 빼고 숫자만 입력하세요"
				maxlength="11">
		</div>
	</div>
	<div>
		<input type="button" value="비밀번호 찾기" onclick="pw_search()">
	</div>
</section>
	</form>

<script src="./search.js?v=2"></script>