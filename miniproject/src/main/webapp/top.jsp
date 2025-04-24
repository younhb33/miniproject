<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Date today = new Date();
%>
    <%@taglib prefix="cr" uri="http://java.sun.com/jsp/jstl/core" %>
    
    <link rel="stylesheet" type="text/css" href="./css/index.css?v=<%=today%>">
    <link rel="stylesheet" type="text/css" href="./css/md_board_view.css?v=<%=today%>">
    <style>
.box {
   width: 800px;
   height: 300px;
   border: 1px solid black;
   overflow: auto;
}
</style>
<!--최상단-->
 <header>
  <div class="top_banner"></div>
 </header>
  <!--최상단끝-->
 <!--메뉴-->
 <nav>
  <div class="menus">
    <ul class="menus_ul">
      <li onclick="location.href='./index.do'"><img src="./logo/e_click_logo.png"></li>
      <li>일반매물</li>
      <li><a href="./md_board">추천매물</a></li>
      <li>중계의뢰</li>
      <li><a href="./counsel.do">상담신청</a></li>
      <li>업체의뢰</li>
      <li>의뢰현황</li>
      <li class="logins" onmouseleave="myinfo_menu(2)">
  <span title="회원정보" onclick="myinfo_menu(1)">
    <img src="./ico/login.svg">
    <ul class="login_info" id="login_info" style="display: none;">
      <cr:choose>
        <cr:when test="${not empty sessionScope.dto and not empty sessionScope.dto.mem_nm}">
          <li>${sessionScope.dto.mem_nm}님 <a href="./logout.jsp">[로그아웃]</a></li>
        </cr:when>
        <cr:otherwise>
          <li><a href="./login.do">로그인</a> / <a href="./member_join.do">회원가입</a></li>
        </cr:otherwise>
      </cr:choose>
    </ul>
  </span>
  <span title="모델 하우스 사전예약 리스트" onclick="reserve_page()">
    <img src="./ico/reserve_list.svg" onclick="location.href='./reservation_list'">
  </span>
</li>

    </ul>
  </div>
 </nav>
  <script>
    //해당 함수는 모델 하우스 사전 방문예약 확인 리스트 페이지로 이동 되도록 합니다.
    function reserve_page() {

    }
    function myinfo_menu(part){
        var log_menu = document.getElementById("login_info");
        if(part==1){
            if(log_menu.style.display == "none"){
                log_menu.style.display = "block"; 
            }
            else{
                log_menu.style.display = "none"; 
            }
        }
        else{
            log_menu.style.display = "none"; 
        }
    }
 </script>
  <!--메뉴끝-->