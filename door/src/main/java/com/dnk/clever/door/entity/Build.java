package com.dnk.clever.door.entity;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Build {

	private Integer id;

	private String name;

	private Integer code;

	private Date createTime;

	private Date updateTime;

}
