package com.dnk.clever.door.vo;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * 适用于easyui tree控件的数据封装
 * Created by Archimedes on 2016-08-10.
 */
@Data
public class EasyTree {

	private String id;
	private String text;
	private State state;

	private String iconCls;
	private boolean checked;

	private List<EasyTree> children;
	private Map<String, Object> attributes;

	public enum State {
		OPEN, CLOSED
	}
}
