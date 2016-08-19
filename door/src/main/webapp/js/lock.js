"use strict";
$(function () {
	function initCombo() {
		var buildCombo = $("#build-selector"), unitCombo = $("#unit-selector"), houseCombo = $("#house-selector");

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

		unitCombo.combobox({
			url: "unit/list",
			onChange: function () {
				houseCombo.combobox({
					onBeforeLoad: function (param) {
						param.unitId = unitCombo.combobox("getValue");
					}
				});
			}
		});

		houseCombo.combobox({
			url: "house/list"
		});
	}

	$.base({
		urls: {
			find: "lock/find",
			save: "lock/save",
			remove: "lock/delete",
			exist: null
		},
		gridOption: {
			title: "门锁列表",
			columns: [[
				{field: "", checkbox: true},
				{field: "id", title: "id", width: 5},
				{field: "build", title: "所属楼栋", width: 10},
				{field: "unit", title: "所属单元", width: 10},
				{field: "house", title: "所属房屋", width: 10},
				{field: "name", title: "门锁名称", width: 10},
				{field: "uuid", title: "识别码", width: 20},
				{field: "area", title: "区域号", width: 10},
				{field: "device", title: "设备号", width: 10},
				{field: "createTime", title: "创建时间", width: 15},
				{field: "updateTime", title: "修改时间", width: 15}
			]]
		},
		before: function () {
			initCombo();
		},
		beforeOpenAdd: function () {
			$("#id").val(0);
			$("#uuid").textbox("readonly", false);
		},
		beforeOpenMod: function (row) {
			$("#build-selector").combobox("setValue", row.buildId).combobox("setText", row.build);
			$("#unit-selector").combobox("setValue", row.unitId).combobox("setText", row.unit);
			$("#house-selector").combobox("setValue", row.houseId).combobox("setText", row.house);

			$("#uuid").textbox("readonly", true);
		},
		findParams: function () {
			return {
				build: $.trim($("#search-build").val()),
				unit: $.trim($("#search-unit").val()),
				house: $.trim($("#search-house").val()),
				name: $.trim($("#search-name").val())
			};
		}
	});
});







