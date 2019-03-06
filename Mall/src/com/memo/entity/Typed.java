package com.memo.entity;

public class Typed {
	private int tid;
	private String name;
	private int type;
	private User user;
	private String dateTime;

	public Typed() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Typed(int tid, String name, int type, User user, String dateTime) {
		super();
		this.tid = tid;
		this.name = name;
		this.type = type;
		this.user = user;
		this.dateTime = dateTime;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	@Override
	public String toString() {
		return "Type [tid=" + tid + ", name=" + name + ", type=" + type
				+ ", user=" + user + ", dateTime=" + dateTime + "]";
	}

}
