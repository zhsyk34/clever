package com.dnk.clever.door.entity;

import com.dnk.clever.door.entity.dict.Action;
import com.dnk.clever.door.entity.dict.ActionType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Record {

	private long id;

	private String uuid;//lock-uuid

	private Action action;//指令

	private ActionType type;

	private int number;//指纹或密码 id

	private String description;//指令描述

	private Date eventTime;

	private Date createTime;

}
