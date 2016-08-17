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
public class User {

	private long id;

	private String name;

	private String idCard;

	private String email;

	private String gender;

	private String phone;

	private boolean used;

	/*@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")*/
	private Date createTime;

	/*@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")*/
	private Date updateTime;

}
