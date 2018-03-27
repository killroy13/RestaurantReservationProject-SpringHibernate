<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 21.03.2018
  Time: 11:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Restaurant Reservation</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

<div style="align-content: center">
    <p>SUCCESSFUL! Restaurant <%=request.getAttribute("id")%> is removed</p>
</div>

<br/><form action="/myServlet" method="get">
    <input type="submit" name="showRestaurants" value="show restaurants">
</form>
<br/><a href="/index.jsp">main page</a>
<br/>

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
