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
				{field: "build", title: "所属楼栋", editor: "text", width: 15},
				{field: "name", title: "单元名称", editor: "text", width: 15},
				{field: "code", title: "单元编号", editor: "text", width: 10},
				{field: "createTime", title: "创建时间", editor: "text", width: 25},
				{field: "updateTime", title: "修改时间", editor: "text", width: 25}
			]]
		},
		before: function () {
			$("#selector").combobox({url: "build/list"});
		},
		beforeOpenMod: function (row) {
			$("#selector").combobox("setValue", row.buildId).combobox("setText", row.build);
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

});




