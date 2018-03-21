<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 10.03.2018
  Time: 15:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

<form action="/myServlet" method="post">
  <p> id: <label><input type="text" name="id" placeholder="id"></label></p>
  <p> имя: <label><input type="text" name="firstName" placeholder="name"></label></p>
  <p> фамилия: <label><input type="text" name="secondName" placeholder="second name"></label></p>
  <p> дата рождения: <label><input type="text" name="birthDate" placeholder="yyyy-mm-dd"></label></p>
  <p> логин: <label><input type="text" name="login" placeholder="login"></label></p>
  <p> пароль: <label><input type="password" name="password" placeholder="password"></label></p>
  <p> e-mail: <label><input type="email" name="email" placeholder="e-mail"></label></p>
  <p> тел.: <label><input type="text" name="phone" placeholder="375-**-***-**-**"></label></p>
  <input type="submit" name="updateUser" value="edit"/>
  <%--<small>--%>
    <%--<input type="submit" name="cancel" value="Exit">--%>
  <%--</small>--%>
</form>
<div>
  <p><a href="/index.jsp">Home</a></p>
</div>

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
