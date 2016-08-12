package com.dnk.clever.door.entity;

import org.junit.Test;

import java.util.Date;

/**
 * Created by Archimedes on 2016-08-09.
 */
public class UnitTest {

	@Test
	public void testLombok() {
		Unit unit = new Unit();
		unit.setCreateTime(new Date());
		System.out.println(unit.getCreateTime());
	}
}