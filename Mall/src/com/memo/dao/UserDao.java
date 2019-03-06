package com.memo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.memo.entity.Memo;
import com.memo.entity.User;
import com.memo.util.DBConnection;

public class UserDao {

	// 注册信息保存
	public boolean saveInfo(User user) {
		Connection conn = null;
		PreparedStatement prep = null;
		try {
			// 1、联数据库
			conn = DBConnection.getConnection();
			// 2、SQL语句
			String sql = "insert into user(name, phone, password) values(?,?,?)";
			// 3、获得PreparedStatement对象
			prep = conn.prepareStatement(sql);
			// 4、设置？的值
			prep.setString(1, user.getName());
			prep.setString(2, user.getPhone());
			prep.setString(3, user.getPassword());
			// 5、执行SQL语句
			prep.executeUpdate();

		} catch (Exception e) {
			// 一定要处理异常，异常的信息要存在日志文件
			// 转化为你应用程序的异常，再抛出
			// 抛异常说明注册失败
			return false;
			// throw new RuntimeException(e);

		} finally {
			// 6、关闭资源
			try {
				if (prep != null)
					prep.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		return true;
	}

	// 判断登录是否成功
	public User getUserByPhone(User user) {
		Connection conn = null;
		PreparedStatement prep = null;
		try {
			// 1、
			conn = DBConnection.getConnection();
			// 2、
			String sql = "select * from user where phone=? and password=?";
			// 3、
			prep = conn.prepareStatement(sql);
			// 4、
			prep.setString(1, user.getPhone());
			prep.setString(2, user.getPassword());
			// 5、执行SQL语句
			ResultSet rs = prep.executeQuery();
			// 6、处理查询结果
			// 创建一个学生对象
			User u = new User();
			// 取到数据 ==》 装到一个学生对象中
			if (rs.next()) {
				u.setUid(rs.getInt("uid"));
				u.setName(rs.getString("name"));
				u.setPhone(rs.getString("phone"));
				u.setPassword(rs.getString("password"));
			} else {
				return null;
			}
			return u;
		} catch (Exception e) {
			// 一定要处理异常，异常的信息要存在日志文件
			// 转化为你应用程序的异常，再抛出
			throw new RuntimeException(e);
		} finally {
			// 6、关闭资源
			try {
				if (prep != null)
					prep.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}

	// 通过uid找回user
	public User getUserByUid(int uid) {
		Connection conn = null;
		PreparedStatement prep = null;
		try {
			// 1、
			conn = DBConnection.getConnection();
			// 2、
			String sql = "select * from user where uid=?";
			// 3、
			prep = conn.prepareStatement(sql);
			// 4、
			prep.setInt(1, uid);
			// 5、执行SQL语句
			ResultSet rs = prep.executeQuery();
			// 6、处理查询结果
			// 创建一个学生对象
			User u = new User();
			// 取到数据 ==》 装到一个学生对象中
			if (rs.next()) {
				u.setUid(rs.getInt("uid"));
				u.setName(rs.getString("name"));
				u.setPhone(rs.getString("phone"));
				u.setPassword(rs.getString("password"));
			} else {
				return null;
			}
			return u;
		} catch (Exception e) {
			// 一定要处理异常，异常的信息要存在日志文件
			// 转化为你应用程序的异常，再抛出
			throw new RuntimeException(e);
		} finally {
			// 6、关闭资源
			try {
				if (prep != null)
					prep.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}

	// 获取所有用户
	public List<User> getAllUser() {
		Connection conn = null;
		PreparedStatement prep = null;
		List<User> users = new ArrayList<User>();
		try {
			conn = DBConnection.getConnection();
			String sql = "select * from user order by uid";
			prep = conn.prepareStatement(sql);
			ResultSet rs = prep.executeQuery();
			if (rs.next()) {
				User u = new User();
				u.setUid(rs.getInt("uid"));
				u.setName(rs.getString("name"));
				u.setPhone(rs.getString("phone"));
				u.setPassword(rs.getString("password"));
				users.add(u);
			}
		} catch (Exception e) {
			// 一定要处理异常，异常的信息要存在日志文件
			// 转化为你应用程序的异常，再抛出
			throw new RuntimeException(e);
		} finally {
			// 6、关闭资源
			try {
				if (prep != null)
					prep.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		return users;
	}
}
