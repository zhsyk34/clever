package com.dnk.clever.door.service;

import com.dnk.clever.door.entity.Build;

import java.util.List;

/**
 * Created by Archimedes on 2016-08-12.
 */
public interface BuildService {

	int save(Build build);

	int update(Build build);

	int delete(int[] ids);

	Build find(int code);

	List<Build> findList(String name, Integer code, int pageNo, int pageSize);

	List<Build> findList(String name, int pageNo, int pageSize);

	int countList(String name);

	boolean exist(Integer id, int code);
}
