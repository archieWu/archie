package com.ntc.exercise;

import java.util.ArrayList;
import java.util.Iterator;

public class Client {
	
	public static void main(String[] args) {
		int needpay=0;
		ShoppingCart cart = new ShoppingCart();
		MyProduct m = new MyProduct();
		ArrayList a1 = m.arrbuy();//將從文件讀取到的物件回傳到Client端
		Iterator it = a1.iterator();//將ArrayList中的物件取出
		while(it.hasNext()) {//如果還有物件就執行
			m = (MyProduct) it.next();//將物件取出
			cart.put(m); //將取出後的物件丟到ShoppingCart中做存取
		}
		//.........
		cart.listing(); //購物車清單
		needpay=cart.cost();//取得購物車價錢
		System.out.println("要付"+needpay+"元"); //顯示購物車價錢
		//退東西
		Iterator it1 = a1.iterator();//將ArrayList中的物件取出
		while(it1.hasNext()) {//如果還有物件就執行
			m = (MyProduct) it1.next();//將物件取出
		cart.pop(m);//將取出後的物件丟到ShoppingCart中做移除
		}
		cart.listing();//購物車清單
		needpay=cart.cost();//取得購物車價錢
		System.out.println("要付"+needpay+"元");//顯示購物車價錢
		
		
		
		

	}

}
