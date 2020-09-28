package test0709;


public class Course {
	int id;               //排序
	String classid;       //課程代號
	String classname;     //課程名稱	

	public Course() {
	}
	public Course(int id, String classid, String classname) {
		this.id = id;
		this.classid = classid;
		this.classname = classname;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	public String getClassid() {
		return classid;
	}

	public void setClassid(String classid) {
		this.classid = classid;
	}
}
