
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
	<head>
		<title>學生資訊管理系統</title>
	</head>
	<body>
		<form method="POST" action="./LoginServlet">
			<h1 align="center">使用者登入</h1>
		
			<center>
			<table border=1>
				<tr>
					<td>使用者名稱:</td>
					<td>
						<input type="text" name="username" size="20" maxlength="20"  placeholder="輸入賬號"/>
					</td>
				</tr>
				<tr>
					<td>密碼:</td>
					<td>
						<input type="password" name="password" size="20" maxlength="20" placeholder="輸入的密碼"/>
					</td>
				</tr>
				<tr>
					<td>
						<input type="submit" value="提交" onClick="return validateLogin()" />
					</td>
					<td>
						<input type="reset" value="重置" onClick="resetValue()"/>
					</td>
				</tr>
			</table>
			
		</form>
					
		</center>
		<script language="javascript">
			function validateLogin(){
				var sUserName = document.frmLogin.username.value ;
				var sPassword = document.frmLogin.password.value ;
				if ((sUserName =="") || (sUserName=="Your name")){
					alert("請輸入使用者名稱!");
					return false ;
				}
				
				if ((sPassword =="") || (sPassword=="Your password")){
					alert("請輸入密碼!");
				return false ;
				}
			}
		</script>
		<script type="text/javascript">
		    function resetValue(){
			    document.getElementById("username").value="";
			    document.getElementById("password").value="";
		    }
   		 </script>
	</body>
</html>

