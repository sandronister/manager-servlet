<%@page import="br.com.sandroni.manager.model.Company"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Companies List Java Tag Libs</title>
</head>
<body>
	<c:import url="logout-parcial.jsp"/>
	User Login ${userLogin.login}
	<br/>
	<br/>
	<ul>
		<c:forEach items="${companies}" var="company">
			<li>
			    ${company.name } -  <fmt:formatDate value="${company.createdAt}" pattern="dd/MM/yyyy"/>
			    <a href="/manager/company?action=delete&id=${company.id}" data-confirm="Tem certeza" data-method="delete">Remover</a>
			    <a href="/manager/company?action=read&id=${company.id}">Editar</a>
			</li>
		</c:forEach>
	</ul>
</body>
</html>