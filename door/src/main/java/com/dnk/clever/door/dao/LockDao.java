package com.dnk.clever.door.dao;

import com.dnk.clever.door.entity.Lock;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface LockDao extends CommonsDao<Lock> {

	List<Lock> findList(@Param("houseId") Long houseId, @Param("uuid") String uuid, @Param("name") String name, @Param("offset") int offset, @Param("limit") int limit);

	List<Map> findMap(@Param("build") String build, @Param("unit") String unit, @Param("house") String house, @Param("name") String name, @Param("offset") int offset, @Param("limit") int limit);

	int countMap(@Param("build") String build, @Param("unit") String unit, @Param("house") String house, @Param("name") String name);
}
