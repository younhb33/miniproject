<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="cr" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>금주 분양 매물 정보</title>
<link rel="stylesheet" type="text/css" href="./css/index.css?v=12">
<link rel="stylesheet" type="text/css" href="./css/week_tails.css?v=12">
</head>
<body>
<!-- top(header/menu) -->
 <cr:import url="./top.jsp"></cr:import>
  <!-- top(header/menu)끝 -->
<main>
  <!--금주분양 매물정보 리스트-->
  <cr:import url="./week_tails_view.jsp"></cr:import>
  <!--금주분양 매물정보 리스트 끝-->
</main>
 <!-- 카피라이터 -->
 <footer>
   <cr:import url="./copyright.jsp"></cr:import>
 </footer>
 <!-- 카피라이터 끝 -->
</body>
</html>