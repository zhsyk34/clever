"use strict";
$(function () {

	initCombo();
	function initCombo() {
		var buildCombo = $("#build-selector"), unitCombo = $("#unit-selector"), houseCombo = $("#house-selector");

		buildCombo.combobox({
			url: "build/list",
			onChange: function () {
				unitCombo.combobox({
					onBeforeLoad: function (param) {
						var buildId = buildCombo.combobox("getValue");
						param.buildId = buildId;
					}
				});
			}
		});

		unitCombo.combobox({
			url: "unit/list",
			onChange: function () {
				houseCombo.combobox({
					onBeforeLoad: function (param) {
						var unitId = unitCombo.combobox("getValue");
						param.unitId = unitId;
					}
				});
			}
		});

		houseCombo.combobox({
			url: "house/list"
		});
	}

});




