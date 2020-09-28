<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>登陸失敗</title>
</head>
<body>
<%
String userName = (String)session.getAttribute("username") ;
String msg = (String)session.getAttribute("message") ;
%>
<div align="center">
<%=userName %>
對不起,登陸失敗!

<font color="red">原因:
<%=msg %>
<br/>
<br/>
5秒後將返回登陸介面。
</div>

<%
response.setHeader("Refresh","5;URL=./login.jsp");
%>
</body>
</html>