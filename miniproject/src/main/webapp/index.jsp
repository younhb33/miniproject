<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="cr" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>온라인 부동산 중개</title>
  <link rel="stylesheet" type="text/css" href="./css/index.css?v=7">
</head>
<body>
<!-- top(header/menu) -->
 <cr:import url="./top.jsp"></cr:import>
  <!-- top(header/menu)끝 -->
 <main>
  <!--배너-->
  <cr:import url="./banner.jsp"></cr:import>
 <!--배너 끝-->
 <!-- 카테고리 -->
   <cr:import url="./quickmenu.jsp"></cr:import>
 <!-- 카테고리 끝-->
 
   <!--금주 분양 매물 정보 시작-->
   <cr:import url="./weekinfo.jsp"></cr:import>
  <!--금주 분양 매물 정보 끝-->
  <!--추천 분양 정보-->
  <cr:import url="./mdchoice.jsp"></cr:import>
  <!--추천 분양 정보 끝-->
 </main>
 <!-- 카피라이터 -->
 <footer>
   <cr:import url="./copyright.jsp"></cr:import>
 </footer>
 <!-- 카피라이터 끝 -->
</body>
</html>