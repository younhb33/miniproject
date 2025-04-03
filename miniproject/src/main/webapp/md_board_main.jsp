<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="cr" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
    <link rel="stylesheet" type="text/css" href="./css/index.css?v=10">
<link rel="stylesheet" type="text/css" href="./css/md_board.css?v=11">
    <section class="sub">
        <p>추천분양 정보 게시판</p>
        <div class="boards">이번주 신규 매물정보를 한눈에 확인하실 수 있습니다.</div>
        <div class="info_board">
          <ul>
            <li>NO</li>
            <li>제목</li>
            <li>글쓴이</li>
            <li>조회수</li>
            <li>등록일</li>
          </ul>
          <!-- 배열값을 조건문으로 jstl에 처리: functions & length로 검토하여 처리 -->
          <cr:if test="${fn:length(all) == 0}">
          <ul><li class="nodata">등록된 게시물이 없습니다.</li></ul>
          </cr:if>
          <cr:set var="ino" value="${total-userpage}"/><!-- 게시물 일련번호 세팅 -->
          <cr:forEach var="gl" items="${all}" varStatus="idx">
          <ul class="data_view" onclick="location.href='./md_board_view?aidx=${gl.aidx}'" style="cursor:pointer;">
            <li>${ino-idx.index}</li> 
            <li style="text-align: left;">${fn:replace(gl.mtitle, '<br>', ' ')}</li>
            <li>${gl.lname}</li>
            <li>${gl.lview}</li>
            <li>${fn:substring(gl.ldate,0,10)}</li>
          </ul>
          </cr:forEach>
        </div>
        <div class="info_pageing">
          <ol>
          <cr:set var="pageidx" value="${total / 10 + (1-((total / 10) % 1)) % 1}"/>
            <cr:forEach var="no" begin="1" end="${pageidx}" step="1">
            <li onclick="pg('${no}')">${no}</li>
            </cr:forEach>
          </ol>
        </div>
        <form id="sform" method="get" action="./md_board" onsubmit="return spage()">
        <div class="info_search">
          <input type="text" name="search" value="${search}" class="search_text" placeholder="검색어를 입력하세요">
          <input type="submit" value="검색" class="search_btn">
        </div>
        </form>
    </section>
    
    
    
    <script>
    function spage() {
		if(sform.search.value==""){
			location.href="./md_board";
			return false;
		}else{
			return;
		}
	}
    
    function pg(no) {
		location.href='./md_board?pageno='+no;
	}
    
    </script>