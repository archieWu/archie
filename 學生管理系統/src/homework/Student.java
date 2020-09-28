package homework;

import java.util.Date;


public class Student {
	int id;
	String name;
	Date birthdate;
	double score;
	
	public Student() {
	}
	
	public Student(int id, String name, Date birthdate, double score) {
		//super();
		this.id = id;
		this.name = name;
		this.birthdate = birthdate;
		this.score = score;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
}

