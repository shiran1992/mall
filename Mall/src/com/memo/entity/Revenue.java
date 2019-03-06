package com.memo.entity;

public class Revenue {

	private int rid;
	private User user;
	private Typed type;
	private String account;
	private String title;
	private String desc;
	private String dateTime;

	public Revenue() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Revenue(int rid, User user, Typed type, String account,
			String title, String desc, String dateTime) {
		super();
		this.rid = rid;
		this.user = user;
		this.type = type;
		this.account = account;
		this.title = title;
		this.desc = desc;
		this.dateTime = dateTime;
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Typed getType() {
		return type;
	}

	public void setType(Typed reType) {
		this.type = reType;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	@Override
	public String toString() {
		return "Revenue [rid=" + rid + ", user=" + user + ", type=" + type
				+ ", account=" + account + ", title=" + title + ", desc="
				+ desc + ", dateTime=" + dateTime + "]";
	}

}
