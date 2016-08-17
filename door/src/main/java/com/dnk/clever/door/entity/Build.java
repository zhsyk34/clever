package com.dnk.clever.door.entity;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Build {

	private long id;

	private String name;

	private long code;

	private Date createTime;

	private Date updateTime;

}
