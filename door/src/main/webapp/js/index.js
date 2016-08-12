$(function () {
	$("#accordion").on("click", "li", function (e) {
		e.preventDefault();

		var a = $(this).children("a:first");
		var title = a.text();

		var tabs = $("#tabs");
		var exist = tabs.tabs("exists", title);

		if (exist) {
			tabs.tabs("select", title);
		} else {
			var frame = "<iframe src='" + a.attr("href") + "'/>";
			tabs.tabs("add", {title: title, content: frame, closable: true});
		}
	});
});