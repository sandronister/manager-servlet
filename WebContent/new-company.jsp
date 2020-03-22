<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/company" var="linkServlet"/>
<html>
<body>
	<form action="${linkServlet}" method="post">
		Empresa: <input type="text" name="companyName"/>
		Data Abertura <input type="text" name="createdat"/>
		<input type="submit" title="Enviar"/>
	</form>
	
</body>
</html>