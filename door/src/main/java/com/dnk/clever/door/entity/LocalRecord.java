package com.dnk.clever.door.entity;

import com.dnk.clever.door.entity.dict.Action;
import com.dnk.clever.door.entity.dict.ActionType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * 脱机记录(锁上保留记录),格式同record
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LocalRecord {

	private long id;

	private String uuid;

	private Action action;

	private ActionType type;

	private int number;

	private String description;

	private Date eventTime;

	private Date createTime;

}
