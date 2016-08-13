package com.dnk.clever.door.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * Created by Archimedes on 2016-08-13.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Locks {

	private Integer id;

	private Integer houseId;

	private String uuid;

	private String name;

	private Integer areaNo;

	private Integer devNo;

	private Date createTime;

	private Date updateTime;
}
