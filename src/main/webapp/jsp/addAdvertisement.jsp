<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 21.03.2018
  Time: 14:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Restaurant Reservation</title>
</head>
<body>
<jsp:include page="header.jsp"/>

<h1>New Offers</h1>
<form action="/myServlet" method="post">
    <p> Restaurant offer*: <label><textarea name="offerText" cols="40" rows="10"></textarea></label></p>

    <p> Restaurant (id)*: <label><input type="text" name="restaurantId" placeholder="id"></label></p>
    <input type="submit" name="addAdvertisement" value="Add"/>
</form>

<div>
    <p><a href="/index.jsp">Home</a></p>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>
