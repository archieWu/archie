package test0709;


public class Student {
	int id;               //排序
	String studentid;     //學號
	String name;          //姓名
	String birthdate;     //生日
	

	public Student() {
	}
	
	public Student(int id, String studentid, String name, String data) { 
		this.id = id;
		this.studentid = studentid;
		this.name = name;
		this.birthdate = data;
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
	public String getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	
}
