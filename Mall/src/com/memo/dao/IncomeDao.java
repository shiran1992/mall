package com.memo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.memo.entity.Income;
import com.memo.util.DBConnection;

public class IncomeDao {

	// 通过uid获取收入信息
	public List<Income> getIncomesByUid(int uid) {
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		List<Income> incomes = new ArrayList<Income>();

		try {
			conn = DBConnection.getConnection();
			String sql = "select * from income where uid=? order by inid desc";
			prep = conn.prepareStatement(sql);
			prep.setInt(1, uid);
			rs = prep.executeQuery();

			while (rs.next()) {
				Income income = new Income();
				income.setInid(rs.getInt("inid"));
				income.setUser(new UserDao().getUserByUid(rs.getInt("uid")));
				income.setType(rs.getString("type"));
				income.setAddress(rs.getString("address"));
				income.setNote(rs.getString("note"));
				income.setAccount(rs.getString("account"));
				income.setIntime(rs.getString("intime"));
				incomes.add(income);
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

		return incomes;
	}
	
	//查询所有收入信息
	public List<Income> getAllIncomes() {
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		List<Income> incomes = new ArrayList<Income>();

		try {
			conn = DBConnection.getConnection();
			String sql = "select * from income order by inid desc";
			prep = conn.prepareStatement(sql);
			rs = prep.executeQuery();

			while (rs.next()) {
				Income income = new Income();
				income.setInid(rs.getInt("inid"));
				income.setUser(new UserDao().getUserByUid(rs.getInt("uid")));
				income.setType(rs.getString("type"));
				income.setAddress(rs.getString("address"));
				income.setNote(rs.getString("note"));
				income.setAccount(rs.getString("account"));
				income.setIntime(rs.getString("intime"));
				incomes.add(income);
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

		return incomes;
	}

	// 保存
	public boolean saveIncome(Income income) {
		Connection conn = null;
		PreparedStatement prep = null;
		try {
			// 1、联数据库
			conn = DBConnection.getConnection();
			// 2、SQL语句
			String sql = "insert into income(uid,type,address,account,note,intime) "
					+ " values(?,?,?,?,?,?)";
			// 3、获得PreparedStatement对象
			prep = conn.prepareStatement(sql);
			// 4、设置？的值
			prep.setInt(1, income.getUser().getUid());
			prep.setString(2, income.getType());
			prep.setString(3, income.getAddress());
			prep.setString(4, income.getAccount());
			prep.setString(5, income.getNote());
			prep.setString(6, income.getIntime());
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
