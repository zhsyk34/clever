package com.dnk.clever.door.dao;

import com.dnk.clever.door.entity.Unit;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by Archimedes on 2016-08-12.
 */
public interface UnitDao extends CommonsDao<Unit> {

	List<Map> findList(@Param("build") String build, @Param("code") int code, @Param("unit") String unit, @Param("offset") int offset, @Param("limit") int limit);

	int countList(@Param("build") String build, @Param("code") int code, @Param("unit") String unit);
}
