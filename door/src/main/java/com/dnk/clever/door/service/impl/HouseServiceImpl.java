package com.dnk.clever.door.service.impl;

import com.dnk.clever.door.entity.House;
import com.dnk.clever.door.service.HouseService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * Created by Archimedes on 2016-08-15.
 */
@Service
public class HouseServiceImpl implements HouseService {
	@Override
	public int save(House house) {
		return 0;
	}

	@Override
	public int saves(Collection<House> houses) {
		return 0;
	}

	@Override
	public int deleteById(int id) {
		return 0;
	}

	@Override
	public int deleteByEntity(House house) {
		return 0;
	}

	@Override
	public int deleteByIds(int[] ids) {
		return 0;
	}

	@Override
	public int deleteByEntities(Collection<House> houses) {
		return 0;
	}

	@Override
	public int update(House house) {
		return 0;
	}

	@Override
	public House findById(int id) {
		return null;
	}

	@Override
	public List<House> findAll() {
		return null;
	}

	@Override
	public List<House> findInterval(int offset, int limit) {
		return null;
	}

	@Override
	public int count() {
		return 0;
	}
}
