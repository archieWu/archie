package test0709;


public class Dept {
	int id;               //排序
	String departmentid;  //科系代號
	String departmentname;//科系名稱	

	public Dept() {
	}
	
	public Dept(int id, String departmentid, String departmentname) {
		this.id = id;
		this.departmentid = departmentid;
		this.departmentname = departmentname;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDepartmentname() {
		return departmentname;
	}

	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
	}
	public String getDepartmentid() {
		return departmentid;
	}

	public void setDepartmentid(String departmentid) {
		this.departmentid = departmentid;
	}
}
