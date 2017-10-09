<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ page import="com.mkyong.common.form.*" %>
<html>
<head>
<script src="resources/js/HelloWorld.js"></script>
</head>
<body>
<form action="/StrutsExample/submit.do" >
<h1><bean:write name="helloWorldForm" property="message" /></h1>
<input type="text" value='<%=request.getAttribute("var") %>'  hidden="true"/>
Name :<input type="text" id="name"></input>
Gender :Male<input type="radio" id="gender" value='<%=request.getAttribute("var") %>' onclick="findGender()"/>
Indian:<input type="checkbox" id="indian" ></input>
City:<select id="city">
<%
String[] city = ((HelloWorldForm)request.getAttribute("helloWorldForm")).getCity();
for (int i=0;i<city.length;i++){
	out.println("<option>"+city[i]+"</option>");	 
} %>
</select>
<input type="submit" value="submit" />
</form>
</body>
</html>