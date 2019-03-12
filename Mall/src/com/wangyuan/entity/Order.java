package com.wangyuan.entity;

public class Order {
	private int oid;
	private User user;
	private Shop shop;
	private String address;
	private String phone;
	private String time;
	private String state;
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(int oid, User user, Shop shop, String address, String phone,
			String time, String state) {
		super();
		this.oid = oid;
		this.user = user;
		this.shop = shop;
		this.address = address;
		this.phone = phone;
		this.time = time;
		this.state = state;
	}
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "Order [oid=" + oid + ", user=" + user + ", shop=" + shop
				+ ", address=" + address + ", phone=" + phone + ", time="
				+ time + ", state=" + state + "]";
	}
}
