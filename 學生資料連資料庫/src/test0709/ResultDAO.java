package test0709;

import java.sql.Clob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.serial.SerialClob;

public class ResultDAO implements IDAO<Result>{
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
	@Override
	public boolean insert(Result t) {
		Connection connect = null;
		PreparedStatement preparedStatement = null;
		try {
			connect = MySQL.getConnection();
			preparedStatement = connect.prepareStatement("insert into Result values (?, ?, ?, ?, ?)");       //將資料寫入Result中
			preparedStatement.setInt(1, t.getId());                 //取得id
			preparedStatement.setString(2, t.getStudentid());       //取得學號
			preparedStatement.setString(3, t.getName());            //取得學生姓名
			preparedStatement.setString(4, t.getDepartmentname());  //取得科系名稱
			Clob clob = clob(t.getAllclass());                      //取得全部的課程名稱轉換成clob物件
			preparedStatement.setClob(5, clob);                     //將clob物件存入
			preparedStatement.executeUpdate();		                //更新資料庫
			
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
	public boolean update(Result t) {
		// TODO 自動產生的方法 Stub
		return false;
	}

	@Override
	public boolean delete(Result t) {
		// TODO 自動產生的方法 Stub
		return false;
	}

	@Override
	public Result get(String id) {
		// TODO 自動產生的方法 Stub
		return null;
	}

	@Override
	public Result get(int id) {
		// TODO 自動產生的方法 Stub
		return null;
	}

	@Override
	public List<Result> getAll() {
		// TODO 自動產生的方法 Stub
		return null;
	}

	@Override
	public boolean join() {
		Connection connect = null;
		PreparedStatement preparedStatement = null;
		try {
			connect = MySQL.getConnection();
			preparedStatement = connect.prepareStatement(
					"SELECT sd.studentid , sd.name , dd.departmentName ,  cd.classname " + 
					"FROM CourseData cd , DeptData dd , StudentCourseData scd , StudentData sd " + 
					"WHERE substring(sd.studentid, 1, 2) = dd.departmentid && sd.studentid=scd.studentid && scd.classid = cd.classid " + 
					"order by sd.id;");
			/* 
			     使用sql語法選擇所需的內容
			     選擇 StudentData中的studentid,StudentData中的name,DeptData中的departmentName,CourseData中的classname
			     使用 CourseData表格簡寫為cd,DeptData表格簡寫為dd,StudentCourseData表格簡寫為scd,StudentData表格簡寫為sd
			     取StudentData中的studentid(學號)前兩個字動應DeptData中的departmentid(科系代號),StudentData中的studentid(學號)動應StudentCourseData中的studentid(學號)
			   StudentCourseData中的classid(課程代號)動應CourseData中的classid(課程代號)
			     依照StudentData中的id排序
			*/
			ResultSet resultSet = preparedStatement.executeQuery();
			int i = 0;
			int j = 0;
			String studentid = "";
			String name = "";
			String departmentName = "";
			String classname = "";
			ArrayList<String> allclass = new ArrayList<String>();
			while (resultSet.next()) {
				if(!studentid.equals(resultSet.getString("studentid")) && j != 0) { 
					/*
					    判斷上一個studentid不等於現在的studentid且不是第一次執行迴圈
					    確認現在取得的內容已經是下一個學生
					*/
					i++;  //取得id值進行排序
					Result result = new Result(i,studentid, name,departmentName,allclass); //將取得的資料存成Student物件
					insert(result);                                                                   //存入資料庫
					while(allclass.size() > 0) {                                                      //判斷allclass是否清空
						allclass.remove(0);                                                           //清空allclass中的資料
					}
				}
					studentid = resultSet.getString("studentid");                                     //取得studentid
					name = resultSet.getString("name");                                               //取得studentid
					departmentName = resultSet.getString("departmentName");                           //取得studentid
					classname = resultSet.getString("classname");                                     //取得studentid
					allclass.add(classname);                                                          //將classname存入allclass中
	                j++;                                                                              //j++用於判斷迴圈執行次數   
            }
            if (resultSet!=null) {                                                                    
            	i++;
            	Result result = new Result(i,studentid, name,departmentName,allclass);
				insert(result);
				resultSet.close();
            }  	
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return true; 
	}

}
