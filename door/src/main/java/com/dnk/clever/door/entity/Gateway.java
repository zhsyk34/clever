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

	private long id;

	private long unitId;

	private String udid;//识别码,出厂设置

	private String name;

	private String ip;

	private int port;

	private String remote;

	private String version;

	/*二维码*/
	private String qrCode;

	private Date createTime;

	private Date updateTime;
}
