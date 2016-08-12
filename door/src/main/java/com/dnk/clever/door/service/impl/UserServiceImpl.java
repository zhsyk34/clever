package com.dnk.clever.door.service.impl;

import com.dnk.clever.door.dao.UserDao;
import com.dnk.clever.door.entity.User;
import com.dnk.clever.door.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

/**
 * Created by Archimedes on 2016-08-09.
 */
@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserDao userDao;

	@Override
	public int save(User user) {
		return userDao.save(user);
	}

	@Override
	public int saves(Collection<User> users) {
		return userDao.saves(users);
	}

	@Override
	public int deleteById(int id) {
		return userDao.deleteById(id);
	}

	@Override
	public int deleteByEntity(User user) {
		return userDao.deleteByEntity(user);
	}

	@Override
	public int deleteByIds(int[] ids) {
		return userDao.deleteByIds(ids);
	}

	@Override
	public int deleteByEntities(Collection<User> users) {
		return userDao.deleteByEntities(users);
	}

	@Override
	public int update(User user) {
		return userDao.update(user);
	}

	@Override
	public User findById(int id) {
		return userDao.findById(id);
	}

	@Override
	public List<User> findAll() {
		return userDao.findAll();
	}

	@Override
	public List<User> findInterval(int offset, int limit) {
		return userDao.findInterval(offset, limit);
	}

	@Override
	public int count() {
		return userDao.count();
	}
}
