package com.ntc.exercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import com.ntc.javaclass.Teacher;

public class ShoppingCart implements ShoppingRule{
	MyProduct m = new MyProduct();
	Product p =new Product();
	int needpay = 0;
	ArrayList a1 = new ArrayList();
	
	public boolean put(Product prod) {
		a1.add(prod);//將取得的物件存入ArrayList中
		return true;
	}

	public boolean pop(Product prod) {
		String remove = m.arrpop();//取得要刪除的條碼
		String check = "-"+prod.getBarCode();//取得物件中的條碼
		if (check.equals(remove)) { //判斷是否相等
		 a1.remove(prod); //將物件移除
		}
		return true;
	}

	
	public void listing() {
		Iterator it = a1.iterator();
		needpay = 0;//將要付的金額歸零
		System.out.println("條碼                          名稱      價格               折扣");
		while(it.hasNext()) {
			m = (MyProduct) it.next();
			System.out.printf("%s %3s      %-4d    %2.1f"//將物件中的值取出並顯示
					,m.getBarCode(),m.getName(),
					m.getPrice(),m.getDiscont());
			System.out.print("\n");
			needpay+=m.getPrice()*(1-m.getDiscont());//計算購物中物品的總價
		}
		
	}


	public int cost() {
		
		return needpay;//回傳要付的金額
	}


}
