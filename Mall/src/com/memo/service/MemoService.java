package com.memo.service;

import java.util.List;

import com.memo.dao.ExpendDao;
import com.memo.dao.IncomeDao;
import com.memo.dao.MemoDao;
import com.memo.entity.Expend;
import com.memo.entity.Income;
import com.memo.entity.Memo;

public class MemoService {

	MemoDao dao = new MemoDao();

	// 通过uid获取便签信息
	public List<Memo> getMemosByUid(int uid) {
		return dao.getMemosByUid(uid);
	}

	//获取所有变签
	public List<Memo> getAllMemos() {
		return dao.getAllMemos();
	}
	
	// 保存收入信息
	public boolean saveMemo(Memo memo) {
		return dao.saveMemo(memo);
	}
}
