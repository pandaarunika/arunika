<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ page import="com.mkyong.common.form.*" %>
<html>
<head>
<script src="resources/js/HelloWorld.js"></script>
</head>
<body>
<form action="/StrutsExample/submit.do" >
Name :<input type="text" id="name" name="name"></input>
Gender :Male<input type="radio" id="gender1" value='<%=request.getAttribute("var1") %>' name="gender" onclick="findGender()"/>
Female<input type="radio" id="gender2" value='<%=request.getAttribute("var2") %>' name="gender" onclick="findGender()"/>
        
Indian:<input type="checkbox" id="indian" name="indian"></input>
City:<select name="selectedCity">
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