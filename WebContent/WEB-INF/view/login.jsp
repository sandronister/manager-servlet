<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/user?action=doLogin" var="linkServlet"/>
<html>
<body>
	<form action="${linkServlet}" method="post">
		Login: <input type="text" name="login"/>
		Senha <input type="password" name="password"/>
		<input type="submit" title="Enviar"/>
	</form>
	
</body>
</html>