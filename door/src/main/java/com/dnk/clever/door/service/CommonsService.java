package com.dnk.clever.door.service;

import java.util.Collection;
import java.util.List;

/**
 * Created by Archimedes on 2016-08-12.
 */
public interface CommonsService<Entity> {

	int save(Entity entity);

	int saves(Collection<Entity> entities);

	int deleteById(long id);

	int deleteByEntity(Entity entity);

	int deleteByIds(long[] ids);

	int deleteByEntities(Collection<Entity> entities);

	int update(Entity entity);

	default int updates(Collection<Entity> entities) {
		entities.forEach(entity -> this.update(entity));
		return entities.size();
	}

	Entity findById(long id);

	List<Entity> findAll();

	List<Entity> findInterval(int offset, int limit);

	default List<Entity> findByPage(int pageNo, int pageSize) {
		return this.findInterval((pageNo - 1) * pageSize, pageSize);
	}

	int count();
}
