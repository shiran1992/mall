package com.memo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.memo.entity.Expend;
import com.memo.entity.Income;
import com.memo.entity.Memo;
import com.memo.util.DBConnection;

public class MemoDao {

	// 通过uid获取支出信息
	public List<Memo> getMemosByUid(int uid) {
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		List<Memo> memos = new ArrayList<Memo>();

		try {
			conn = DBConnection.getConnection();
			String sql = "select * from memo where uid=? order by mid desc";
			prep = conn.prepareStatement(sql);
			prep.setInt(1, uid);
			rs = prep.executeQuery();

			while (rs.next()) {
				Memo memo = new Memo();
				memo.setMid(rs.getInt("mid"));
				memo.setContent(rs.getString("content"));
				memo.setMtime(rs.getString("mtime"));
				memo.setUser(new UserDao().getUserByUid(rs.getInt("uid")));
				memos.add(memo);
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

		return memos;
	}
	
	//获取所有变签
	public List<Memo> getAllMemos() {
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		List<Memo> memos = new ArrayList<Memo>();

		try {
			conn = DBConnection.getConnection();
			String sql = "select * from memo order by mid desc";
			prep = conn.prepareStatement(sql);
			rs = prep.executeQuery();

			while (rs.next()) {
				Memo memo = new Memo();
				memo.setMid(rs.getInt("mid"));
				memo.setContent(rs.getString("content"));
				memo.setMtime(rs.getString("mtime"));
				memo.setUser(new UserDao().getUserByUid(rs.getInt("uid")));
				memos.add(memo);
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

		return memos;
	}

	// 保存
	public boolean saveMemo(Memo memo) {
		Connection conn = null;
		PreparedStatement prep = null;
		try {
			// 1、联数据库
			conn = DBConnection.getConnection();
			// 2、SQL语句
			String sql = "insert into memo(uid,content,mtime) "
					+ " values(?,?,?)";
			// 3、获得PreparedStatement对象
			prep = conn.prepareStatement(sql);
			// 4、设置？的值
			prep.setInt(1, memo.getUser().getUid());
			prep.setString(2, memo.getContent());
			prep.setString(3, memo.getMtime());
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
