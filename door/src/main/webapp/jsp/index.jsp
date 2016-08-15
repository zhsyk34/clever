<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<%@ include file="/jsp/commons/commons.jsp" %>
	<script src="js/index.js"></script>
	<link rel="stylesheet" href="css/index.css"/>
	<title>**管理系统</title>
</head>
<body>
<div id="wrap" class="easyui-layout">
	<div id="header" data-options="region:'north',border:'true'">header</div>

	<div id="footer" data-options="region:'south'">footer</div>

	<div id="nav" data-options="region:'west',split:true">
		<%--accordion--%>
		<div id="accordion" class="easyui-accordion" data-options="multiple:true,border:false">
			<div title="module-1" style="height:auto;">
				<ul>
					<li>
						<a href="jsp/user.jsp">用户管理</a>
					</li>
					<li>1-3</li>
				</ul>
			</div>
			<div title="建筑物">
				<ul>
					<li>
						<a href="jsp/coord/build.jsp">楼栋管理</a>
					</li>
					<li>
						<a href="jsp/coord/unit.jsp">单元管理</a>
					</li>
					<li>
						<a href="jsp/coord/house.jsp">房屋管理</a>
					</li>
				</ul>
			</div>
		</div>
	</div>

	<div id="main" data-options="region:'center',border:true">
		<div id="tabs" class="easyui-tabs" data-options="border:false"/>
	</div>
</div>
</body>
</html>
