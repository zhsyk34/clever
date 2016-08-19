package com.dnk.clever.door.service.impl;

import com.dnk.clever.door.dao.GatewayDao;
import com.dnk.clever.door.entity.Gateway;
import com.dnk.clever.door.service.GatewayService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class GatewayServiceImpl implements GatewayService {

	@Resource
	private GatewayDao gatewayDao;

	@Override
	public int save(Gateway gateway) {
		//TODO findSNByUdid();
		gateway.setSn("0-0-0-0");//FIXME
		return gatewayDao.save(gateway);
	}

	@Override
	public int update(Gateway gateway) {
		return gatewayDao.update(gateway);
	}

	@Override
	public int delete(long[] ids) {
		return gatewayDao.deleteByIds(ids);
	}

	@Override
	public Gateway find(long unitId) {
		List<Gateway> list = gatewayDao.findList(unitId, null, null, -1, -1);
		return CollectionUtils.isEmpty(list) ? null : list.get(0);
	}

	@Override
	public Gateway find(String udid) {
		List<Gateway> list = gatewayDao.findList(null, udid, null, -1, -1);
		return CollectionUtils.isEmpty(list) ? null : list.get(0);
	}

	@Override
	public List<Gateway> findList(Long unitId, String udid, String name, int pageNo, int pageSize) {
		return gatewayDao.findList(unitId, udid, name, (pageNo - 1) * pageSize, pageSize);
	}

	@Override
	public List<Map> findList(String build, String unit, String name, int pageNo, int pageSize) {
		return gatewayDao.findMap(build, unit, name, (pageNo - 1) * pageSize, pageSize);
	}

	@Override
	public int count(String build, String unit, String name) {
		return gatewayDao.countMap(build, unit, name);
	}

	@Override
	public boolean relate(long id) {
		//TODO
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
