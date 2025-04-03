<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="cr" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>모댈 하우스 사전 방문예약</title>
<link rel="stylesheet" type="text/css" href="./css/index.css?v=10">
<link rel="stylesheet" type="text/css" href="./css/reservation.css?v=10">
</head>
<body>
<!-- top(header/menu) -->
 <cr:import url="./top.jsp"></cr:import>
<!-- top(header/menu)끝 -->
<main>
   <!-- 모델 하우스 사전 방문예약 -->
   <cr:import url="./reservation_view.jsp"></cr:import>
  <!-- 모델 하우스 사전 방문예약 끝 -->
</main>
<!-- 카피라이터 -->
 <footer>
   <cr:import url="./copyright.jsp"></cr:import>
 </footer>
 <!-- 카피라이터 끝 -->
</body>
</html>