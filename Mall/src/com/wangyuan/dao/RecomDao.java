package com.wangyuan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wangyuan.entity.Recom;
import com.wangyuan.util.Application;
import com.wangyuan.util.DBConnection;

public class RecomDao {

	// 通过id来搜索
	public Recom getRecomByID(int rid) {
		Connection conn = null;
		ResultSet rs = null;
		Recom c = new Recom();
		PreparedStatement prep = null;
		try {
			conn = DBConnection.getConnection();
			String sql = "select * from recom where rid=?";
			prep = conn.prepareStatement(sql);
			prep.setInt(1, rid);
			rs = prep.executeQuery();

			if (rs.next()) {
				c.setRid(rs.getInt("rid"));
				c.setTitle(rs.getString("title"));
				c.setImg(rs.getString("img"));
				c.setShop(new ShopDao().getShopBySid(rs.getInt("sid")));
			} else {
				return null;
			}
		} catch (Exception e) {

			e.printStackTrace();
		}

		try {
			if (conn != null)
				conn.close();
			if (prep != null)
				prep.close();
			if (rs != null)
				rs.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return c;
	}

	// 获取所有的
	public List<Recom> getRecomByPage(int page) {
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		List<Recom> recoms = new ArrayList<Recom>();
		try {
			// 1、联数据库
			conn = DBConnection.getConnection();
			// 2、SQL语句
			String sql = "select * from recom order by rid desc limit ?,?";
			// 3、获得PreparedStatement对象
			prep = conn.prepareStatement(sql);
			prep.setInt(1, Application.cleaners_pagecount * page);
			prep.setInt(2, Application.cleaners_pagecount);
			// 5、执行SQL语句
			rs = prep.executeQuery();
			// 6、处理查询结果，
			while (rs.next()) {
				// 对每一条记录，==》转换为一个新的活动对象
				Recom c = new Recom();
				c.setRid(rs.getInt("rid"));
				c.setTitle(rs.getString("title"));
				c.setImg(rs.getString("img"));
				c.setShop(new ShopDao().getShopBySid(rs.getInt("sid")));
				recoms.add(c);
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
		return recoms;
	}

	public List<Recom> getRecoms() {
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		List<Recom> recoms = new ArrayList<Recom>();
		try {
			// 1、联数据库
			conn = DBConnection.getConnection();
			// 2、SQL语句
			String sql = "select * from recom";
			// 3、获得PreparedStatement对象
			prep = conn.prepareStatement(sql);
			// 5、执行SQL语句
			rs = prep.executeQuery();
			// 6、处理查询结果，
			while (rs.next()) {
				// 对每一条记录，==》转换为一个新的活动对象
				Recom c = new Recom();
				c.setRid(rs.getInt("rid"));
				c.setTitle(rs.getString("title"));
				c.setImg(rs.getString("img"));
				c.setShop(new ShopDao().getShopBySid(rs.getInt("sid")));
				recoms.add(c);
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
		return recoms;
	}

	// 创建服务
	public boolean save(Recom recom) {
		Connection conn = null;
		PreparedStatement prep = null;
		try {
			// 1、联数据库
			conn = DBConnection.getConnection();
			// 2、SQL语句
			String sql = "insert into recom("
					+ "title,img,sid) "
					+ " values(?,?,?)";
			// 3、获得PreparedStatement对象
			prep = conn.prepareStatement(sql);
			// 4、设置？的值
			prep.setString(1, recom.getTitle());
			prep.setString(2, recom.getImg());
			prep.setInt(3, recom.getShop().getSid());
			// 5、执行SQL语句
			prep.executeUpdate();
		} catch (Exception e) {
			// 一定要处理异常，异常的信息要存在日志文件
			// 转化为你应用程序的异常，再抛出
			throw new RuntimeException(e);
			//return false;
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

	// 删除员工
	public Boolean deleteRecomByRid(int rid) {
		Connection conn = null;
		PreparedStatement prep = null;
		try {
			// 1、联数据库
			conn = DBConnection.getConnection();
			// 2、SQL语句
			String sql = "delete from recom where rid=?";
			// 3、获得PreparedStatement对象
			prep = conn.prepareStatement(sql);
			// 4、设置？的值
			prep.setInt(1, rid);
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

	// 修改员工信息
	public boolean update(Recom recom) {
		Connection conn = null;
		PreparedStatement prep = null;
		try {
			conn = DBConnection.getConnection();
			String sql = "UPDATE recom SET title=?,img=?,sid=? WHERE rid=?";
			if (recom.getImg() == "") {
				sql = "UPDATE recom SET title=?,sid=? WHERE rid=?";
				prep = conn.prepareStatement(sql);
				prep.setString(1, recom.getTitle());
				prep.setInt(2, recom.getShop().getSid());
				prep.setInt(3, recom.getRid());
				prep.executeUpdate();
			} else {
				prep = conn.prepareStatement(sql);
				prep.setString(1, recom.getTitle());
				prep.setString(2, recom.getImg());
				prep.setInt(3, recom.getShop().getSid());
				prep.setInt(4, recom.getRid());
				prep.executeUpdate();
			}

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
