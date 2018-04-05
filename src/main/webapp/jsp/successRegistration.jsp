<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 13.03.2018
  Time: 11:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration Form</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<jsp:useBean id="user" class="com.java.lesson.restaurant.reservation.dto.User" scope="request"/>
<form action="/myServlet" method="post" style="align-content: center">
    <table style="display: block; margin: auto; text-align: center; border: solid 1px black">
        <th>
            <h1>USER REGISTRATION SUCCESSFUL!</h1>
        </th>
        <tr>
            <td>
                First Name*: <label><%=request.getAttribute("fName")%>
            </label><br>
            </td>
            <td>
                Last Name*: <label><%=request.getAttribute("sName")%>
            </label><br>
            </td>
        </tr>
        <tr>
            <td>
                Birth Date*: <label><%=request.getAttribute("birthDate")%>
            </label><br>
            </td>
        </tr>
        <tr>
            <td>
            </td>
            <td>
            </td>
        </tr>
        <tr>
            <td>
                E-mail*: <label><%=request.getAttribute("eMail")%>
            </td>
            <td>
                Phone number*: <label><%=request.getAttribute("phone")%>
            </label><br>
            </td>
        </tr>
        <tr>
            <th>
            </th>
            <th>
                <%--<small>--%>
                    <%--<input type="submit" name="cancel" value="Exit">--%>
                <%--</small>--%>
            </th>
        </tr>
    </table>
    <div>
        <p><a href="/index.jsp">Home</a></p>
    </div>
</form>
<jsp:include page="footer.jsp"/>
</body>
</html>
