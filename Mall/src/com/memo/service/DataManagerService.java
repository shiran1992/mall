package com.memo.service;

import java.util.List;

import com.memo.dao.DataManagerDao;
import com.memo.dao.ExpendDao;
import com.memo.dao.IncomeDao;
import com.memo.entity.Expend;
import com.memo.entity.Income;

public class DataManagerService {

	DataManagerDao dao = new DataManagerDao();
	
	// 通过uid获取支出
	public String getOutByUid(int uid) {
		return dao.getOutByUid(uid);
	}

	// 通过uid获取收入
	public String getInByUid(int uid) {
		return dao.getInByUid(uid);
	}
}
