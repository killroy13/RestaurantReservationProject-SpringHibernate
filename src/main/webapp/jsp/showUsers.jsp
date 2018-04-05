<%@ page import="com.java.lesson.restaurant.reservation.dto.User" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  UserDto: UserDto
  Date: 19.03.2018
  Time: 21:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@page%>--%>
<%--<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Restaurant Reservation</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<div style="text-align: center">
    <p>USERS DATA</p>
</div>
<%
    List<User> users = (List<User>) request.getAttribute("users");
%>
<table border="1" align="center"  style="border: solid 1px black; align-content: center; " bgcolor="#EBF1F4">
    <tr>
        <th>ID</th>
        <th>First Name</th>
        <th>Second Name</th>
        <th>Birth Date</th>
        <th>Login</th>
        <th>Password</th>
        <th>E-mail</th>
        <th>Phone number</th>
    </tr>
    <%
        for (User user: users) {
    %>
    <tr>
        <td><%=user.getId()%></td>
        <td><%=user.getfName()%></td>
        <td><%=user.getsName()%></td>
        <td><%=user.getBirthDate()%></td>
        <td><%=user.getLogin()%></td>
        <td><%=user.getPassword()%></td>
        <td><%=user.geteMail()%></td>
        <td><%=user.getPhone()%></td>
    </tr>
    <%
        }
    %>
</table>
<br/>
<a href="/jsp/editUser.jsp">Edit User</a>
<form action="myServlet" method="post">
    <p> id: <label><input type="text" name="idForDelete" placeholder="insert id"></label></p>
    <input type="submit" name="deleteUser" value="delete"/>
</form>
<br/><a href="/index.jsp">main page</a>
<br/>
<jsp:include page="footer.jsp"/>
</body>
</html>
