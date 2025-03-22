<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
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
</head>
<body>
<!--최상단/메뉴-->
  <%@ include file="./top.jsp" %>
  <!--최상단/메뉴 끝-->
<main>
<!-- 로그인 창 -->
<%@ include file="./login_view.jsp" %>
<!-- 로그인 창 끝 -->
</main>

 <!-- 카피라이터 -->
 <footer>
<%@ include file="./copyright.jsp" %>
 </footer>
 <!-- 카피라이터 끝 -->
</body>
</html>