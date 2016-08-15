package com.dnk.clever.door.dao;

import com.dnk.clever.door.entity.House;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by Archimedes on 2016-08-12.
 */
public interface HouseDao extends CommonsDao<House> {

	List<Map> findList(@Param("build") String build, @Param("unit") String unit, @Param("house") String house, @Param("code") int code, @Param("offset") int offset, @Param("limit") int limit);

	int countList(@Param("build") String build, @Param("unit") String unit, @Param("house") String house, @Param("code") int code);
}
