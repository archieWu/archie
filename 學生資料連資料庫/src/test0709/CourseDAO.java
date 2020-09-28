package test0709;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class CourseDAO implements IDAO<Course>{

	public boolean insert(Course t) {
		Connection connect = null;
		PreparedStatement preparedStatement = null;
		try {
			connect = MySQL.getConnection();
			preparedStatement = connect.prepareStatement("insert into CourseData values (?, ?, ?)");         //將資料寫入CourseData中
			preparedStatement.setInt(1, t.getId());                //取得id
			preparedStatement.setString(2, t.getClassid());      //取得學號
			preparedStatement.setString(3, t.getClassname());        //取得課程代號
			preparedStatement.executeUpdate();                	   //更新資料庫		
		} catch (Exception e) {
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
	            }
				if (connect != null) {
					connect.close();
				}
			} catch (SQLException e) {
			}
		}
		return true;
	}

	@Override
	public boolean update(Course t) {
		// TODO 自動產生的方法 Stub
		return false;
	}

	@Override
	public boolean delete(Course t) {
		// TODO 自動產生的方法 Stub
		return false;
	}

	@Override
	public Course get(String id) {
		// TODO 自動產生的方法 Stub
		return null;
	}

	@Override
	public Course get(int id) {
		// TODO 自動產生的方法 Stub
		return null;
	}

	@Override
	public List<Course> getAll() {
		// TODO 自動產生的方法 Stub
		return null;
	}

	@Override
	public boolean join() {
		// TODO 自動產生的方法 Stub
		return false;
	}

}
