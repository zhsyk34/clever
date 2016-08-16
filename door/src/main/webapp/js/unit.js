"use strict";
$(function () {
	$.base({
		urls: {
			find: "unit/find",
			save: "unit/save",
			remove: "unit/delete",
			exist: "unit/exist",
		},
		gridOption: {
			title: "单元列表",
			columns: [[
				{field: "", checkbox: true},
				{field: "id", title: "id", width: 10},
				{field: "name", title: "单元名称", editor: "text", width: 15},
				{field: "code", title: "单元编号", editor: "text", width: 10},
				{field: "build", title: "所属楼栋", editor: "text", width: 15},
				{field: "createTime", title: "创建时间", editor: "text", width: 25},
				{field: "updateTime", title: "修改时间", editor: "text", width: 25}
			]]
		},
		before: function () {
			initComboGrid();
		},
		findParams: function () {
			return {
				build: $.trim($("#search-build").val()),
				unit: $.trim($("#search-unit").val())
			};
		},
		existParam: function () {
			return {
				id: parseInt($("input[name=id]").val()) || 0,
				code: parseInt($("input[name=code]").val())
			};
		}
	});

	function initComboGrid() {
		var selector = $("#selector");
		selector.combogrid({
			delay: 500,
			panelWidth: 400,
			panelHeight: 320,
			striped: false,
			mode: "remote",
			method: "POST",
			// idField: "id",
			// textField: "name",
			// valueField:"id",
			url: "build/find",
			columns: [[
				{field: "id", title: "id", width: 20},
				{field: "code", title: "楼栋编号", width: 30},
				{field: "name", title: "楼栋名称", width: 50}
			]],
			fitColumns: true,
			pagination: true,
			onSelect: function (index, row) {
				// selector.combogrid("setValue", row.name);
				// $("input[name=buildId]").val(row.id);
			}
		});
	}
});




