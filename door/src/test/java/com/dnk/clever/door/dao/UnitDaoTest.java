package com.dnk.clever.door.dao;

import com.dnk.clever.door.entity.Unit;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * Created by Archimedes on 2016-08-13.
 */
public class UnitDaoTest extends BaseTest {

	@SuppressWarnings("SpringJavaAutowiringInspection")
	@Resource
	private UnitDao unitDao;

	@Test
	public void add() {
		for (int i = 0; i < 6; i++) {
			Unit unit = new Unit(0, 1, "单元" + i, 90 + i, null, null);
			unitDao.save(unit);
		}
	}

	@Test
	public void findList() throws Exception {
//		unitDao.findList(null, null, -1, -1).forEach(map -> JSONParse.toJSON(map));
//		unitDao.findList(null, null, -1, -1).forEach(map -> JSONParse.toJSON(map));
//		unitDao.findList("1", null, -1, -1).forEach(map -> JSONParse.toJSON(map));
//		unitDao.findList("1", -1, "9", 1, 1).forEach(map -> JSONParse.toJSON(map));
//		unitDao.findList(null, null, 90, -1, -1).forEach(map -> JSONParse.toJSON(map));
	}

	@Test
	public void countList() throws Exception {
//		System.out.println(unitDao.countList(null, null, 90));
//		List<Unit> list = unitDao.findList(null, -1, -1, -1);
//		list.forEach(JSONParse::toJSON);
	}

}