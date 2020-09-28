package test0709;


public class StudentCourse {
	int id;               //排序
	String studentid;     //學號
	String classid;       //課程代號


	public StudentCourse() {
	}
	
	public StudentCourse(int id, String studentid, String classid) {
		this.id = id;
		this.studentid = studentid;
		this.classid = classid;
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


	public String getClassid() {
		return classid;
	}

	public void setClassid(String classid) {
		this.classid = classid;
	}
}
