package com.dnk.clever.door.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * Created by Archimedes on 2016-08-09.
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class House {

	private Integer id;

	private Integer unitId;

	private String name;

	private Date createTime;

	private Date updateTime;

}
