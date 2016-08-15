"use strict";
$(function () {
	var build = {
		grid: $("#data"),
		editor: $("#editor"),
		form: $("#form"),
		urls: {
			find: "build/find",
			save: "build/save",
			remove: "build/delete",
			exist: "build/exist"
		},
		init: function () {
			//init grid
			var gridBar = [{
				text: $.message.add,
				iconCls: "icon-add",
				handler: function () {
					build.form.form("clear");
					build.editor.dialog({title: $.message.add});
					build.editor.dialog("open");
				}
			}, {
				text: $.message.mod,
				iconCls: "icon-edit",
				handler: function () {
					var rows = build.grid.datagrid("getSelections");
					if (rows.length === 0) {
						$.messager.alert({title: $.message.prompt, msg: $.message.select});
						return;
					}
					if (rows.length > 1) {
						$.messager.alert({title: $.message.prompt, msg: $.message.assign});
						return;
					}
					build.form.form("load", rows[0]);
					build.editor.dialog({title: $.message.mod});
					build.editor.dialog("open");
				}
			}, {
				text: $.message.del,
				iconCls: "icon-remove",
				handler: function () {
					var rows = build.grid.datagrid("getSelections");
					var ids = [];
					if (rows.length > 0) {
						rows.forEach(({id}) => ids.push(id));
					}
					$.crud.remove(build.urls.remove, ids, build.find);
				}
			}];

			build.grid.datagrid({
					fitColumns: true,
					striped: true,
					pagination: true,
					rownumbers: true,
					title: "用户列表",
					toolbar: gridBar,
					url: build.urls.find,
					columns: [[
						{field: "", checkbox: true},
						{field: "id", title: "id", width: 15},
						{field: "name", title: "name", editor: "text", width: 25},
						{field: "createTime", title: "createTime", editor: "text", width: 30},
						{field: "updateTime", title: "updateTime", editor: "text", width: 30}
					]]
				}
			);

			//init dialog
			var dialogBar = [{
				text: $.message.sure,
				iconCls: "icon-ok",
				handler: function () {
					var id = parseInt($("input[name=id]").val()) || "";
					var code = parseInt($("input[name=code]").val());
					$.crud.save(build.form, build.urls.save, function () {
							build.find();
							build.editor.dialog("close");
						}, build.urls.exist, {id: id, code: code}
					);
				}
			}, {
				text: $.message.cancel,
				iconCls: "icon-cancel",
				handler: function () {
					build.form.form("clear");
					build.editor.dialog("close");
				}
			}];
			build.editor.dialog({
				// width: 360,
				closed: true,
				cache: false,
				modal: true,
				closable: false,
				buttons: dialogBar
			});
			//init search
			$("#search").on("click", function () {
				build.find();
			});
			$("#clear").on("click", function () {
				$.crud.clear("#nav");
			});

		},
		find: function () {
			var params = {name: $.trim($("#search-name").val())};
			console.log(params);
			build.grid.datagrid("reload", params);
		}
	};

	build.init();
});




