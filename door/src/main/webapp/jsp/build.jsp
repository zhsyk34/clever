<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<%@ include file="/jsp/commons/header.jsp" %>
	<title>User list</title>
	<script src="js/user.js"></script>
</head>
<body>
<div>
	<div id="data"></div>

	<div id="editor">
		<form id="form" method="post">
			<table>
				<tr>
					<td>id:</td>
					<td><input class="easyui-textbox" type="number" name="id" data-options="required:false" readonly></td>
				</tr>
				<tr>
					<td>name:</td>
					<td><input class="easyui-textbox" type="text" name="name" data-options="required:true"></td>
				</tr>
				<tr>
					<td>create:</td>
					<td><input class="easyui-textbox" type="text" name="createTime" data-options="required:false"></td>
				</tr>
				<tr>
					<td>update:</td>
					<td><input class="easyui-textbox" type="text" name="updateTime" data-options="required:false"></td>
				</tr>
			</table>
		</form>
	</div>
</div>
</body>
</html>
