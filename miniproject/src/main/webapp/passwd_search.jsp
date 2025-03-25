<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="cr" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기</title>
<link rel="stylesheet" type="text/css" href="./css/index.css?v=1">
<link rel="stylesheet" type="text/css" href="./css/passwd_search.css?v=2">
</head>
<body>
<!--최상단-->
<!-- top(header/menu) -->
 <cr:import url="./top.jsp"></cr:import>
  <!-- top(header/menu)끝 -->
<main>
 <cr:import url="./passwd_search_view.jsp"></cr:import>
</main>
<!-- 카피라이터 -->
 <footer>
   <cr:import url="./copyright.jsp"></cr:import>
 </footer>
 <!-- 카피라이터 끝 -->
</body>
</html>