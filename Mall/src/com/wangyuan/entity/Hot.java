package com.wangyuan.entity;

public class Hot {
	private int hid;
	private String img;
	private String title;
	private Shop shop;
	public Hot() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Hot(int hid, String img, String title, Shop shop) {
		super();
		this.hid = hid;
		this.img = img;
		this.title = title;
		this.shop = shop;
	}
	public int getHid() {
		return hid;
	}
	public void setHid(int hid) {
		this.hid = hid;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Shop getShop() {
		return shop;
	}
	public void setShop(Shop shop) {
		this.shop = shop;
	}
	@Override
	public String toString() {
		return "Hot [hid=" + hid + ", img=" + img + ", title=" + title
				+ ", shop=" + shop + "]";
	}
}
