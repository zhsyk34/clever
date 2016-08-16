package com.dnk.clever.door.dao;

import org.apache.ibatis.annotations.Param;

import java.util.Collection;
import java.util.List;

interface CommonsDao<Entity> {

	int save(Entity entity);

	int saves(Collection<Entity> entities);

	int deleteById(int id);

	int deleteByEntity(Entity entity);

	int deleteByIds(int[] ids);

	int deleteByEntities(Collection<Entity> entities);

	int update(Entity entity);

	Entity findById(int id);

	List<Entity> findAll();

	List<Entity> findInterval(@Param("offset") int offset, @Param("limit") int limit);

	int count();
}
