<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Confirmanção cadastro empresa</title>
</head>
<body>
	<c:if test="${not empty company }">
		<h1>Empresa ${ company } cadastrada com sucesso!</h1>
	</c:if>
	
	<c:if test="${empty company }">
		<h1>Empresa não foi cadastrada com sucesso!</h1>
	</c:if>
</body>
</html>