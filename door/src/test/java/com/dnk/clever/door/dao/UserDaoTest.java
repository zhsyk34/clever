package com.dnk.clever.door.dao;

import com.dnk.clever.door.entity.User;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Archimedes on 2016-08-09.
 */

public class UserDaoTest extends BaseTest {

	@Resource
	private UserDao userDao;

	@Test
	public void init() {
		System.out.println(userDao);
	}

	@Test
	public void save() throws Exception {
		System.out.println("save");
		User user = new User();
		user.setName("chen deng");
		user.setCreateTime(new Date());
		int result = userDao.save(user);
		System.out.println(result);
	}

	@Test
	public void find() throws Exception {
		List<User> users = userDao.findInterval(0, 2);
		users.forEach(user -> System.out.println(user));
	}

	@Test
	public void saves() throws Exception {
		List<User> users = new ArrayList<>();
		User user;
		for (int i = 1; i < 5; i++) {
			user = new User();
			user.setName("name" + i);
			users.add(user);
		}

		int result = userDao.saves(users);
		System.out.println(result);
	}

	@Test
	public void count() throws Exception {
		/*Map<String, Object> map = new HashMap<>();
		map.put("name like", "%a%");//..
		int count = userDao.count(map);

		System.out.println("count: " + count);

		map.clear();
		count = userDao.count(map);
		System.out.println("count: " + count);*/
	}

}