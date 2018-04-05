<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 07.03.2018
  Time: 11:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Restaurant Reservation</title>
</head>
<body>
<jsp:include page="header.jsp"/>


<form action="/myServlet" method="post" style="align-content: center">
    <table style="display: block; margin: auto; text-align: center; border: solid 1px black">
        <th>
            <h1>Users Registration</h1>
        </th>
        <tr>
            <td>
                First Name*: <label><input type="text" name="firstName" placeholder="first name" size="15"
                                           maxlength="20"></label>
            </td>
            <td>
                Second Name*: <label><input type="text" name="secondName" placeholder="second name" size="15"
                                            maxlength="20"></label>
            </td>
        </tr>
        <tr>
            <td>
                Birth Date*: <label><input type="text" name="birthDate" placeholder="yyyy-mm-dd" size="15"
                                           maxlength="20"></label>
            </td>
        </tr>
        <tr>
            <td>
                Login*: <label><input type="text" name="login" placeholder="login" size="15" maxlength="20"></label>
            </td>
            <td>
                Password*: <label><input type="password" name="password" placeholder="password" size="15"
                                         maxlength="20"></label>
            </td>
        </tr>
        <tr>
            <td>
                E-mail*: <label><input type="email" name="email" placeholder="e-mail" size="15" maxlength="20"></label>
            </td>
            <td>
                Phone number*: <label><input type="text" name="phone" placeholder="375-**-***-**-**" size="15"
                                             maxlength="20"></label>
            </td>
        </tr>
        <tr>
            <th>
                <small>
                    <input type="submit" name="insertUser" value="Save"/>
                </small>
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
    <%--<input type="submit" name="registration" value="registration">--%>
</form>
<jsp:include page="footer.jsp"/>
</body>
</html>
