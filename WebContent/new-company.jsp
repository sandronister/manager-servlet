<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/company" var="linkServlet"/>
<html>
<body>
	<form action="${linkServlet}" method="post">
		<input type="text" name="companyName"/>
		<input type="submit" title="Enviar"/>
	</form>
	
</body>
</html>