<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>新增學生</title>
</head>
<body>
	<center>
		<h3>新增學生</h3>

		<form action="${pageContext.request.contextPath}/controlServlet"
			method="post">
			<div class="form-group">
				<label for="name">ID：</label> <input type="text"
					required="required" class="form-control" id="id" name="newid" placeholder="輸入ID">
			</div>
			<div class="form-group">
				<label for="name">姓名：</label> <input type="text"
					required="required" class="form-control" id="name" name="newname" placeholder="輸入姓名">
			</div>
			<div class="form-group">
				<label for="phone">生日：</label> <input type="text" id="birth"
					required="required" class="form-control" name="newbirth" placeholder="yyyy-mm-dd" />
			</div>

			<div class="form-group">
				<label for="age">成績：</label> <input type="text" required="required" class="form-control"
					id="score" name="newscore" placeholder="輸入成績">
			</div>
			<br>
			<div class="form-group" style="text-align: center">
				<input class="btn btn-primary" type="submit" value="提交" /> <a
					class="btn btn-default"
					href="${pageContext.request.contextPath}/controlServlet"
					role="button">返回</a>
			</div>

		</form>
	</center>
</body>
</html>