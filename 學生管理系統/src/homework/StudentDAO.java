package homework;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class StudentDAO implements IDAO<Student> {
	Connection connect = MySQL.getConnection();
	PreparedStatement pstm = null;

	@Override
	public boolean insert(Student t) {
		try {
			pstm = connect.prepareStatement("insert into Student values(?,?,?,?)");
			pstm.setInt(1, t.id);
			pstm.setString(2, t.getName());
			pstm.setDate(3, (Date) t.birthdate);
			pstm.setDouble(4, t.getScore());
			pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return true;
	}

	@Override
	public boolean update(Student t) {
		try {
			pstm = connect.prepareStatement("update Student set id = ?,name = ? ,birth = ?,score = ? where id =?");
			pstm.setInt(1, t.getId());
			pstm.setString(2, t.getName());
			pstm.setDate(3, (Date) t.getBirthdate());
			pstm.setDouble(4, t.getScore());
			pstm.setDouble(5, t.getId());
			pstm.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return true;
	}

	@Override
	public boolean delete(Student t) {
		try {
			pstm = connect.prepareStatement("delete from Student where id =?");
			pstm.setInt(1, t.getId());
			pstm.executeUpdate();	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;

	}

	@Override
	public Student get(String id) {
		return get(Integer.parseInt(id));
	}

	@Override
	public Student get(int id) {
		Student Stu = null;
		try {

			pstm = connect.prepareStatement("select * from Student where id=?");
			pstm.setInt(1, id);
			ResultSet resultSet = pstm.executeQuery();
			while (resultSet.next()) {
				int sid = resultSet.getInt("id");
				String name = resultSet.getString("name");
				Date birth = resultSet.getDate("birth");
				double score = resultSet.getDouble("score");
				Stu = new Student(sid, name, birth, score);
			}
			if (resultSet != null)
				resultSet.close();
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return Stu;
	
	}

	@Override
	public List<Student> getAll() {
		 ArrayList<Student> arr = new ArrayList<Student>();
		try {
			pstm = connect.prepareStatement("select * from Student");
			ResultSet resultSet = pstm.executeQuery();
			while (resultSet.next()) {
				Student stu = new Student();
				stu.setId(resultSet.getInt("id"));
				stu.setName(resultSet.getString("name"));
				stu.setBirthdate(resultSet.getDate("birth"));
				stu.setScore(resultSet.getDouble("score"));
				arr.add(stu);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arr;
	}
}
