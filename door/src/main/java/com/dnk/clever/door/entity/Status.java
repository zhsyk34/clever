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
public class Status {

	private long id;

	private String uuid;

	private int locked;//关闭

	private int upLock;//上提反锁

	private int backLock;//室内反锁

	private int voltage;//实际数据应/10

	private int online;

	private Date time;

}
