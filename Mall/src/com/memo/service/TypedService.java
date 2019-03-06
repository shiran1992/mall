package com.memo.service;

import java.util.List;

import com.memo.dao.TypedDao;
import com.memo.entity.Typed;

public class TypedService {

	TypedDao dao = new TypedDao();

	// 保存信息
	public boolean saveInfo(Typed t) {
		return dao.saveInfo(t);
	}

	// 通过uid获取列表
	public List<Typed> getTypesByUid(int uid) {
		return dao.getTypesByUid(uid);
	}
}
