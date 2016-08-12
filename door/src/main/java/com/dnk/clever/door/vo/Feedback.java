package com.dnk.clever.door.vo;

import lombok.Getter;

/**
 * Created by Archimedes on 2016-08-10.
 */
public enum Feedback {

	/**
	 * 行为
	 */
	CREATE(11, "添加"),
	DELETE(12, "删除"),
	UPDATE(13, "修改"),
	QUERY(14, "查询"),
	UPLOAD(15, "上传"),
	REVOKE(16, "撤销"),

	/**
	 * 状态
	 */
	EXIST(21, "已存在"),
	NONEXIST(22, "不存在"),
	RELATE(23, "正被使用(关联)中"),
	OFFLINE(24, "未登录"),

	/**
	 * 结果
	 */
	SUCCESS(31, "成功"),
	FAIL(32, "失败"),
	ENABLE(33, "启用"),
	DISABLE(34, "禁用"),
	ERROR(35, "出错");

	@Getter
	private Integer index;
	@Getter
	private String description;

	Feedback(Integer index, String description) {
		this.index = index;
		this.description = description;
	}

}
