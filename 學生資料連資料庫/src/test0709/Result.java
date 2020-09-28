package test0709;

import java.util.ArrayList;

public class Result {
	int id;               //排序
	String studentid;     //學號
	String name;          //姓名
	String departmentname;//科系名稱
	String classname;     //課程名稱
	ArrayList allclass = new ArrayList(); //全部課程名

	public Result() {
	}
	public Result(int id, String studentid,String name, String departmentname,ArrayList allclass ) {
		this.id = id;
		this.studentid = studentid;
		this.name = name;
		this.departmentname = departmentname;
		this.allclass = allclass;
	}

	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStudentid() {
		return studentid;
	}

	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartmentname() {
		return departmentname;
	}

	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
	}

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}
	public ArrayList getAllclass() {
		return allclass;
	}
	
	public void setAllclass(ArrayList allclass) {
		this.allclass = allclass;
	}
}
