<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="cr" uri="http://java.sun.com/jsp/jstl/core" %>
    <link rel="stylesheet" type="text/css" href="./css/index.css?v=8">
<!--최상단-->
 <header>
  <div class="top_banner"></div>
 </header>
  <!--최상단끝-->
 <!--메뉴-->
 <nav>
  <div class="menus">
    <ul class="menus_ul">
      <li><a href="./index.do"><img src="./logo/e_click_logo.png" onclick="location.href='./index.do'"></a></li>
      <li>일반매물</li>
      <li>추천매물</li>
      <li>중계의뢰</li>
      <li>상담신청</li>
      <li>업체의뢰</li>
      <li>의뢰현황</li>
      <li class="logins">
      <!-- 로그인 되어있을 경우 -->
      	<cr:if test="${not empty sessionScope.dto.mem_nm}">
        ${sessionScope.dto.mem_nm}님 환영합니다
        <a href="./logout.jsp">[로그아웃]</a>
        </cr:if>
        
        <!-- 로그인 되어있지 않을 경우 -->
        <cr:if test="${empty sessionScope.dto.mem_nm}">
        <span title="로그인"><a href="./login.do"><img src="./ico/login.svg"></a></span>
        <span title="회원가입"><a href="./member_join.do"><img src="./ico/membership.svg"></a></span>
      	</cr:if>
      </li>
    </ul>
  </div>
 </nav>
  <!--메뉴끝-->