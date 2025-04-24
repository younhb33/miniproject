<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Date today = new Date();
%>    
    <%@ taglib prefix="cr" uri="http://java.sun.com/jsp/jstl/core" %>
    
<link rel="stylesheet" type="text/css" href="./css/index.css?v=<%=today%>">
<link rel="stylesheet" type="text/css" href="./css/week_tails.css?v=<%=today%>">

	<div class="weektails">
		<p>분양정보</p>
		<div id="weektails">
			<p>${info.apart_nm}</p>
            <ul>
                <li>종류</li>
                <li>${info.type} | ${info.rent_type} </li>
                <li>주소</li>
				<li>${info.addr}</li>
                <li>규모</li>
				<li>총 ${info.house_mem}세대 | 총 ${info.build}개동</li>
                <li>시기</li>
				<li>${info.sale_date} | ${info.in_date}</li>
                <li>난방구조</li>
				<li>${info.heat_type}</li>
                <li>건설사</li>
				<li>${info.comp_nm}</li>
                <li>사진정보</li>
				<li><img src="./room/${info.img}"></li>
            </ul>
		</div>
		<cr:choose>
			<cr:when test="${not empty vinfo}">
        		<div><button class="btn_close" onclick="location.href='./reservation_check?vapart=${info.apart_nm}'">방문예약완료</button></div>
        	</cr:when>
        	<cr:otherwise>
        		<div><button class="btn_css" onclick="location.href='./reservation?aidx=${info.aidx}'">방문예약</button></div>
        	</cr:otherwise>
        </cr:choose>
        
	</div>

<!-- 
info.apart_nm : 방문예약을 구분할 수 있는 고유한 값(vapart) 
: 분양 아파트의 이름
info객체 = weekinfo_DTO
 -->