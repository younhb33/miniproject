<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="cr" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <link rel="stylesheet" type="text/css" href="./css/index.css?v=10">
  <link rel="stylesheet" type="text/css" href="./css/member_join.css?v=10">
<style>
.box {
   width: 800px;
   height: 300px;
   border: 1px solid black;
   overflow: auto;
}
</style>
<title>Insert title here</title>
</head>
<body>
<!-- top(header/menu) -->
 <cr:import url="./top.jsp"></cr:import>
  <!-- top(header/menu)끝 -->


<main>
<!-- join_view -->
 <cr:import url="./memberjoin_view.jsp"></cr:import>
  <!-- join_view 끝 -->
</main>

 <!-- 카피라이터 -->
 <footer>
   <cr:import url="./copyright.jsp"></cr:import>
 </footer>
 <!-- 카피라이터 끝 -->
</body>
</html>