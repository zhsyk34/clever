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
public class Gateway {

	private Integer id;

	private Integer unitId;

	private String udid;

	private String name;

	private String ip;

	private Integer port;

	private String remote;

	private String version;

	/*二维码*/
	private String qr_code;

	private Date createTime;

	private Date updateTime;
}
