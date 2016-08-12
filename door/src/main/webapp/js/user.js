"use strict";
$(function () {
	var user = {
		grid: $("#data"),
		editor: $("#editor"),
		form: $("#form"),
		urls: {
			find: "user/find",
			save: "user/save",
			remove: "user/delete"
		},
		init: function () {
			//init grid
			var gridBar = [{
				text: $.message.add,
				iconCls: "icon-add",
				handler: function () {
					user.form.form("clear");
					user.editor.dialog({title: $.message.add});
					user.editor.dialog("open");
				}
			}, {
				text: $.message.mod,
				iconCls: "icon-edit",
				handler: function () {
					var rows = user.grid.datagrid("getSelections");
					if (rows.length === 0) {
						$.messager.alert({title: $.message.prompt, msg: $.message.select});
						return;
					}
					if (rows.length > 1) {
						$.messager.alert({title: $.message.prompt, msg: $.message.assign});
						return;
					}
					user.form.form("load", rows[0]);
					user.editor.dialog({title: $.message.mod});
					user.editor.dialog("open");
				}
			}, {
				text: $.message.del,
				iconCls: "icon-remove",
				handler: function () {
					var rows = user.grid.datagrid("getSelections");
					var ids = [];
					if (rows.length > 0) {
						rows.forEach(({id}) => ids.push(id));
					}
					$.crud.remove(user.urls.remove, ids, user.find);
				}
			}];

			user.grid.datagrid({
					fitColumns: true,
					striped: true,
					pagination: true,
					/*pageList: [2, 3, 5, 7],
					 pageSize: 2,*/
					rownumbers: true,
					title: "用户列表",
					toolbar: gridBar,
					url: user.urls.find,
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
					$.crud.save(user.form, user.urls.save, function () {
						user.find();
						user.editor.dialog("close");
					});
				}
			}, {
				text: $.message.cancel,
				iconCls: "icon-cancel",
				handler: function () {
					user.form.form("clear");
					user.editor.dialog("close");
				}
			}];
			user.editor.dialog({
				// width: 360,
				closed: true,
				cache: false,
				modal: true,
				closable: false,
				buttons: dialogBar
			});
		},
		find: function () {
			user.grid.datagrid({url: user.urls.find});
		}
	};

	user.init();
});




