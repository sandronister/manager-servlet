<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/company?action=update" var="linkServlet"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${linkServlet}" method="post">
		Empresa: <input type="text" name="companyName" value="${company.name}"/> 
		Data Abertura <input type="text" name="createdat" value="<fmt:formatDate value="${company.createdAt}" pattern="dd/MM/yyyy"/>" />
		<input type="hidden" name="id" value="${company.id}"/>
		<input type="submit" title="Enviar" />
	</form>
</body>
</html>