package com.dnk.clever.door.dao;

import com.dnk.clever.door.entity.House;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface HouseDao extends CommonsDao<House> {

	List<House> findList(@Param("unitId") Long unitId, @Param("name") String name, @Param("code") Long code, @Param("offset") int offset, @Param("limit") int limit);

	List<Map> findMap(@Param("build") String build, @Param("unit") String unit, @Param("house") String house, @Param("code") Long code, @Param("offset") int offset, @Param("limit") int limit);

	int countMap(@Param("build") String build, @Param("unit") String unit, @Param("house") String house, @Param("code") Long code);
}
