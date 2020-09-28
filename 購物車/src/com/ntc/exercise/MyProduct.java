package com.ntc.exercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;



public class MyProduct extends Product{
	ArrayList a1 = new ArrayList();
	MyProduct (String barCode,String name,int price,double discont){
		super.setBarCode(barCode);//將取得的條碼存到父層
		super.setName(name);//將取得的名稱存到父層
		super.setPrice(price);//將取得的價錢存到父層
		super.setDiscont(discont);//將取得的折扣存到父層
	}
	MyProduct(){
	}
	String barCode() {
		return getBarCode(); //回傳條碼的值
	}
	String name() {
		return getName();//回傳名稱的值
	}
	int price() {
		return getPrice();//回傳價錢的值
	}
	double discont() {
		return getDiscont();//回傳折扣的值
	}
	ArrayList arrbuy(){//取出購物清單
		
		BufferedReader br;
		try(FileReader fr =new FileReader("C:\\Users\\d2684\\eclipse-workspace\\20200608\\src\\com\\ntc\\exercise\\ProductData.txt")){
			br = new BufferedReader(fr);		
			while (br.ready()) {
				String str = br.readLine();//將讀到的一行資料存成String
				if(str.charAt(0) == '#' ) {//第一個字元為#跳過
				    continue;
				   }
				if(str.charAt(0) == '-' ) {//第一個字元為-跳過
				    continue;
				   }
				String[] split_line = str.split(",");//降String以,分割
				MyProduct m = new MyProduct(split_line[0],split_line[1],//將取到的值轉型後存取成一個物件
						Integer.parseInt(split_line[2]),Double.parseDouble(split_line[3]));
				a1.add(m);//將物件存進ArrayList中
			}
		}catch(Exception e) {//執行時有錯誤顯示錯誤訊息後繼續執行
			e.printStackTrace();
		}
		return a1;
	}
	String arrpop(){//取出要刪除的條碼
		String remove = "";
		BufferedReader br;
		try (FileReader fr =new FileReader("C:\\Users\\d2684\\eclipse-workspace\\20200608\\src\\com\\ntc\\exercise\\ProductData.txt");){
			br = new BufferedReader(fr);		
			while (br.ready()) {
				String str = br.readLine();
				if(str.charAt(0) == '-' ) {//第一個字元為-執行
					remove = str;//將取地的值存入
				   }
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return remove;//回傳要刪除的條碼	
		}
	
}
