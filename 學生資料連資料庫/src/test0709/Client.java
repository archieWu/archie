package test0709;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mysql.cj.jdbc.DatabaseMetaData;

public class Client {

	public static void main(String[] args) {
		IDAO<Student> sDAO = new StudentDAO();
		IDAO<StudentCourse> scDAO = new StudentCourseDAO();
		IDAO<Dept> dDAO = new DeptDAO();
		IDAO<Course> cDAO = new CourseDAO();
		IDAO<Result> rDAO = new ResultDAO();
		String[] StudentData = Read.readFile("C:\\Users\\d2684\\eclipse-workspace\\20200608\\src\\javahomework\\StudentData.txt");             //讀取StudentData.txt
		String[] StudentCourseData = Read.readFile("C:\\Users\\d2684\\eclipse-workspace\\20200608\\src\\javahomework\\StudentCourseData.txt"); //讀取StudentCourseData.txt
		String[] DeptData = Read.readFile("C:\\Users\\d2684\\eclipse-workspace\\20200608\\src\\javahomework\\DeptData.txt");                   //讀取DeptData.txt
		String[] CourseData = Read.readFile("C:\\Users\\d2684\\eclipse-workspace\\20200608\\src\\javahomework\\CourseData.txt");               //讀取CourseData.txt
		int i = 0; 																 //設置i用於取得id值
		for (String line : StudentData) {                                        //取得StudentData中的字串
			i++;                                                                 //取得id值進行排序
			String[] data = line.split(",");                                     //將字串依照,分割
			Student sd = new Student(i,data[0], data[1], data[2]); //將分割後的結果存成Student物件
			sDAO.insert(sd);													 //將內容存入資料庫中的表格(StudentData)
		}
		i = 0; 
		for (String line : StudentCourseData) {                                  //取得StudentCourseData中的字串
			i++;
			String[] data = line.split(",");
			StudentCourse scd = new StudentCourse(i,data[0], data[1]);   
			scDAO.insert(scd);												     //將內容存入資料庫中的表格(StudentCourseData)
		}
		i = 0;
		for (String line : DeptData) {											 //取得DeptData中的字串
			i++;
			String[] data = line.split(",");		  						     
			Dept dd = new Dept(i,data[0], data[1]);
			dDAO.insert(dd);													 //將內容存入資料庫中的表格(DeptData)
		}
		i = 0;
		for (String line : CourseData) {   										 //取得CourseData中的字串
			i++;
			String[] data = line.split(",");
			Course cd = new Course(i,data[0], data[1]);           
			cDAO.insert(cd);													 //將內容存入資料庫中的表格(CourseData)
		}
		rDAO.join();															 
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		
		
		
		
		
		
		
		
		
	}
}
