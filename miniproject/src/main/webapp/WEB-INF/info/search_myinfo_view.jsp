<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
    <link rel="stylesheet" type="text/css" href="./css/index.css?v=1">
<link rel="stylesheet" type="text/css" href="./css/search_myinfo.css?v=2">

<section class="sub">
<div>
<ul>
<li>회원가입된 이메일 확인</li>
</ul>
</div>
<div class="text1">
<div>가입하신 이메일 정보 : ${msg} </div>
</div>
<div><input type="button" value="정보확인" class="search_submit" onclick="location.href='/login.do'"></div>
</section>