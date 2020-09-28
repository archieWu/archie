package homework;

import java.io.IOException;
import java.sql.Date;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ControlServlet
 */
@WebServlet("/controlServlet")
public class ControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IDAO<Student> sdao = new StudentDAO();
	List<Student> allStu = sdao.getAll();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute("allStu", allStu);

		//修改的屬性
		String upid = request.getParameter("updateid");
		String upname = request.getParameter("updatename");
		String upBirth = request.getParameter("updatebirth");
		String upScore = request.getParameter("updatescore"); 
		// 新增的屬性
		String newid = request.getParameter("newid");
		String newname = request.getParameter("newname");
		String newBirth = request.getParameter("newbirth");
		String newScore = request.getParameter("newscore");
		String id = request.getParameter("id"); // 刪除的id
		if(upBirth!=null) {
		Date updatebirth = java.sql.Date.valueOf(upBirth);
		Student stu = new Student(Integer.parseInt(upid), upname, updatebirth, Double.parseDouble(upScore));
		
		System.out.println(stu.name);
		sdao.update(stu);
		request.setAttribute("allStu", sdao.getAll());
		request.getRequestDispatcher("StuData.jsp").forward(request, response);
		}else if (newid != null & newname != null & newBirth != null & newScore != null) {
			Date newbirth = java.sql.Date.valueOf(newBirth);
			Student s = new Student(Integer.parseInt(newid), newname, newbirth, Double.parseDouble(newScore));
			sdao.insert(s);
			request.setAttribute("allStu", sdao.getAll());
			request.getRequestDispatcher("StuData.jsp").forward(request, response);
		} else if (id != null) {
			// 刪除
			sdao.delete(sdao.get(id));

			request.setAttribute("allStu", sdao.getAll());
			request.getRequestDispatcher("StuData.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("StuData.jsp").forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

