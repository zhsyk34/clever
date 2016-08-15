package com.dnk.clever.door.service;

import com.dnk.clever.door.entity.Unit;

import java.util.List;
import java.util.Map;

/**
 * Created by Archimedes on 2016-08-12.
 */
public interface UnitService {

	int save(Unit unit);

	int update(Unit unit);

	int delete(int[] ids);

	Unit find(int code);

	List<Map> findList(String build, String unit, Integer code, int pageNo, int pageSize);

	List<Map> findList(String build, String unit, int pageNo, int pageSize);

	int countList(String build, String unit);

	boolean exist(Integer id, int code);
}
