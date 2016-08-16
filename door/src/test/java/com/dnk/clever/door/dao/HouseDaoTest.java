package com.dnk.clever.door.dao;

import com.dnk.clever.door.entity.House;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Archimedes on 2016-08-15.
 */
public class HouseDaoTest extends BaseTest {

	@SuppressWarnings("SpringJavaAutowiringInspection")
	@Resource
	private HouseDao houseDao;

	@Test
	public void add() {
		List<House> houses = new ArrayList<>();
		for (int i = 1; i < 6; i++) {
			House house = new House(null, 2, "套房" + i, 800 + i, null, null);
			houses.add(house);
		}
		houseDao.saves(houses);
	}

	@Test
	public void findList() throws Exception {
//		houseDao.findList(null, null, null, -1, -1, -1).forEach(map -> JSONParse.toJSON(map));
//		houseDao.findList(null, null, null, 805, -1, -1).forEach(map -> JSONParse.toJSON(map));
//		houseDao.findList(null, "2", "3", -1, -1, -1).forEach(JSONParse::toJSON);
//		houseDao.findList(null, "2", null, -1, 1, 1).forEach(JSONParse::toJSON);
	}

	@Test
	public void countList() throws Exception {
//		System.out.println(houseDao.countList(null, null, null, -1));
//		System.out.println(houseDao.countList(null, null, null, 801));
	}

}