package com.dnk.clever.door.dao;

import com.dnk.clever.door.entity.Build;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Archimedes on 2016-08-12.
 */
public interface BuildDao extends CommonsDao<Build> {

	List<Build> findList(@Param("name") String name, @Param("code") int code, @Param("offset") int offset, @Param("limit") int limit);

	int countList(@Param("name") String name, @Param("code") int code);
}
