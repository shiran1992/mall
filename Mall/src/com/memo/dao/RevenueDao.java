package com.memo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.memo.entity.Revenue;
import com.memo.entity.User;
import com.memo.util.DBConnection;

public class RevenueDao {

	// 保存信息
	public boolean saveInfo(Revenue r) {
		Connection conn = null;
		PreparedStatement prep = null;
		try {
			// 1、联数据库
			conn = DBConnection.getConnection();
			// 2、SQL语句
			String sql = "insert into revenue(acc, time, uid, tid) values(?,?,?,?)";
			// 3、获得PreparedStatement对象
			prep = conn.prepareStatement(sql);
			// 4、设置？的值
			prep.setString(1, r.getAccount());
			prep.setString(2, r.getDateTime());
			prep.setInt(3, r.getUser().getUid());
			prep.setInt(4, r.getType().getTid());
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

	// 获取今日詹丹
	public List<Revenue> getRevenueToday(int uid) {
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs;
		List<Revenue> rList = new ArrayList<Revenue>();
		Date now = new Date();
		int nowY = now.getYear();
		int nowM = now.getMonth();
		int nowD = now.getDate();
		try {
			conn = DBConnection.getConnection();
			String sql = "select * from revenue where uid=? order by rid desc";
			prep = conn.prepareStatement(sql);
			prep.setInt(1, uid);
			rs = prep.executeQuery();
			while (rs.next()) {
				Revenue r = new Revenue();
				r.setRid(rs.getInt("rid"));
				r.setAccount(rs.getString("acc"));
				r.setDateTime(rs.getString("time"));
				r.setUser(null);
				r.setType(new TypedDao().getTypeByTid(rs.getInt("tid")));
				long stamp = Long.parseLong(r.getDateTime());
				Date time = new Date(stamp);
				int y = time.getYear();
				int m = time.getMonth();
				int d = time.getDate();
				if (y == nowY && m == nowM && d == nowD) {
					rList.add(r);
				}
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
		return rList;
	}

	// 获取本月费用
	public List<Revenue> getMonthRevenue(int uid) {
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs;
		List<Revenue> rList = new ArrayList<Revenue>();
		Date now = new Date();
		int nowY = now.getYear();
		int nowM = now.getMonth();
		try {
			conn = DBConnection.getConnection();
			String sql = "select * from revenue where uid=? order by rid desc";
			prep = conn.prepareStatement(sql);
			prep.setInt(1, uid);
			rs = prep.executeQuery();
			while (rs.next()) {
				Revenue r = new Revenue();
				r.setRid(rs.getInt("rid"));
				r.setAccount(rs.getString("acc"));
				r.setDateTime(rs.getString("time"));
				r.setUser(null);
				r.setType(new TypedDao().getTypeByTid(rs.getInt("tid")));
				long stamp = Long.parseLong(r.getDateTime());
				Date time = new Date(stamp);
				int y = time.getYear();
				int m = time.getMonth();
				if (y == nowY && m == nowM) {
					rList.add(r);
				}
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
		return rList;
	}

	// 获取本月费用
	public List<Revenue> getAllRevByUid(int uid) {
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs;
		List<Revenue> rList = new ArrayList<Revenue>();
		try {
			conn = DBConnection.getConnection();
			String sql = "select * from revenue where uid=? order by rid desc";
			prep = conn.prepareStatement(sql);
			prep.setInt(1, uid);
			rs = prep.executeQuery();
			while (rs.next()) {
				Revenue r = new Revenue();
				r.setRid(rs.getInt("rid"));
				r.setAccount(rs.getString("acc"));
				r.setDateTime(rs.getString("time"));
				r.setUser(null);
				r.setType(new TypedDao().getTypeByTid(rs.getInt("tid")));
				rList.add(r);
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
		return rList;
	}

	// 获取本月费用
	public List<Revenue> getWeekRevByUid(int uid) {
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs;
		List<Revenue> rList = new ArrayList<Revenue>();
		try {
			conn = DBConnection.getConnection();
			String sql = "select * from revenue where uid=? order by rid desc";
			prep = conn.prepareStatement(sql);
			prep.setInt(1, uid);
			rs = prep.executeQuery();
			while (rs.next()) {
				Revenue r = new Revenue();
				r.setRid(rs.getInt("rid"));
				r.setAccount(rs.getString("acc"));
				r.setDateTime(rs.getString("time"));
				r.setUser(null);
				r.setType(new TypedDao().getTypeByTid(rs.getInt("tid")));
				if(new TypedDao().getTypeByTid(rs.getInt("tid")).getType() == 0) {
					rList.add(r);
				}
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
		return rList;
	}
	
	// 获取本月费用
	public List<Revenue> getWeekInRevByUid(int uid) {
			Connection conn = null;
			PreparedStatement prep = null;
			ResultSet rs;
			List<Revenue> rList = new ArrayList<Revenue>();
			try {
				conn = DBConnection.getConnection();
				String sql = "select * from revenue where uid=? order by rid desc";
				prep = conn.prepareStatement(sql);
				prep.setInt(1, uid);
				rs = prep.executeQuery();
				while (rs.next()) {
					Revenue r = new Revenue();
					r.setRid(rs.getInt("rid"));
					r.setAccount(rs.getString("acc"));
					r.setDateTime(rs.getString("time"));
					r.setUser(null);
					r.setType(new TypedDao().getTypeByTid(rs.getInt("tid")));
					if(new TypedDao().getTypeByTid(rs.getInt("tid")).getType() == 1) {
						rList.add(r);
					}
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
			return rList;
		}

}
