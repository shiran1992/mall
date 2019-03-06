package com.memo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.memo.entity.Explore;
import com.memo.entity.Expend;
import com.memo.entity.Income;
import com.memo.util.DBConnection;

public class ExploreDao {

	//获取所有的列表
	public List<Explore> getAllExplores() {
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		List<Explore> explores = new ArrayList<Explore>();

		try {
			conn = DBConnection.getConnection();
			String sql = "select * from explore order by eid desc";
			prep = conn.prepareStatement(sql);
			rs = prep.executeQuery();

			while (rs.next()) {
				Explore e = new Explore();
				e.setEid(rs.getInt("eid"));
				e.setTitle(rs.getString("title"));
				e.setUrl(rs.getString("url"));
				e.setImg(rs.getString("img"));
				explores.add(e);
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

		return explores;
	}
}
