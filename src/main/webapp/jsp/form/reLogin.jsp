<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 19.03.2018
  Time: 15:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<jsp:useBean id="user" class="com.java.lesson.restaurant.reservation.dto.UserDtoDto" scope="request">--%>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Форма входа в систему</title>

  <%--<script>--%>
  <%--function validate()--%>
  <%--{--%>
  <%--var username = document.form.login.value;--%>
  <%--var password = document.form.password.value;--%>

  <%--if (username==null || username=="")--%>
  <%--{--%>
  <%--alert("Username cannot be blank");--%>
  <%--return false;--%>
  <%--}--%>
  <%--else if(password==null || password=="")--%>
  <%--{--%>
  <%--alert("Password cannot be blank");--%>
  <%--return false;--%>
  <%--}--%>
  <%--}--%>
  <%--</script>--%>

</head>
<body>
<br>

<h1>Вход в систему</h1>

<form name="form" action="<%--../..--%>/myServlet" method="post">
  Login:<input type="text" name="login" <%--size="10"--%>
               placeholder="enter login"
               value="<%=request.getAttribute("login")%>"><br/>
  <span style="font-size: x-small; color: red; "><%=request.getAttribute("errorsLogin")!=null?request.getAttribute("errorsLogin"):request.getAttribute("nullErrors")%></span>
  <br/>
  Password:<label>
  <input type="password" name="password" size="10"
         value="">
</label><br/>
  <span style="font-size: x-small; color: red; "><%=request.getAttribute("errorsPassword")!=null?request.getAttribute("errorsPassword"):request.getAttribute("nullErrors")%></span>  <br/>

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
</form>
<br/>
<jsp:include page="/jsp/footer.jsp"></jsp:include>
</body>
</html>