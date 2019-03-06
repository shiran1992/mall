package com.memo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.memo.entity.Memo;
import com.memo.entity.Revenue;
import com.memo.entity.Typed;
import com.memo.entity.User;
import com.memo.util.DBConnection;

public class TypedDao {

	// 保存信息
	public boolean saveInfo(Typed t) {
		Connection conn = null;
		PreparedStatement prep = null;
		try {
			// 1、联数据库
			conn = DBConnection.getConnection();
			// 2、SQL语句
			String sql = "insert into type(name, type, uid, dateTime) values(?,?,?,?)";
			// 3、获得PreparedStatement对象
			prep = conn.prepareStatement(sql);
			// 4、设置？的值
			prep.setString(1, t.getName());
			prep.setInt(2, t.getType());
			prep.setInt(3, t.getUser().getUid());
			prep.setString(4, t.getDateTime());
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

	// 通过uid获取列表
	public List<Typed> getTypesByUid(int uid) {
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		List<Typed> types = new ArrayList<Typed>();

		try {
			conn = DBConnection.getConnection();
			String sql = "select * from type where uid=? order by tid desc";
			prep = conn.prepareStatement(sql);
			prep.setInt(1, uid);
			rs = prep.executeQuery();

			while (rs.next()) {
				Typed t = new Typed();
				t.setTid(rs.getInt("tid"));
				t.setName(rs.getString("name"));
				t.setType(rs.getInt("type"));
				t.setUser(new UserDao().getUserByUid(rs.getInt("uid")));
				types.add(t);
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

		return types;
	}

	// 通过tid获type
	public Typed getTypeByTid(int tid) {
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		Typed t = new Typed();

		try {
			conn = DBConnection.getConnection();
			String sql = "select * from type where tid=?";
			prep = conn.prepareStatement(sql);
			prep.setInt(1, tid);
			rs = prep.executeQuery();
			while (rs.next()) {
				t.setTid(rs.getInt("tid"));
				t.setName(rs.getString("name"));
				t.setType(rs.getInt("type"));
				t.setDateTime(rs.getString("dateTime"));
				t.setUser(new UserDao().getUserByUid(rs.getInt("uid")));
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

		return t;
	}

}
