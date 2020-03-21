<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String companyName = (String)request.getAttribute("company");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Confirmanção cadastro empresa</title>
</head>
<body>
	<h1>Empresa <%=companyName %> cadastrada com sucesso!</h1>
</body>
</html>