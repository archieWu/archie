package javahomework;

import java.util.ArrayList;
import java.util.Date;



public class SD{
	private String sid;     //學號
	private String name;    //姓名
	private String birthday;  //生日
	public SD(String sid, String name, String birthday) {
		this.sid = sid;
		this.name = name;
		this.birthday = birthday;
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
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
}
