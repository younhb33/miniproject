<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
HttpSession hs = request.getSession();
hs.invalidate();//모든 session 값 삭제 
out.print("<script>"
		+"alert('로그아웃 되었습니다.');"
		+"location.href='./index.do';"
		+"</script>");	
%>