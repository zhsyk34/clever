package com.dnk.clever.door.dao;

import com.dnk.clever.door.entity.Build;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Archimedes on 2016-08-12.
 */
public class BuildDaoTest extends BaseTest {

	@Resource
	private BuildDao buildDao;

	@Test
	public void init() {
		System.out.println(buildDao);
	}

	@Test
	public void add() {
		Build build = new Build(0, "科技大厦", null, null);
		buildDao.save(build);
	}

	@Test
	public void addList() {
		List<Build> builds = new ArrayList<>();
		for (int i = 1; i < 5; i++) {
			Build build = new Build(null, "监狱" + i, null, null);
			builds.add(build);
		}

		buildDao.saves(builds);
	}

	@Test
	public void update() {
		Build build = buildDao.findById(3);
		System.out.println(build);

		build.setName("update...");
		build.setUpdateTime(new Date());
		int count = buildDao.update(build);
		System.out.println(count);
	}

	@Test
	public void updateList() {
		List<Build> builds = buildDao.findInterval(2, 2);
		builds.forEach(System.out::println);
		builds.forEach(build -> build.setUpdateTime(new Date()));

		/*int count = buildDao.updates(builds);
		System.out.println(count);*/
	}

	@Test
	public void delete() {
		List<Build> builds = buildDao.findInterval(2, 2);

		int count = buildDao.deleteByEntities(builds);
		System.out.println(count);
	}
}