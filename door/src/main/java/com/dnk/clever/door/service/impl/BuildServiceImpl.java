package com.dnk.clever.door.service.impl;

import com.dnk.clever.door.dao.BuildDao;
import com.dnk.clever.door.dao.UnitDao;
import com.dnk.clever.door.entity.Build;
import com.dnk.clever.door.service.BuildService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BuildServiceImpl implements BuildService {

	@Resource
	private BuildDao buildDao;
	@Resource
	private UnitDao unitDao;

	@Override
	public int save(Build build) {
		return buildDao.save(build);
	}

	@Override
	public int update(Build build) {
		return buildDao.update(build);
	}

	@Override
	public int delete(long[] ids) {
		return buildDao.deleteByIds(ids);
	}

	@Override
	public Build find(long code) {
		List<Build> list = buildDao.findList(null, code, -1, -1);
		return CollectionUtils.isEmpty(list) ? null : list.get(0);
	}

	@Override
	public List<Build> findList(String name, int pageNo, int pageSize) {
		return buildDao.findList(name, null, (pageNo - 1) * pageSize, pageSize);
	}

	@Override
	public int count(String name) {
		return buildDao.countList(name, null);
	}

	@Override
	public boolean exist(long id, long code) {
		Build build = this.find(code);
		return build != null && build.getId() != id;
	}

	@Override
	public boolean relate(long id) {
		return !CollectionUtils.isEmpty(unitDao.findList(id, null, null, -1, -1));
	}

	@Override
	public boolean relate(long[] ids) {
		for (long id : ids) {
			if (this.relate(id)) {
				return true;
			}
		}
		return false;
	}

}
