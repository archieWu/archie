package javahomework;

import java.util.ArrayList;

public class All {
	private String sid;         //學號
	private String name;        //姓名
	private String dname;       //科系名稱
	private ArrayList classname; //修課名稱
	public All(String sid, String name, String dname,ArrayList classname) {
		this.sid = sid;
		this.name = name;
		this.dname = dname;
		this.classname = classname;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public ArrayList getClassname() {
		return classname;
	}
	public void setClassname(ArrayList classname) {
		this.classname = classname;
	}
}
