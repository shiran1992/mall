package com.wangyuan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wangyuan.entity.Shop;
import com.wangyuan.util.Application;
import com.wangyuan.util.DBConnection;

public class ShopDao {

	// 通过sid
	public Shop getShopBySid(int sid) {
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		Shop shop = new Shop();
		try {
			// 1、联数据库
			conn = DBConnection.getConnection();
			// 2、SQL语句
			String sql = "select * from shop where sid=?";
			// 3、获得PreparedStatement对象
			prep = conn.prepareStatement(sql);
			prep.setInt(1, sid);
			// 5、执行SQL语句
			rs = prep.executeQuery();
			// 6、处理查询结果，
			while (rs.next()) {
				shop.setSid(rs.getInt("sid"));
				shop.setTitle(rs.getString("title"));
				shop.setHead(rs.getString("head"));
				shop.setPrice(rs.getString("price"));
				shop.setIntro(rs.getString("intro"));
				shop.setImgs(rs.getString("imgs"));
				shop.setNum(rs.getInt("num"));
				shop.setTime(rs.getString("time"));
				shop.setVideo(rs.getString("video"));
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
		return shop;
	}

	// 获取所有的shop
	public List<Shop> getShopsByPage() {
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		List<Shop> shops = new ArrayList<Shop>();
		try {
			// 1、联数据库
			conn = DBConnection.getConnection();
			// 2、SQL语句
			String sql = "select * from shop";
			// 3、获得PreparedStatement对象
			prep = conn.prepareStatement(sql);
			// 5、执行SQL语句
			rs = prep.executeQuery();
			// 6、处理查询结果，
			while (rs.next()) {
				// 对每一条记录，==》转换为一个新的活动对象
				Shop shop = new Shop();
				shop.setSid(rs.getInt("sid"));
				shop.setTitle(rs.getString("title"));
				shop.setHead(rs.getString("head"));
				shop.setPrice(rs.getString("price"));
				shop.setIntro(rs.getString("intro"));
				shop.setImgs(rs.getString("imgs"));
				shop.setNum(rs.getInt("num"));
				shop.setTime(rs.getString("time"));
				shop.setVideo(rs.getString("video"));
				shops.add(shop);
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
		return shops;
	}

	// 创建
	public boolean save(Shop shop) {
		Connection conn = null;
		PreparedStatement prep = null;
		try {
			// 1、联数据库
			conn = DBConnection.getConnection();
			// 2、SQL语句
			String sql = "insert into shop("
					+ "title,head,price,imgs,intro,num,time,video) "
					+ " values(?,?,?,?,?,?,?,?)";
			// 3、获得PreparedStatement对象
			prep = conn.prepareStatement(sql);
			System.out.println(prep.toString());
			// 4、设置？的值
			prep.setString(1, shop.getTitle());
			prep.setString(2, shop.getHead());
			prep.setString(3, shop.getPrice());
			prep.setString(4, shop.getImgs());
			prep.setString(5, shop.getIntro());
			prep.setInt(6, shop.getNum());
			prep.setString(7, System.currentTimeMillis() + "");
			prep.setString(8, shop.getVideo());
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

	// 删除服务
	public Boolean deleteShopBySid(int sid) {
		Connection conn = null;
		PreparedStatement prep = null;
		try {
			// 1、联数据库
			conn = DBConnection.getConnection();
			// 2、SQL语句
			String sql = "delete from shop where sid=?";
			// 3、获得PreparedStatement对象
			prep = conn.prepareStatement(sql);
			// 4、设置？的值
			prep.setInt(1, sid);
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

	// 修改信息
	public boolean update(Shop shop) {
		Connection conn = null;
		PreparedStatement prep = null;
		try {
			conn = DBConnection.getConnection();
			String sql = "UPDATE shop SET title=?,price=?,imgs=?,intro=?,num=?,video=? WHERE sid=?";
			prep = conn.prepareStatement(sql);
			prep.setString(1, shop.getTitle());
			prep.setString(2, shop.getPrice());
			prep.setString(3, shop.getImgs());
			prep.setString(4, shop.getIntro());
			prep.setInt(5, shop.getNum());
			prep.setString(6, shop.getVideo());
			prep.setInt(7, shop.getSid());
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
