package com.dnk.clever.door.dao;

import com.dnk.clever.door.entity.House;

import java.util.List;
import java.util.Map;

/**
 * Created by Archimedes on 2016-08-12.
 */
public interface HouseDao extends CommonsDao<House> {

	List<Map> findList(String unit, String name, int offset, int limit);

	int countList(String unit, String name);
}
