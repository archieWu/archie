package com.ntc.exercise;

public class Product {
	private String barCode; //產品條碼
	private String name; //產品名稱
	private int price; //產品價格
	private double discont;//產品折扣
	public String getBarCode() {
		return barCode;
	}
	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public double getDiscont() {
		return discont;
	}
	public void setDiscont(double discont) {
		this.discont = discont;
	}
	
}
