<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 19.03.2018
  Time: 20:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Restaurant Reservation</title>
</head>
<body>
<jsp:include page="header.jsp"/>

<div style="align-content: center">
    <p>SUCCESSFUL! User <%=request.getAttribute("id")%> is removed</p>
</div>

<br/><form action="/myServlet" method="get">
    <input type="submit" name="showUsers" value="show users">
</form>
<br/><a href="/index.jsp">main page</a>
<br/>


<jsp:include page="footer.jsp"/>
</body>
</html>


