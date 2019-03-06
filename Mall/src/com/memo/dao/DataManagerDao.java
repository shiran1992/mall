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

public class DataManagerDao {

	// 通过uid获取支出
	public String getOutByUid(int uid) {
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		Long out = 0L;
		try {
			conn = DBConnection.getConnection();
			String sql = "select * from expend where uid=? order by eid desc";
			prep = conn.prepareStatement(sql);
			prep.setInt(1, uid);
			rs = prep.executeQuery();

			while (rs.next()) {
				String a = rs.getString("account");
				Long acount = Long.parseLong(a);
				out = out + acount;
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

		return out + "";
	}

	// 通过uid获取支出
	public String getInByUid(int uid) {
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		Long in = 0L;
		try {
			conn = DBConnection.getConnection();
			String sql = "select * from income where uid=? order by inid desc";
			prep = conn.prepareStatement(sql);
			prep.setInt(1, uid);
			rs = prep.executeQuery();

			while (rs.next()) {
				String a = rs.getString("account");
				long acount = Long.parseLong(a);
				in = in + acount;
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

		return in + "";
	}
}
