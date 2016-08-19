package com.dnk.clever.door.entity;

import com.dnk.clever.door.entity.dict.PassType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pass {

	private long id;

	private long userId;

	private long lockId;//TODO lock-uuid,houseId,houseName?

	private PassType type;

	private int number;

	private Date createTime;

	private Date updateTime;
}
