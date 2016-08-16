package com.dnk.clever.door.dao;

import com.dnk.clever.door.entity.Unit;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UnitDao extends CommonsDao<Unit> {

	List<Unit> findList(@Param("buildId") Integer buildId, @Param("name") String name, @Param("code") Integer code, @Param("offset") int offset, @Param("limit") int limit);

	List<Map> findMap(@Param("build") String build, @Param("unit") String unit, @Param("code") Integer code, @Param("offset") int offset, @Param("limit") int limit);

	int countMap(@Param("build") String build, @Param("unit") String unit, @Param("code") Integer code);

}
