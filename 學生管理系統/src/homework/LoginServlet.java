package homework;

import java.sql.* ;
import java.io.* ;
import javax.servlet.http.* ;
import javax.servlet.* ;
import javax.servlet.annotation.WebServlet;
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet implements Servlet{
	public LoginServlet(){
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	
	}
	// protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	// System.out.println("-------------------------") ;
	// doPost(request, response) ;
	// }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String result = "" ;
		//獲取使用者名稱
		String username = request.getParameter("username") ;
		String psw = request.getParameter("password") ;
//		if ((username == "") || (username==null) || (username.length() > 20 )){
//			try{
//				result = "請輸入使用者名稱(不能超過20個字元)!" ;
//				request.setAttribute("message" ,result) ;
//				response.sendRedirect("login.jsp") ;
//			}catch(Exception e){
//				e.printStackTrace() ;
//			}
//		}
//		if ((psw == "") || (psw==null) || (psw.length() > 20 )){
//			try{
//				result = "請輸入密碼(不能超過20個字元)!" ;
//				request.setAttribute("message" ,result) ;
//				response.sendRedirect("login.jsp") ;
//			}catch(Exception e){
//				e.printStackTrace() ;
//			}
//		}
//		
		//登記JDBC驅動程式
		MySQL m= new MySQL();
		PreparedStatement pst = null;
		ResultSet resultSet = null;
		
		try{
			Connection conn = m.getConnection();
			String sql ="select * from userInfo where username='"+username+"' and userpsw= '"+psw+"'" ;
			pst = conn.prepareStatement(sql) ;
			//SQL語句
			
			resultSet = pst.executeQuery(); ;//返回查詢結果
		}catch(SQLException e){
			e.printStackTrace() ;
		}
		HttpSession session = request.getSession() ;
		session.setAttribute("username", username) ;
		//System.out.println("+++++++++++++++++++++++"+ username) ;
		try{
			if (resultSet.next()){ //如果記錄集非空,表明有匹配的使用者名稱和密碼,登陸成功
				// 登入成功後將username設定為session變數的username
				// 這樣在後面就可以通過 session.getAttribute("username") 來獲取使用者名稱,
				// 同時這樣還可以作為使用者登入與否的判斷依據
				response.sendRedirect("./controlServlet") ;
			}else{
				session.setAttribute("message", "使用者名稱或密碼不匹配。");
				response.sendRedirect("fail.jsp") ;
			}
		}catch(SQLException e){
			e.printStackTrace() ;
		}
	}
	
	private static final long serialVersionUID = 1L;
}