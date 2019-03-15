package com.wangyuan.service;

import java.util.List;

import com.wangyuan.dao.CarDao;
import com.wangyuan.dao.HotDao;
import com.wangyuan.entity.Car;
import com.wangyuan.entity.Hot;

public class CarService {
	CarDao dao = new CarDao();

	public List<Car> getCars(int uid) {
		return dao.getCars(uid);
	}

	public boolean save(int uid, int sid) {
		return dao.save(uid, sid);
	}
}
