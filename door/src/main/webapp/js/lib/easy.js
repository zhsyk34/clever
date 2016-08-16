(function ($) {
	$.extend($.fn.dialog.defaults, {
		top: 100, closed: true,
		cache: false,
		modal: true,
		closable: false
	});

	$.extend($.messager.defaults, {top: 100});

	$.extend($.fn.datagrid.defaults, {
		fitColumns: true,
		striped: true,
		pagination: true,
		rownumbers: true,
	});

	$.extend($.fn.combobox.defaults, {
		editable: false,
		mode: "remote",
		method: "POST",
		valueField: "id",
		textField: "name",
		panelWidth: 180
	});
})(jQuery);
