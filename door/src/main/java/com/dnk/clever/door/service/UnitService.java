package com.dnk.clever.door.service;

import com.dnk.clever.door.entity.Unit;

import java.util.List;
import java.util.Map;

public interface UnitService {

	int save(Unit unit);

	int update(Unit unit);

	int delete(int[] ids);

	Unit find(int code);

	List<Unit> findList(Integer buildId, String name, int pageNo, int pageSize);

	List<Map> findList(String build, String unit, int pageNo, int pageSize);

	int count(String build, String unit);

	boolean exist(Integer id, int code);

	boolean relate(int id);

	boolean relate(int[] ids);
}
