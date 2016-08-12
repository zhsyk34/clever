<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<%@ include file="/jsp/commons/header.jsp" %>
	<title>tree</title>
</head>
<body>
<div>
	<div id="tree"/>
	<h2>Basic Tree</h2>
	<p>Click the arrow on the left to expand or collapse nodes.</p>
	<div style="margin:20px 0;"></div>
	<div class="easyui-panel" style="padding:5px">
		<ul class="">
			<li>
				<span>My Documents</span>
				<ul>
					<li data-options="state:'closed'">
						<span>Photos</span>
						<ul>
							<li>
								<span>Friend</span>
							</li>
							<li>
								<span>Wife</span>
							</li>
							<li>
								<span>Company</span>
							</li>
						</ul>
					</li>
					<li>
						<span>Program Files</span>
						<ul>
							<li>Intel</li>
							<li>Java</li>
							<li>Microsoft Office</li>
							<li>Games</li>
						</ul>
					</li>
					<li>index.html</li>
					<li>about.html</li>
					<li>welcome.html</li>
				</ul>
			</li>
			<li>new add...</li>
			<li>ok...</li>
		</ul>
	</div>

</div>
<script>

	$(function () {

		var tree = [{"id": "1", "text": "root", "state": "OPEN", "checked": false, "children": [{"text": "1-1", "checked": false}, {"text": "1-2", "checked": false}, {"text": "1-3", "checked": true}]}];

		var data = [{
			"id": 1,
			"text": "Folder1",
			"iconCls": "icon-save",
			"children": [{
				"text": "File1",
				"checked": true
			}, {
				"text": "Books",
				"state": "open",
				"attributes": {
					"url": "/demo/book/abc",
					"price": 100
				},
				"children": [{
					"text": "PhotoShop",
					"checked": true
				}, {
					"id": 8,
					"text": "Sub Bookds",
					"state": "closed"
				}]
			}]
		}, {
			"text": "Languages",
			"state": "closed",
			"children": [{
				"text": "Java"
			}, {
				"text": "C#"
			}]
		}];

		$("#tree").tree({
			data: tree
		});
	});
</script>
</body>
</html>
