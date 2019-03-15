package com.wangyuan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.wangyuan.entity.Car;
import com.wangyuan.entity.Hot;
import com.wangyuan.util.DBConnection;

public class CarDao {
	public List<Car> getCars(int uid) {
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		List<Car> cars = new ArrayList<Car>();
		try {
			// 1、联数据库
			conn = DBConnection.getConnection();
			// 2、SQL语句
			String sql = "select * from car where uid=?";
			// 3、获得PreparedStatement对象
			prep = conn.prepareStatement(sql);
			prep.setInt(1, uid);
			// 5、执行SQL语句
			rs = prep.executeQuery();
			// 6、处理查询结果，
			while (rs.next()) {
				// 对每一条记录，==》转换为一个新的活动对象
				Car c = new Car();
				c.setCid(rs.getInt("cid"));
				c.setUser(new UserDao().getUserByUid(rs.getInt("uid")));
				c.setShop(new ShopDao().getShopBySid(rs.getInt("sid")));
				cars.add(c);
			}
		} catch (Exception e) {
			// 一定要处理异常，异常的信息要存在日志文件
			// 转化为你应用程序的异常，再抛出
			throw new RuntimeException(e);
		} finally {
			// 6、关闭资源
			try {
				if (rs != null)
					rs.close();
				if (prep != null)
					prep.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		return cars;
	}
	
	public boolean save(int uid, int sid) {
		Connection conn = null;
		PreparedStatement prep = null;
		try {
			// 1、联数据库
			conn = DBConnection.getConnection();
			// 2、SQL语句
			String sql = "insert into car(" + "uid,sid) "
					+ " values(?,?)";
			// 3、获得PreparedStatement对象
			prep = conn.prepareStatement(sql);
			// 4、设置？的值
			prep.setInt(1, uid);
			prep.setInt(2, sid);
			// 5、执行SQL语句
			prep.executeUpdate();
		} catch (Exception e) {
			// 一定要处理异常，异常的信息要存在日志文件
			// 转化为你应用程序的异常，再抛出
			throw new RuntimeException(e);
			// return false;
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
}
