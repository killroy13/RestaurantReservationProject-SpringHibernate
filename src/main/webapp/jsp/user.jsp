<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 10.03.2018
  Time: 0:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@page import="com.java.lesson.restaurant>--%>
<html>
<head>
    <title>Restaurant Reservation</title>
</head>
<body>
<jsp:include page="header.jsp"/>

<div style="align-content: center"  >
    <p>USER INFO</p>
</div>
<jsp:useBean id="user" class="com.java.lesson.restaurant.reservation.dto.User" scope="request"/>

#:  ${user.id} <br/>
<%--EL - Expression Language--%>
<%--Id:<%=user.getId()%><br/>--%>
User name: <%=user.getfName()%><br/>
User last_name: <%=user.getsName()%><br/>
login: <%=user.getLogin()%><br/>
e_mail: <%=user.geteMail()%><br/>
phone: <%=user.getPhone()%><br/>
<br/><a href="../index.jsp">main page</a>
<br/>
<form action="/myServlet" method="post">
    <p> id: <label><input type="text" name="id" placeholder="insert id"></label></p>
    <input type="submit" name="showUserById" value="show user">
</form>
<br/>
<form action="/myServlet" method="post">
    <input type="submit" name="showUsers" value="show users">
</form>

<jsp:include page="footer.jsp"/>
</body>
</html>
