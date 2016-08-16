package com.dnk.clever.door.service;

import com.dnk.clever.door.entity.House;

import java.util.List;
import java.util.Map;

public interface HouseService {

	int save(House house);

	int update(House house);

	int delete(int[] ids);

	House find(int code);

	List<House> findList(Integer unitId, String name, int pageNo, int pageSize);

	List<Map> findList(String build, String unit, String house, int pageNo, int pageSize);

	int count(String build, String unit, String house);

	boolean exist(Integer id, int code);

	boolean relate(int id);

	boolean relate(int[] ids);
}
