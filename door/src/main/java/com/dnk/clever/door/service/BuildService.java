package com.dnk.clever.door.service;

import com.dnk.clever.door.entity.Build;

import java.util.List;

public interface BuildService {

	int save(Build build);

	int update(Build build);

	int delete(int[] ids);

	Build find(int code);

	List<Build> findList(String name, int pageNo, int pageSize);

	int count(String name);

	boolean exist(Integer id, int code);

	boolean relate(int id);

	boolean relate(int[] ids);
}
