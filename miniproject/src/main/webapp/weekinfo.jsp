<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="cr" uri="http://java.sun.com/jsp/jstl/core"%>
<%
Date today = new Date();
%>
<link rel="stylesheet" type="text/css" href="./css/index.css?v=<%=today%>">
<section>
	<div class="weekdays">
		<p>
			금주분양 매물정보<br> <em>이번주 신규 매물정보!</em>
		</p>

		<div class="week_estates">
			<ul>
				<cr:forEach var="idata" items="${weekList}" varStatus="aidx">
					<li><a href="./week_tails?aidx=${idata.aidx}"> <span>${idata.situ}</span>
							<div>${idata.apart_nm}</div>
							<aside>${idata.addr}</aside> <span>${idata.type} |
								${idata.rent_type}</span> <label>${idata.sale_date} |
								${idata.in_date}</label>

							<div>
								<img src="./room/${idata.img}">
							</div>
					</a></li>
				</cr:forEach>
			</ul>
		</div>

	</div>
</section>
