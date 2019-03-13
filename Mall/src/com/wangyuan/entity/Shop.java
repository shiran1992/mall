package com.wangyuan.entity;

public class Shop {
	private int sid;
	private String head;
	private String title;
	private String intro;
	private String imgs;
	private String price;
	private int num;
	private String time;
	private String video;
	public Shop() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Shop(int sid, String head, String title, String intro, String imgs,
			String price, int num, String time, String video) {
		super();
		this.sid = sid;
		this.head = head;
		this.title = title;
		this.intro = intro;
		this.imgs = imgs;
		this.price = price;
		this.num = num;
		this.time = time;
		this.video = video;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getHead() {
		return head;
	}
	public void setHead(String head) {
		this.head = head;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public String getImgs() {
		return imgs;
	}
	public void setImgs(String imgs) {
		this.imgs = imgs;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getVideo() {
		return video;
	}
	public void setVideo(String video) {
		this.video = video;
	}
	@Override
	public String toString() {
		return "Shop [sid=" + sid + ", head=" + head + ", title=" + title
				+ ", intro=" + intro + ", imgs=" + imgs + ", price=" + price
				+ ", num=" + num + ", time=" + time + ", video=" + video + "]";
	}
}
