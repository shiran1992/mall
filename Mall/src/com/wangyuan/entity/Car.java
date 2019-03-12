package com.wangyuan.entity;

public class Car {
	private int cid;
	private User user;
	private Shop shop;
	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Car(int cid, User user, Shop shop) {
		super();
		this.cid = cid;
		this.user = user;
		this.shop = shop;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Shop getShop() {
		return shop;
	}
	public void setShop(Shop shop) {
		this.shop = shop;
	}
	@Override
	public String toString() {
		return "Car [cid=" + cid + ", user=" + user + ", shop=" + shop + "]";
	}
}
