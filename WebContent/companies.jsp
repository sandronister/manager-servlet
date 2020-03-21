<%@page import="br.com.sandroni.manager.model.Company"%>
<%@page import="java.util.List"%>
<%@page import="org.eclipse.jdt.internal.compiler.ast.ForeachStatement"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Companies List Java Tag Libs</title>
</head>
<body>

	<ul>
		<c:forEach items="${companies}" var="company">
			<li>${company.name }</li>
		</c:forEach>
	</ul>
</body>
</html>