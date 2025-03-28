<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="cr" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link rel="stylesheet" type="text/css" href="./css/index.css?v=30">
<link rel="stylesheet" type="text/css" href="./css/login.css?v=16">
<style>
.box {
   width: 800px;
   height: 300px;
   border: 1px solid black;
   overflow: auto;
}

</style>
</head>
<body>
<!--최상단/메뉴-->
  <cr:import url="./top.jsp"></cr:import>
  <!--최상단/메뉴 끝-->
<main>
<!-- 로그인 창 -->
<cr:import url="./login_view.jsp"></cr:import>
<!-- 로그인 창 끝 -->
</main>

 <!-- 카피라이터 -->
 <footer>
<cr:import url="./copyright.jsp"></cr:import>
 </footer>
 <!-- 카피라이터 끝 -->
</body>
</html>