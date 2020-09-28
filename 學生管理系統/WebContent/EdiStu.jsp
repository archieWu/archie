<%@page import="homework.StudentDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改學生</title>
</head>
<body>
	<% 
	
	String id = request.getParameter("id");
	StudentDAO dao = new StudentDAO();
	request.setAttribute("oldstudent",dao.get(id));
	%>
	<center>
		<h3>修改學生資料</h3>

		<form action="${pageContext.request.contextPath}/controlServlet"
			method="post">
			<div class="form-group">
				<label for="name">ID：</label> <input type="text"
					required="required" class="form-control" id="id" value="${oldstudent.id}" name="updateid" placeholder="輸入ID">
			</div>
			<div class="form-group">
				<label for="name">姓名：</label> <input type="text"
					required="required" class="form-control" id="name" value="${oldstudent.name}" name="updatename" placeholder="輸入姓名">
			</div>
			<div class="form-group">
				<label for="phone">生日：</label> <input type="text" id="birth"
					required="required" class="form-control" name="updatebirth"  value="${oldstudent.birthdate}" placeholder="yyyy-mm-dd" />
			</div>

			<div class="form-group">
				<label for="age">成績：</label> <input type="text" required="required" class="form-control"
					id="score" name="updatescore" value="${oldstudent.score}" placeholder="輸入成績">
			</div>
			<br>
			<div class="form-group" style="text-align: center">
				<input class="btn btn-primary" type="submit" value="確認修改" /> <a
					class="btn btn-default"
					href="${pageContext.request.contextPath}/controlServlet"
					role="button">返回</a>
			</div>
		
		</form>
	</center>
</body>
</html>