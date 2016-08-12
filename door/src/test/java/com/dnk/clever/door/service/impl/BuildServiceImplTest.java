package com.dnk.clever.door.service.impl;

import com.dnk.clever.door.dao.BaseTest;
import com.dnk.clever.door.entity.Build;
import com.dnk.clever.door.service.BuildService;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Archimedes on 2016-08-12.
 */
public class BuildServiceImplTest extends BaseTest {

	@Resource
	private BuildService buildService;

	@Test
	public void find() throws Exception {
		List<Build> builds = buildService.findInterval(1, 4);
		builds.forEach(System.out::println);
	}

	@Test
	public void updates() throws Exception {
		List<Build> builds = buildService.findByPage(1, 2);
		builds.forEach(System.out::println);
		builds.forEach(build -> build.setName("batch update"));
		buildService.updates(builds);
	}

	@Test
	public void findByPage() throws Exception {
		List<Build> builds = buildService.findByPage(1, 2);
		builds.forEach(System.out::println);
	}

}