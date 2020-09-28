package homework;

public class Client {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Date date = null;
		
		IDAO<Student> sd = new StudentDAO();
		Student s = new Student();
		s.setId(3);
		s.setName("Julien");
		s.setBirthdate(java.sql.Date.valueOf("1992-07-01"));
		s.setScore(84);
		sd.insert(s);
//		Student aStudent = sDAO.get("2");
//        System.out.println("ID: " + aStudent.getId());
//        System.out.println("Name: " + aStudent.getName());
//        System.out.println("Score: " + aStudent.getScore());
//        System.out.println("Birth: " + aStudent.getBirthdate());
//        
//        Student sS = new Student();
//        sS.id=10;
//        sS.name="Peter";
//        sS.birthdate=new Date();
//        sS.score=90.0;
//        sDAO.insert(sS);
//        sDAO.update(sS);
//        sDAO.delete(sS);
        

	}
}