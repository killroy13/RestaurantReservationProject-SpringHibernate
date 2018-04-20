<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 10.03.2018
  Time: 17:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Форма входа в систему</title>




</head>
<body>
<br>

<h1>Вход в систему</h1>

<form name="form" action="<%--../..--%>/myServlet" method="post">
    Login:<input type="text" name="login" <%--size="10"--%> placeholder="enter login"><br/>
    Password:<label>
    <input type="password" name="password" size="10">
</label><br/>

    <p>
    <table>
        <tr>
            <th>
                <small>
                    <input type="submit" name="login" value="Login">
                </small>
            </th>
            <th>
                <small>
                    <input type="submit" name="registration" value="Registration" formaction="/jsp/registration.jsp">
                </small>
            </th>
        </tr>
    </table>
    <%--</p>--%>
</form>

<br/>
<jsp:include page="/jsp/footer.jsp"/>
</body>
</html>
