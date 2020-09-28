package test0709;

import java.sql.Clob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.sql.rowset.serial.SerialClob;


public class StudentDAO implements IDAO<Student> {
	List<Clob> clobs;
	Clob clob(ArrayList classname) throws SQLException {
		        Clob clob = null;
		        ArrayList<String> A = new ArrayList(classname);  
		        String str = "";
		        int i = 0;
		        for(String a : A){       //將ArrayList中的字串取出
		        	i++;
		        	if(i==1) {
		        		str = str + "{"; //在字串空的時候加入{
		        	}
		        	str = str + a;
		        	if(i == A.size()) {  
		        		str = str + "}"; //在字串最後加入}
		        	}
					if(i != A.size()) { 
						str = str + ","; //在每個課程名稱中間加上,
					}
		        }
		        clob = new SerialClob(str.toCharArray()); //將字串轉換成clob物件
		        return clob; 							  //回傳轉換後的clob物件
    }
	public boolean insert(Student t) {
		Connection connect = null;
		PreparedStatement preparedStatement = null;
		try {
			connect = MySQL.getConnection();
			preparedStatement = connect.prepareStatement("insert into StudentData values (?, ?, ?, ?)");  //將資料寫入StudentData中
			preparedStatement.setInt(1, t.getId());            //取得id
			preparedStatement.setString(2, t.getStudentid());  //取得學號
			preparedStatement.setString(3, t.getName());       //取得學生姓名
			preparedStatement.setString(4, t.getBirthdate());  //取得學生生日
			preparedStatement.executeUpdate();                 //更新資料庫
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
	public boolean update(Student t) {
		return true;
	}
	public boolean delete(Student t) {
		return true;
	}
	public Student get(String id) {
		return get(Integer.parseInt(id));
	}
	public Student get(int id) {
		Student aStud=null;
//		try(
//			Connection connect = MySQL.getConnection();
//			PreparedStatement preparedStatement = connect.prepareStatement("select * from Student where id=?");
//		){
//            preparedStatement.setInt(1, id);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) {
//                int sid = resultSet.getInt("id");
//                String name = resultSet.getString("name");
//                double score = resultSet.getDouble("score");
//                Date birth = resultSet.getDate("birth");
//            }
//            if (resultSet!=null)
//            	resultSet.close();
//		} catch (SQLException se) {
//			se.printStackTrace();
//		} 
		return aStud;
	}
	public List<Student> getAll(){
//		Connection conn = MySQL.getConnection();
//		System.out.println(conn);
//		try {
//			conn.close();
//		}catch(Exception e) {	
//		}
		return new ArrayList<Student>();
	}
	public boolean join() {
		
		return true; 
	}
}
