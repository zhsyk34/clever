"use strict";
$(function () {
	$.base({
		urls: {
			find: "build/find",
			save: "build/save",
			remove: "build/delete",
			exist: "build/exist"
		},
		gridOption: {
			title: "用户列表",
			columns: [[
				{field: "", checkbox: true},
				{field: "id", title: "id", width: 15},
				{field: "name", title: "name", editor: "text", width: 25},
				{field: "createTime", title: "createTime", editor: "text", width: 30},
				{field: "updateTime", title: "updateTime", editor: "text", width: 30}
			]]
		},
		findParams: function () {
			return {name: $.trim($("#search-name").val())};
		},
		existParam: function () {
			return {
				id: parseInt($("input[name=id]").val()) || 0,
				code: parseInt($("input[name=code]").val())
			};
		}
	});
});




