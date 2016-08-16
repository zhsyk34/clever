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
public class Locks {

	private Integer id;

	private Integer houseId;

	private String guid;

	private String name;

	private Integer areaNo;

	private Integer devNo;

	private Date createTime;

	private Date updateTime;
}
