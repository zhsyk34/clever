package com.dnk.clever.door.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Lock {

	private long id;

	private long houseId;

	private String uuid;//自动增长

	private String name;

	private int area;

	private int device;

	private Date createTime;

	private Date updateTime;
}
