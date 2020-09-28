package javahomework;

import java.util.ArrayList;
import java.util.Iterator;


public class Client {
	static ArrayList<SD> sda = new ArrayList<SD>(); //StudentDataArray
	static ArrayList<SCD> scda = new ArrayList<SCD>();//StudentCourseDataArray
	static ArrayList<DD> dda = new ArrayList<DD>();	//DeptDataArray
	static ArrayList<CD> cda = new ArrayList<CD>();	//CourseDataArray
	static ArrayList<All> alla = new ArrayList<All>();	//AllDataArray
	public static void main(String[] args) {
		String[] StudentData = Read.readFile("C:\\Users\\d2684\\eclipse-workspace\\20200608\\src\\javahomework\\StudentData.txt");             //讀取StudentData.txt
		String[] StudentCourseData = Read.readFile("C:\\Users\\d2684\\eclipse-workspace\\20200608\\src\\javahomework\\StudentCourseData.txt"); //讀取StudentCourseData.txt
		String[] DeptData = Read.readFile("C:\\Users\\d2684\\eclipse-workspace\\20200608\\src\\javahomework\\DeptData.txt");                   //讀取DeptData.txt
		String[] CourseData = Read.readFile("C:\\Users\\d2684\\eclipse-workspace\\20200608\\src\\javahomework\\CourseData.txt");               //讀取CourseData.txt
		for (String line : StudentData) {
			String[] data = line.split(",");
			SD sd = new SD(data[0], data[1], data[2]); //將StudentData讀到的文字分割後存成SD object
			sda.add(sd);
		}
		for (String line : StudentCourseData) {
			String[] data = line.split(",");
			SCD scd = new SCD(data[0], data[1]);       //將StudentCourseData讀到的文字分割後存成SCD object
			scda.add(scd);
		}
		for (String line : DeptData) {
			String[] data = line.split(",");		   //將DeptData讀到的文字分割後存成DD object
			DD dd = new DD(data[0], data[1]);
			dda.add(dd);
		}
		for (String line : CourseData) {
			String[] data = line.split(",");
			CD cd = new CD(data[0], data[1]);          //將CourseData讀到的文字分割後存成CD object
			cda.add(cd);
		}
		Iterator<SD> it1 = sda.iterator();
		while (it1.hasNext()) {                       //將sda中的物件一個個取出
			ArrayList cname = new ArrayList();
			SD sd = it1.next();
			Iterator<DD> it4 = dda.iterator();        //將dda中的物件一個個取出
			while (it4.hasNext()) {
				DD dd = it4.next();
				if(sd.getSid().substring(0,2).equals(dd.getDid())) {   //比對學號前兩碼科系代號
					Iterator<SCD> it2 = scda.iterator();
					while (it2.hasNext()) {           //將scda中的物件一個個取出
						SCD scd = it2.next();
						if(sd.getSid().equals(scd.getId())) {          //比對學號對應的課程代號
							Iterator<CD> it3 = cda.iterator();
							while (it3.hasNext()) {       //將cda中的物件一個個取出
								CD cd = it3.next();
								if(scd.getCid().equals(cd.getCid())) {     //比對課程代號帶入名稱
									cname.add(cd.getCname());              //將所有相符的課程名稱存入ArrayList
								}
							}
						}
						
					}
					All all = new All(sd.getSid(),sd.getName(),dd.getDname(),cname);  //將一名學生的資訊存成all object後放入ArrayList中
					alla.add(all);
				}
				
				
			}

			
			
		}
		Iterator<All> it5 = alla.iterator();
		System.out.println("結果報表: 學號,姓名,科系,修課內容");
		while (it5.hasNext()) {
			All all = it5.next();
			System.out.println(all.getSid()+","+all.getName()+","+all.getDname()+","+all.getClassname()); //將物件取出並顯示
			
		}
		
		
		
		
		
	}
}
