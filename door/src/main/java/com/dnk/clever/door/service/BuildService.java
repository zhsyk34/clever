package com.dnk.clever.door.service;

import com.dnk.clever.door.entity.Build;

import java.util.List;

public interface BuildService {

	int save(Build build);

	int update(Build build);

	int delete(long[] ids);

	Build find(long code);

	List<Build> findList(String name, int pageNo, int pageSize);

	int count(String name);

	boolean exist(long id, long code);

	boolean relate(long id);

	boolean relate(long[] ids);
}
