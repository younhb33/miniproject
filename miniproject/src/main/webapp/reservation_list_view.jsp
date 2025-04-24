<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Date today = new Date();
%>
    <%@taglib prefix="cr" uri="http://java.sun.com/jsp/jstl/core"%>
    <link rel="stylesheet" type="text/css" href="./css/index.css?v=<%=today%>">
<link rel="stylesheet" type="text/css" href="./css/reservation_list.css?v=<%=today%>">
    <section class="sub">
        <p>모델 하우스 방문 예약 리스트</p>
        <div class="boards">모델 하우스 방문 예약한 정보를 한눈에 확인 하실 수 있습니다.</div>
        <div class="info_board">
          <ul>
            <li>NO</li>
            <li>아파트명</li>
            <li>방문일자</li>
            <li>방문시간</li>
            <li>인원수</li>
            <li>취소</li>
          </ul>
          <cr:if test="${empty rsvlist}">
          <ul style="display: block;"><li class="nodata">등록된 방문 예약이 없습니다.</li></ul>
          </cr:if>
          
          <cr:forEach var="rsv" items="${rsvlist}" varStatus="i">
          <ul class="data_view">
            <li>${i.index + 1}</li>
            <li style="text-align: left;">${rsv.apartment_name}</li>
            <li>${rsv.visit_date}</li>
            <li>${rsv.visit_time}</li>
            <li>${rsv.people_count}명</li>
            <li><input type="button" value="취소" onclick="rsv_cancel(${rsv.visit_id})" class="cancel_btn"></li>
          </ul>
          </cr:forEach>
        </div>
    </section>
	<form id="frm" method="post" action="./rsvlist_del">
    <input type="hidden" name="visit_id" value="${rsv.visit_id}">
    </form>
    
<script>    
function rsv_cancel(visit_id) { //: visit_index
	if (confirm("방문예약을 취소 하시겠습니까?")) {		//확인
		frm.visit_id.value=visit_id;
		frm.submit();
	}
}
</script>    