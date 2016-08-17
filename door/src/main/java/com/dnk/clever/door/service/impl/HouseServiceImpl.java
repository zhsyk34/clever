package com.dnk.clever.door.service.impl;

import com.dnk.clever.door.dao.HouseDao;
import com.dnk.clever.door.entity.House;
import com.dnk.clever.door.service.HouseService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class HouseServiceImpl implements HouseService {

	@Resource
	private HouseDao houseDao;

	@Override
	public int save(House house) {
		return houseDao.save(house);
	}

	@Override
	public int update(House house) {
		return houseDao.update(house);
	}

	@Override
	public int delete(long[] ids) {
		return houseDao.deleteByIds(ids);
	}

	@Override
	public House find(long code) {
		List<House> list = houseDao.findList(null, null, code, -1, -1);
		return CollectionUtils.isEmpty(list) ? null : list.get(0);
	}

	@Override
	public List<House> findList(Long unitId, String name, int pageNo, int pageSize) {
		return houseDao.findList(unitId, name, null, (pageNo - 1) * pageSize, pageSize);
	}

	@Override
	public List<Map> findList(String build, String unit, String house, int pageNo, int pageSize) {
		return houseDao.findMap(build, unit, house, null, (pageNo - 1) * pageSize, pageSize);
	}

	@Override
	public int count(String build, String unit, String house) {
		return houseDao.countMap(build, unit, house, null);
	}

	@Override
	public boolean exist(long id, long code) {
		House house = this.find(code);
		return house != null && house.getId() != id;
	}

	//TODO locks
	@Override
	public boolean relate(long id) {
		return false;
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
