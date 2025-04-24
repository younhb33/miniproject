<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Date today = new Date();
%>    
    <link rel="stylesheet" type="text/css" href="./css/index.css?v=<%=today%>">
 <section>
    <div class="banners">
      <ul>
        <li><img src="./banners/banner1.jpg"></li>
        <li><img src="./banners/banner2.jpg"></li>
      </ul>
    </div>
  </section>
  
    