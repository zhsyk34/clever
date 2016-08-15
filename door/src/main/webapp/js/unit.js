"use strict";
$(function () {
	var unit = {
		grid: $("#data"),
		editor: $("#editor"),
		selector: $("#selector"),
		form: $("#form"),
		urls: {
			find: "unit/find",
			save: "unit/save",
			remove: "unit/delete",
			exist: "unit/exist",
			load: "build/find"
		},
		init: function () {
			//init grid
			var gridBar = [{
				text: $.message.add,
				iconCls: "icon-add",
				handler: function () {
					unit.form.form("clear");
					// unit.selector.combogrid("clear");
					unit.editor.dialog({title: $.message.add});
					unit.editor.dialog("open");
				}
			}, {
				text: $.message.mod,
				iconCls: "icon-edit",
				handler: function () {
					var rows = unit.grid.datagrid("getSelections");
					if (rows.length === 0) {
						$.messager.alert({title: $.message.prompt, msg: $.message.select});
						return;
					}
					if (rows.length > 1) {
						$.messager.alert({title: $.message.prompt, msg: $.message.assign});
						return;
					}
					unit.form.form("load", rows[0]);
					unit.editor.dialog({title: $.message.mod});
					unit.editor.dialog("open");
				}
			}, {
				text: $.message.del,
				iconCls: "icon-remove",
				handler: function () {
					var rows = unit.grid.datagrid("getSelections");
					var ids = [];
					if (rows.length > 0) {
						rows.forEach(({id}) => ids.push(id));
					}
					$.crud.remove(unit.urls.remove, ids, unit.find);
				}
			}];

			unit.grid.datagrid({
					fitColumns: true,
					striped: true,
					pagination: true,
					rownumbers: true,
					title: "单元列表",
					toolbar: gridBar,
					url: unit.urls.find,
					columns: [[
						{field: "", checkbox: true},
						{field: "id", title: "id", width: 10},
						{field: "name", title: "单元名称", editor: "text", width: 15},
						{field: "code", title: "单元编号", editor: "text", width: 10},
						{field: "build", title: "所属楼栋", editor: "text", width: 15},
						{field: "createTime", title: "创建时间", editor: "text", width: 25},
						{field: "updateTime", title: "修改时间", editor: "text", width: 25}
					]]
				}
			);

			//init dialog
			var dialogBar = [{
				text: $.message.sure,
				iconCls: "icon-ok",
				handler: function () {
					var id = parseInt($("input[name=id]").val()) || null;
					var code = parseInt($("input[name=code]").val());
					$.crud.save(unit.form, unit.urls.save, function () {
							unit.find();
							unit.editor.dialog("close");
						}, unit.urls.exist, {id: id, code: code}
					);
				}
			}, {
				text: $.message.cancel,
				iconCls: "icon-cancel",
				handler: function () {
					unit.form.form("clear");
					unit.editor.dialog("close");
				}
			}];
			unit.editor.dialog({
				closed: true,
				cache: false,
				modal: true,
				closable: false,
				buttons: dialogBar
			});

			//init load grid
			unit.selector.combogrid({
				delay: 500,
				panelWidth: 400,
				panelHeight: 320,
				striped: false,
				mode: "remote",
				method: "POST",
				// idField: "id",
				// textField: "name",
				url: unit.urls.load,
				columns: [[
					{field: "id", title: "id", width: 20},
					{field: "code", title: "楼栋编号", width: 30},
					{field: "name", title: "楼栋名称", width: 50}
				]],
				fitColumns: true,
				pagination: true,
				onSelect: function (index, row) {
					console.log(index, row);
					unit.selector.combogrid("setValue", row.name);
					$("input[name=buildId]").val(row.id);
				}
			});
			//init search
			$("#search").on("click", function () {
				unit.find();
			});
			$("#clear").on("click", function () {
				$.crud.clear("#nav");
			});
		},
		find: function () {
			var params = {
				build: $.trim($("#search-build").val()),
				unit: $.trim($("#search-unit").val()),
			};
			unit.grid.datagrid("reload", params);
		}
	};

	unit.init();
});






