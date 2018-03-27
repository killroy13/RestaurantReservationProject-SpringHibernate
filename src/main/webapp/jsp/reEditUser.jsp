<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 17.03.2018
  Time: 13:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Restaurant Reservation</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<%--<jsp:useBean id="user" class="com.java.lesson.restaurant.reservation.dto.UserDtoDto" scope="request"/>--%>

<form action="/myServlet" method="post">
  <p> id: <label><input type="text" name="id"
                        placeholder="id"
                        value="<%=request.getAttribute("id")%>"></label></p>
  <span style="font-size: x-small; color: red; "><%=request.getAttribute("errorId") != null?request.getAttribute("errorId"):request.getAttribute("nullErrors")%></span>
  <p> имя: <label><input type="text" name="firstName"
                         placeholder="name"
                         value="<%=request.getAttribute("fName")%>"></label></p>
  <span style="font-size: x-small; color: red; "><%=request.getAttribute("errorsFName") != null?request.getAttribute("errorsFName"):request.getAttribute("nullErrors")%></span>
  <p> фамилия: <label><input type="text" name="secondName"
                             placeholder="second name"
                             value="<%=request.getAttribute("sName")%>"></label></p>
  <span style="font-size: x-small; color: red; "><%=request.getAttribute("errorsSName") != null?request.getAttribute("errorsSName"):request.getAttribute("nullErrors")%></span>
  <p> дата рождения: <label><input type="text" name="birthDate"
                                   placeholder="yyyy-mm-dd"
                                   value="<%=request.getAttribute("birthDate")%>"></label></p>
  <span style="font-size: x-small; color: red; "><%=request.getAttribute("errorsBirthDate")!=null?request.getAttribute("errorsBirthDate"):request.getAttribute("nullErrors")%></span>

  <p> логин: <label><input type="text" name="login"
                           placeholder="login"
                           value="<%=request.getAttribute("login")%>"></label></p>
  <span style="font-size: x-small; color: red; "><%=request.getAttribute("errorsLogin")!=null?request.getAttribute("errorsLogin"):request.getAttribute("nullErrors")%></span>

  <p> пароль: <label><input type="password" name="password"
                            placeholder="password"></label></p>
  <span style="font-size: x-small; color: red; "><%=request.getAttribute("errorsPassword")!=null?request.getAttribute("errorsPassword"):request.getAttribute("nullErrors")%></span>

  <p> e-mail: <label><input type="email" name="email"
                            placeholder="e-mail"
                            value="<%=request.getAttribute("eMail")%>"></label></p>
  <span style="font-size: x-small; color: red; "><%=request.getAttribute("errorsEmail")!=null?request.getAttribute("errorsEmail"):request.getAttribute("nullErrors")%></span>

  <p> тел.: <label><input type="text" name="phone"
                          placeholder="375-**-***-**-**"
                          value="<%=request.getAttribute("phone")%>"></label></p>
  <span style="font-size: x-small; color: red; "><%=request.getAttribute("errorsPhone")!=null?request.getAttribute("errorsPhone"):request.getAttribute("nullErrors")%></span>

  <br><input type="submit" name="updateUser" value="edit"/>

</form>

<div>
    <p><a href="/index.jsp">Home</a></p>
</div>

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
