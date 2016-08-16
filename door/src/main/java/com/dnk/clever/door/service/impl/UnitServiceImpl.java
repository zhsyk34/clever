package com.dnk.clever.door.service.impl;

import com.dnk.clever.door.dao.HouseDao;
import com.dnk.clever.door.dao.UnitDao;
import com.dnk.clever.door.entity.Unit;
import com.dnk.clever.door.service.UnitService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class UnitServiceImpl implements UnitService {

	@Resource
	private UnitDao unitDao;
	@Resource
	private HouseDao houseDao;

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
		List<Unit> list = unitDao.findList(null, null, code, -1, -1);
		return CollectionUtils.isEmpty(list) ? null : list.get(0);
	}

	@Override
	public List<Unit> findList(Integer buildId, String name, int pageNo, int pageSize) {
		return unitDao.findList(buildId, name, null, (pageNo - 1) * pageSize, pageSize);
	}

	@Override
	public List<Map> findList(String build, String unit, int pageNo, int pageSize) {
		return unitDao.findMap(build, unit, null, (pageNo - 1) * pageSize, pageSize);
	}

	@Override
	public int count(String build, String unit) {
		return unitDao.countMap(build, unit, null);
	}

	@Override
	public boolean exist(Integer id, int code) {
		Unit unit = this.find(code);
		return unit != null && !unit.getId().equals(id);
	}

	//TODO gateway
	@Override
	public boolean relate(int id) {
		return !CollectionUtils.isEmpty(houseDao.findList(id, null, null, -1, -1));
	}

	@Override
	public boolean relate(int[] ids) {
		for (int id : ids) {
			if (this.relate(id)) {
				return true;
			}
		}
		return false;
	}
}
