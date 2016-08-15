package com.dnk.clever.door.service.impl;

import com.dnk.clever.door.dao.BuildDao;
import com.dnk.clever.door.entity.Build;
import com.dnk.clever.door.service.BuildService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
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
	public int update(Build build) {
		return buildDao.update(build);
	}

	//TODO 查询关联
	@Override
	public int delete(int[] ids) {
		return buildDao.deleteByIds(ids);
	}

	@Override
	public Build find(int code) {
		List<Build> list = buildDao.findList(null, code, -1, -1);
		return CollectionUtils.isEmpty(list) ? null : list.get(0);
	}

	@Override
	public List<Build> findList(String name, Integer code, int pageNo, int pageSize) {
		return buildDao.findList(name, code, (pageNo - 1) * pageSize, pageSize);
	}

	@Override
	public List<Build> findList(String name, int pageNo, int pageSize) {
		return this.findList(name, null, pageNo, pageSize);
	}

	@Override
	public int countList(String name) {
		return buildDao.countList(name, null);
	}

	@Override
	public boolean exist(Integer id, int code) {
		Build build = this.find(code);
		return build == null ? false : !build.getId().equals(id);
	}

}
