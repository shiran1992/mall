package com.wangyuan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wangyuan.entity.Order;
import com.wangyuan.util.Application;
import com.wangyuan.util.DBConnection;

public class OrderDao {
	// 创建订单
	public boolean save(int uid, int sid, String address, String phone) {
		Connection conn = null;
		PreparedStatement prep = null;
		try {
			// 1、联数据库
			conn = DBConnection.getConnection();
			// 2、SQL语句
			String sql = "insert into orders("
					+ "uid,sid,time,state,address,phone) "
					+ " values(?,?,?,?,?,?)";
			// 3、获得PreparedStatement对象
			prep = conn.prepareStatement(sql);
			System.out.println(prep.toString());
			// 4、设置？的值
			prep.setInt(1, uid);
			prep.setInt(2, sid);
			prep.setString(3, System.currentTimeMillis() + "");
			prep.setInt(4, 0);
			prep.setString(5, address);
			prep.setString(6, phone);
			// 5、执行SQL语句
			prep.executeUpdate();
		} catch (Exception e) {
			// 一定要处理异常，异常的信息要存在日志文件
			// 转化为你应用程序的异常，再抛出
			return false;
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

	// 分页获取活动集合
	public List<Order> getPageOrders(int uid) {
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		List<Order> orders = new ArrayList<Order>();
		try {
			// 1、联数据库
			conn = DBConnection.getConnection();
			// 2、SQL语句
			String sql = "select * from orders where uid=? order by oid desc";
			// 3、获得PreparedStatement对象
			prep = conn.prepareStatement(sql);
			prep.setInt(1, uid);
			// 5、执行SQL语句
			rs = prep.executeQuery();
			// 6、处理查询结果，
			while (rs.next()) {
				// 对每一条记录，==》转换为一个新的活动对象
				Order order = new Order();
				order.setOid(rs.getInt("oid"));
				order.setUser(new UserDao().getUserByUid(rs.getInt("uid")));
				order.setShop(new ShopDao().getShopBySid(rs.getInt("sid")));
				order.setTime(rs.getString("time"));
				order.setState(rs.getString("state"));
				order.setAddress(rs.getString("address"));
				order.setPhone(rs.getString("phone"));
				orders.add(order);
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
		return orders;
	}

	// 获取订单集合
	public List<Order> getOrdersByPage() {
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		List<Order> orders = new ArrayList<Order>();
		try {
			// 1、联数据库
			conn = DBConnection.getConnection();
			// 2、SQL语句
			String sql = "select * from orders";
			// 3、获得PreparedStatement对象
			prep = conn.prepareStatement(sql);
			// 5、执行SQL语句
			rs = prep.executeQuery();
			// 6、处理查询结果，
			while (rs.next()) {
				// 对每一条记录，==》转换为一个新的活动对象
				Order order = new Order();
				order.setOid(rs.getInt("oid"));
				order.setUser(new UserDao().getUserByUid(rs.getInt("uid")));
				order.setShop(new ShopDao().getShopBySid(rs.getInt("sid")));
				order.setTime(rs.getString("time"));
				order.setState(rs.getString("state"));
				order.setAddress(rs.getString("address"));
				order.setPhone(rs.getString("phone"));
				orders.add(order);
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
		return orders;
	}

	// 通过oid
	public Order getOrderByOid(int oid) {
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		Order order = new Order();
		try {
			// 1、联数据库
			conn = DBConnection.getConnection();
			// 2、SQL语句
			String sql = "select * from orders where oid=?";
			// 3、获得PreparedStatement对象
			prep = conn.prepareStatement(sql);
			prep.setInt(1, oid);
			// 5、执行SQL语句
			rs = prep.executeQuery();
			// 6、处理查询结果，
			while (rs.next()) {
				order.setOid(rs.getInt("oid"));
				order.setUser(new UserDao().getUserByUid(rs.getInt("uid")));
				order.setShop(new ShopDao().getShopBySid(rs.getInt("sid")));
				order.setTime(rs.getString("time"));
				order.setState(rs.getString("state"));
				order.setAddress(rs.getString("address"));
				order.setPhone(rs.getString("phone"));
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
		return order;
	}

	// 删除订单
	public Boolean deleteOrderByOid(int oid) {
		Connection conn = null;
		PreparedStatement prep = null;
		try {
			// 1、联数据库
			conn = DBConnection.getConnection();
			// 2、SQL语句
			String sql = "delete from orders where oid=?";
			// 3、获得PreparedStatement对象
			prep = conn.prepareStatement(sql);
			// 4、设置？的值
			prep.setInt(1, oid);
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

	// 修改订单信息
	public boolean update(Order order) {
		Connection conn = null;
		PreparedStatement prep = null;
		try {
			conn = DBConnection.getConnection();
			String sql = "UPDATE orders SET state=? WHERE oid=?";
			prep = conn.prepareStatement(sql);
			prep.setString(1, order.getState());
			prep.setInt(2, order.getOid());
			prep.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();
			return false;
		} finally {

			try {
				if (conn != null)
					conn.close();
				if (prep != null)
					prep.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		return true;
	}
}
