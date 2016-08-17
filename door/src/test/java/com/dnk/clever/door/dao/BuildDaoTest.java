package com.dnk.clever.door.dao;

import com.dnk.clever.door.entity.Build;
import com.dnk.clever.door.service.BuildService;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Archimedes on 2016-08-12.
 */
public class BuildDaoTest extends BaseTest {

	@SuppressWarnings("SpringJavaAutowiringInspection")
	@Resource
	private BuildDao buildDao;
	@Resource
	private BuildService buildService;

	@Test
	public void init() {
		System.out.println(buildDao);
	}

	@Test
	public void add() {
		Build build = new Build(0, "科技大厦", 101, null, null);
		buildDao.save(build);
	}

	@Test
	public void addList() {
		List<Build> builds = new ArrayList<>();
		for (int i = 1; i <= 5; i++) {
			Build build = new Build(0, "监狱" + i, 200 + i, null, null);
			builds.add(build);
		}

		buildDao.saves(builds);
	}

	@Test
	public void findList() {
//		buildDao.findAll().forEach(System.out::println);
//		System.out.println(buildDao.findById(9));
//		buildDao.findInterval(1, 3).forEach(System.out::println);
//		buildDao.findList(null, 1, 3).forEach(System.out::println);
//		buildDao.findList(null, -1, 3).forEach(System.out::println);
//		buildDao.findList("监狱", -1, 3).forEach(System.out::println);
		buildDao.findList("监狱", null, 2, 2).forEach(System.out::println);
	}

	@Test
	public void deleteList() {
		List<Build> builds = buildDao.findList("监狱", 1L, 1, 3);
		builds.forEach(System.out::println);
		int c = buildDao.deleteByEntities(builds);
		System.out.println(c);
	}

	@Test
	public void update() {
		Build build = buildDao.findById(9);
		System.out.println(build);

		build.setName("小黑屋");
		build.setUpdateTime(new Date());
		int count = buildDao.update(build);
		System.out.println(count);
	}

	@Test
	public void updateList() {
		List<Build> builds = buildDao.findInterval(2, 2);
		builds.forEach(System.out::println);
		builds.forEach(build -> {
			build.setName("哈哈");
			build.setUpdateTime(new Date());
		});
//		int count = buildService.updates(builds);
//		System.out.println(count);
	}

	@Test
	public void delete() {
		List<Build> builds = buildDao.findInterval(2, 2);

		int count = buildDao.deleteByEntities(builds);
		System.out.println(count);
	}

	@Test
	public void count() {
		int count = buildDao.countList(null, 203L);
		System.out.println(count);
	}
}