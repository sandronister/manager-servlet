<%@page import="br.com.sandroni.manager.model.Company"%>
<%@page import="java.util.List"%>
<%@page import="org.eclipse.jdt.internal.compiler.ast.ForeachStatement"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Companies List</title>
</head>
<body>
	<ul>
		<%
			List<Company> companies = (List<Company>) request.getAttribute("companies");
			for (Company company : companies) {
		%>
		<li><%=company.getName()%></li>
		<%
			}
		%>
	</ul>
</body>
</html>