<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
Date today = new Date();
%>
<%@ taglib prefix="cr" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" type="text/css" href="./css/index.css?v=<%=today%>">

<section>
	<div class="recommend">
		<p onclick="location.href='./md_board'">
			추천분양정보<br>
			<em onclick="location.href='./md_board'">실시간 추천 분양정보를 한곳에!</em>
		</p>

		<div class="md_estates">
			<ul>
				<cr:forEach var="mdata" items="${mdList}">
					<a href="${mdata.link}">
						<li>
							<div>
								<cr:if test="${empty mdata.file_url}">
									<img src="./md_room/${mdata.img}" alt="${mdata.mtitle}">
								</cr:if>
								<cr:if test="${not empty mdata.file_url}">
									<img src="..${mdata.file_url}" alt="${mdata.mtitle}">
								</cr:if>
							</div>
							<span>${mdata.mtitle}</span>
							<div>${mdata.details}</div>
						</li>
					</a>
				</cr:forEach>
			</ul>
		</div>
	</div>
</section>
