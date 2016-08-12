package com.dnk.clever.door.vo;

import lombok.Data;

import java.util.List;

/**
 * 前端分页展现数据封装,适用于easyui-datagrid插件:默认采用指定属性名
 * Created by Archimedes on 2016-08-10.
 */
@Data
public class EasyGrid<Entity> {

	private List<Entity> rows;

	private int total;
}
