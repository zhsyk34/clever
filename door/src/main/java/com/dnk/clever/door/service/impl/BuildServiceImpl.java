package com.dnk.clever.door.service.impl;

import com.dnk.clever.door.dao.BuildDao;
import com.dnk.clever.door.entity.Build;
import com.dnk.clever.door.service.BuildService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

/**
 * Created by Archimedes on 2016-08-12.
 */
@Service
public class BuildServiceImpl implements BuildService {

	@Resource
	private BuildDao buildDao;

	@Override
	public int save(Build build) {
		return buildDao.save(build);
	}

	@Override
	public int saves(Collection<Build> builds) {
		return buildDao.saves(builds);
	}

	@Override
	public int deleteById(int id) {
		return buildDao.deleteById(id);
	}

	@Override
	public int deleteByEntity(Build build) {
		return buildDao.deleteByEntity(build);
	}

	@Override
	public int deleteByIds(int[] ids) {
		return buildDao.deleteByIds(ids);
	}

	@Override
	public int deleteByEntities(Collection<Build> builds) {
		return buildDao.deleteByEntities(builds);
	}

	@Override
	public int update(Build build) {
		return buildDao.update(build);
	}

	@Override
	public Build findById(int id) {
		return buildDao.findById(id);
	}

	@Override
	public List<Build> findAll() {
		return buildDao.findAll();
	}

	@Override
	public List<Build> findInterval(int offset, int limit) {
		return buildDao.findInterval(offset, limit);
	}

	@Override
	public int count() {
		return buildDao.count();
	}
}
