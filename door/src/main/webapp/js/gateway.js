"use strict";
$(function () {
	function initCombo() {
		var buildCombo = $("#build-selector"), unitCombo = $("#unit-selector");

		buildCombo.combobox({
			url: "build/list",
			onChange: function () {
				unitCombo.combobox({
					onBeforeLoad: function (param) {
						param.buildId = buildCombo.combobox("getValue");
					}
				});
			}
		});

		unitCombo.combobox({url: "unit/list"});
	}

	$.base({
		urls: {
			find: "gateway/find",
			save: "gateway/save",
			remove: "gateway/delete",
			exist: null
		},
		gridOption: {
			title: "网关列表",
			columns: [[
				{field: "", checkbox: true},
				{field: "id", title: "id", width: 5},
				{field: "build", title: "所属楼栋", width: 10},
				{field: "unit", title: "所属单元", width: 10},
				{field: "name", title: "网关名称", width: 10},
				{field: "sn", title: "序列号", width: 10},
				{field: "ip", title: "内网IP", width: 10},
				{field: "remote", title: "外网IP", width: 10},
				{field: "port", title: "端口号", width: 10},
				{field: "createTime", title: "创建时间", width: 15},
				{field: "updateTime", title: "修改时间", width: 15}
			]]
		},
		before: function () {
			initCombo();
		},
		beforeOpenAdd: function () {
			$("#id").val(0);
			$("#udid").textbox("readonly", false);
		},
		beforeOpenMod: function (row) {
			$("#build-selector").combobox("setValue", row.buildId).combobox("setText", row.build);
			$("#unit-selector").combobox("setValue", row.unitId).combobox("setText", row.unit);
			$("#udid").textbox("readonly", true);
		},
		findParams: function () {
			return {
				build: $.trim($("#search-build").val()),
				unit: $.trim($("#search-unit").val()),
				name: $.trim($("#search-name").val())
			};
		}
	});
});







