<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="cr" uri="http://java.sun.com/jsp/jstl/core"%>
    <link rel="stylesheet" type="text/css" href="./css/index.css?v=7">
<link rel="stylesheet" type="text/css" href="./css/reservation.css?v=7">
<form id="frm" method="post" action="./visitok.do">
<section class="sub">
<p>모델 하우스 사전 방문예약</p>
<div>
<span class="list_title">
<span style="color: blue;">분양정보</span>
<span style="color: red;">${info.apart_nm}</span>
</span>
<input type="hidden" name="vapart" value="${info.apart_nm}">
<ul class="sub_ul">
<li>방문일시</li>    
<li><input type="date" name="vdate" class="sel_input"></li> 
<li>방문시간</li>    
<li>
<select class="sel_input2" name="vtime">
    <option value="">방문시간선택</option>
    <option value="09:00">09:00</option>
    <option value="11:00">11:00</option>
    <option value="13:00">13:00</option>
    <option value="15:00">15:00</option>
    <option value="17:00">17:00</option>
</select> * 해당 시간에 맞춰서 방문해 주셔야 합니다.
</li> 
<li>방문자명</li>    
<li><input type="text" name="vname" class="sel_input" value="${sessionScope.dto.mem_nm}" readonly></li> 
<li>방문인원</li>    
<li>
<label><input type="radio" name="vcount" value="1" class="sel_check"> 1명</label>
<label><input type="radio" name="vcount" value="2" class="sel_check"> 2명</label> ※ 방문인원은 최대 2명까지 입니다.
</li>   
<li>연락처</li>    
<li><input type="text" name="vtel" class="sel_input" value="${sessionScope.dto.tel}" readonly></li>       
</ul>
</div>
<div>
<input type="button" value="방문 예약등록" onclick="govisit()">
</div>
</section>
</form>


<script src="./reservok.js?v=3" ></script>