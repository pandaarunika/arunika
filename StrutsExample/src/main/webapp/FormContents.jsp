<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ page import="com.mkyong.common.form.*" %>
<html>
<head>
<script src="resources/js/HelloWorld.js"></script>
</head>
<body>
<table>
<tr >
<th>NAME</th>
<th>GENDER</th>
<th>CITY</th>
<th>INDIAN</th>
</tr>
<tr>
<th>
<bean:write name="helloWorldForm" property="name" />

 </th>
<th>
<bean:write name="helloWorldForm" property="gender" /></th>
<th><bean:write name="helloWorldForm" property="selectedCity" /></th>
<th><bean:write name="helloWorldForm" property="indian" /></th></tr>
</table>
</body>
</html>