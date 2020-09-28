<%@page import="java.util.List"%>
<%@page import="homework.Student"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">

<meta name="viewport" content="width=device-width, initial-scale=1">

<title>學生資料</title>

<style>
table.table {
	margin: auto;
}

td, th {
	text-align: center;
}
</style>
</head>
<body>
	<div>
		<h3 style="text-align: center">學生紀錄表</h3>

		<div style="text-align: center" ;margin:5px>
			<a class="btn"
				href="${pageContext.request.contextPath}/AddStu.jsp">添加聯絡人</a>
		</div>
		<form action="${pageContext.request.contextPath}/controlServlet" method="post">
		
		<table border="1" class="table">
			<tr class="success">
				<th>ID</th>
				<th>姓名</th>
				<th>生日</th>
				<th>成績</th>
			</tr>

			<%
				List<Student> allStu = (List<Student>) request.getAttribute("allStu");
				request.setAttribute("student", allStu);
			%>
			<c:forEach items="${student}" var="student" varStatus="s">
				<tr>

					<td>${student.id}</td>
					<td>${student.name}</td>
					<td>${student.birthdate}</td>
					<td>${student.score}</td>

					<td><a class="" href="${pageContext.request.contextPath}/EdiStu.jsp?id=${student.id}">修改</a>
						<a href="${pageContext.request.contextPath}/controlServlet?id=${student.id}">删除</a></td>
				</tr>
				<% 
					
				
				%>
			</c:forEach>
		

		</table>
</form>
	</div>

	<script>
	document.getElementById("del").onclick = function(id) {
		location.href = "${pageContext.request.contextPath}/controlServlet?id="+id;
	}
	


	
<!--	
function checkStatus(){
		if(this.checked != true){
			for(var i=0; i< box.length;i++){
				box[i].checked = true;
			}
		}
	}
-->
	
	</script>
</body>
</html>