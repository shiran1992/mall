package com.wangyuan.entity;

public class Recom {
	private int rid;
	private Shop shop;
	private String title;
	private String img;
	public Recom() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Recom(int rid, Shop shop, String title, String img) {
		super();
		this.rid = rid;
		this.shop = shop;
		this.title = title;
		this.img = img;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public Shop getShop() {
		return shop;
	}
	public void setShop(Shop shop) {
		this.shop = shop;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	@Override
	public String toString() {
		return "Recom [rid=" + rid + ", shop=" + shop + ", title=" + title
				+ ", img=" + img + "]";
	}
}
