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
public class Unit {

	private Integer id;

	private Integer buildId;

	private String name;

	private Integer code;

	private Date createTime;

	private Date updateTime;

}
