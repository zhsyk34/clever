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
public class House {

	private long id;

	private long unitId;

	private String name;

	private long code;

	private Date createTime;

	private Date updateTime;

}
