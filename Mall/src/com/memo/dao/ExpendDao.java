package com.memo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.memo.entity.Expend;
import com.memo.entity.Income;
import com.memo.util.DBConnection;

public class ExpendDao {

	// 通过uid获取支出信息
	public List<Expend> getExpendsByUid(int uid) {
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		List<Expend> expends = new ArrayList<Expend>();

		try {
			conn = DBConnection.getConnection();
			String sql = "select * from expend where uid=? order by eid desc";
			prep = conn.prepareStatement(sql);
			prep.setInt(1, uid);
			rs = prep.executeQuery();

			while (rs.next()) {
				Expend expend = new Expend();
				expend.setEid(rs.getInt("eid"));
				expend.setUser(new UserDao().getUserByUid(rs.getInt("uid")));
				expend.setType(rs.getString("type"));
				expend.setAddress(rs.getString("address"));
				expend.setNote(rs.getString("note"));
				expend.setAccount(rs.getString("account"));
				expend.setOuttime(rs.getString("outtime"));
				expends.add(expend);
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

		return expends;
	}
	
	//获取所有的支出列表
	public List<Expend> getAllExpends() {
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		List<Expend> expends = new ArrayList<Expend>();

		try {
			conn = DBConnection.getConnection();
			String sql = "select * from expend order by eid desc";
			prep = conn.prepareStatement(sql);
			rs = prep.executeQuery();

			while (rs.next()) {
				Expend expend = new Expend();
				expend.setEid(rs.getInt("eid"));
				expend.setUser(new UserDao().getUserByUid(rs.getInt("uid")));
				expend.setType(rs.getString("type"));
				expend.setAddress(rs.getString("address"));
				expend.setNote(rs.getString("note"));
				expend.setAccount(rs.getString("account"));
				expend.setOuttime(rs.getString("outtime"));
				expends.add(expend);
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

		return expends;
	}


	// 保存
	public boolean saveExpend(Expend expend) {
		Connection conn = null;
		PreparedStatement prep = null;
		try {
			// 1、联数据库
			conn = DBConnection.getConnection();
			// 2、SQL语句
			String sql = "insert into expend(uid,type,address,account,note,outtime) "
					+ " values(?,?,?,?,?,?)";
			// 3、获得PreparedStatement对象
			prep = conn.prepareStatement(sql);
			// 4、设置？的值
			prep.setInt(1, expend.getUser().getUid());
			prep.setString(2, expend.getType());
			prep.setString(3, expend.getAddress());
			prep.setString(4, expend.getAccount());
			prep.setString(5, expend.getNote());
			prep.setString(6, expend.getOuttime());
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
}
