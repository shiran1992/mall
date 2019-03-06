package com.memo.service;

import java.util.List;

import com.memo.dao.UserDao;
import com.memo.entity.User;

public class UserService {

	UserDao dao = new UserDao();
	// 注册信息保存
	public boolean saveInfo(User user) {
		return dao.saveInfo(user);
	}
	
	// 判断登录是否成功
	public User getUserByPhone(User user) {
		return dao.getUserByPhone(user);
	}
	
	// 获取所有用户
	public List<User> getAllUser() {
		return dao.getAllUser();
	}

}
