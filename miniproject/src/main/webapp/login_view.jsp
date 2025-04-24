<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="cr" uri="http://java.sun.com/jsp/jstl/core" %>    
<%
Date date = new Date();
%>

<style>
.box {
   width: 800px;
   height: 300px;
   border: 1px solid black;
   overflow: auto;
}

</style>
    
		<form id="frm" method="post" action="./loginok.do">
		<input type="hidden" name="mcode"value="1">
      	<input type="hidden" name="kakao_id" value="">
      	<input type="hidden" name="kakao_nicknm" value="">
	<aside class="login_pg">	
		<p>이메일로 시작하기</p>
		<div><input type="text" name="email" placeholder="이메일 주소"></div>
		<div><input type="password" name="pw" placeholder="비밀번호"></div>
		<div><input type="button" value="로그인" onclick="logincheck()"></div>
		<div><input type="button" value="카카오로그인" onclick="kakao_login()" class="kakao_btn"></div>
		<div>
			<span onclick="location.href='member_join.do'">회원가입 |</span>
			<span onclick="location.href='email_search.do'">이메일 찾기 |</span>
			<span onclick="location.href='passwd_search.do'">비밀번호 찾기</span>
		</div>
	</aside>
		</form>
	
<script src="loginok.js?v=<%=date%>"></script>


<script src="https://t1.kakaocdn.net/kakao_js_sdk/v1/kakao.js"></script>
<script>
Kakao.init('6b3c21b9e92fa8db4ac60e57c8e9ab2a'); //키 발급된 번호
function kakao_login() {
   Kakao.Auth.login({
      success:function(response){	//response 결과 화면 (사실 여기서 안넣어도됨)
    	  //Kakao.API.request : 카카오 회원가입 및 로그인 페이지를 출력하는 함수
         Kakao.API.request({	//사용자 가입 정보를 ㅇㅅ총
             url: '/v2/user/me', // 사용자 정보 가져오기
             //성공시 출력되는 형태
             success:function(response){ //API서버에서 가입정보를 가져옴 
               console.log(response);
             	let id = response["id"];	//고유값
             
             	//카카오에서 제공하는 별칭
             	let nickname = response["kakao_account"]["profile"]["nickname"];
             	//console.log(id);
             	frm.mcode.value = "2";
             	frm.kakao_id.value = id;
             	frm.submit();
             
             },
             //API 키가 맞지 않을 경우 출력되는 함수
             fail:function(error){
                  console.log(error);
                  console.log("카카오 API 접속 오류");
               }
         });
      },
      fail:function(error){
         console.log(error);
         console.log("카카오 key 접속 오류 및 환경설정 오류");
      }
   });
}
</script>


