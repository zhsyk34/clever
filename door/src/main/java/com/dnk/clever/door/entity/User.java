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
public class User {

	private Integer id;

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
