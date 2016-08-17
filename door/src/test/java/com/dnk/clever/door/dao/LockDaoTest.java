package com.dnk.clever.door.dao;

import com.dnk.clever.door.entity.Lock;
import com.dnk.clever.door.util.JSONParse;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

public class LockDaoTest extends BaseTest {

	@SuppressWarnings("SpringJavaAutowiringInspection")
	@Resource
	private LockDao lockDao;

	@Test
	public void save() {
		Lock lock = new Lock(0, 1, null, "lock1", 1, 11, null, null);
		lockDao.save(lock);
	}

	@Test
	public void saves() {
		List<Lock> locks = new ArrayList<>();
		for (int i = 1; i < 6; i++) {
			Lock lock = new Lock(-1, 1, null, "Lock" + i, 7 * i, 20 + i, null, null);
			locks.add(lock);
		}
		lockDao.saves(locks);
	}

	@Test
	public void update() {
		Lock lock = lockDao.findById(1);
		JSONParse.toJSON(lock);
		lock.setName("门锁2");
		lockDao.update(lock);
	}

	@Test
	public void find() {
//		lockDao.findList(1L, null, null, 0, 0).forEach(JSONParse::toJSON);
//		lockDao.findList(0L, null, "8", 0, 0).forEach(JSONParse::toJSON);
//		lockDao.findMap(null, null, null, "8", 0, 0).forEach(JSONParse::toJSON);
		System.out.println(lockDao.countMap(null, null, null, "8"));
	}
}