package test0709;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class DeptDAO implements IDAO<Dept>{

	public boolean insert(Dept t) {
		Connection connect = null;
		PreparedStatement preparedStatement = null;
		try {
			connect = MySQL.getConnection();
			preparedStatement = connect.prepareStatement("insert into DeptData values (?, ?, ?)");           //將資料寫入DeptData中
			preparedStatement.setInt(1, t.getId());                //取得id
			preparedStatement.setString(2, t.getDepartmentid());   //取得學號
			preparedStatement.setString(3, t.getDepartmentname()); //取得課程代號
			preparedStatement.executeUpdate();                     //更新資料庫
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
	public boolean update(Dept t) {
		// TODO 自動產生的方法 Stub
		return false;
	}

	@Override
	public boolean delete(Dept t) {
		// TODO 自動產生的方法 Stub
		return false;
	}

	@Override
	public Dept get(String id) {
		// TODO 自動產生的方法 Stub
		return null;
	}

	@Override
	public Dept get(int id) {
		// TODO 自動產生的方法 Stub
		return null;
	}

	@Override
	public List<Dept> getAll() {
		// TODO 自動產生的方法 Stub
		return null;
	}

	@Override
	public boolean join() {
		// TODO 自動產生的方法 Stub
		return false;
	}

}
