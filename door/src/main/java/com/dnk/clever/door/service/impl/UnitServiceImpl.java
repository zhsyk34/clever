package com.dnk.clever.door.service.impl;

import com.dnk.clever.door.dao.UnitDao;
import com.dnk.clever.door.entity.Unit;
import com.dnk.clever.door.service.UnitService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by Archimedes on 2016-08-15.
 */
@Service
public class UnitServiceImpl implements UnitService {

	@Resource
	private UnitDao unitDao;

	@Override
	public int save(Unit unit) {
		return unitDao.save(unit);
	}

	@Override
	public int update(Unit unit) {
		return unitDao.update(unit);
	}

	@Override
	public int delete(int[] ids) {
		return unitDao.deleteByIds(ids);
	}

	@Override
	public Unit find(int code) {
		List<Unit> list = unitDao.findList(null, code, -1, -1);
		return CollectionUtils.isEmpty(list) ? null : list.get(0);
	}

	@Override
	public List<Map> findList(String build, String unit, Integer code, int pageNo, int pageSize) {
		return unitDao.findMap(build, unit, code, (pageNo - 1) * pageSize, pageSize);
	}

	@Override
	public List<Map> findList(String build, String unit, int pageNo, int pageSize) {
		return this.findList(build, unit, null, pageNo, pageSize);
	}

	@Override
	public int countList(String build, String unit) {
		return unitDao.countMap(build, unit, null);
	}

	@Override
	public boolean exist(Integer id, int code) {
		Unit unit = this.find(code);
		return unit == null ? false : !unit.getId().equals(id);
	}
}
