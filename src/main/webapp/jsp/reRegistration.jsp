<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 10.03.2018
  Time: 22:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<jsp:useBean id="user" class="com.java.lesson.restaurantcope="request"></jsp:useBean>--%>
<%--<jsp:useBean id="userErr" class="com.java.lesson.restaurantMyServlet" scope="request"></jsp:useBean>--%>
<html>
<head>
  <title>Registration Form</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<jsp:useBean id="user" class="com.java.lesson.restaurant.reservation.dto.UserDto" scope="request"/>
<form action="/myServlet" method="post" style="align-content: center">
  <table style="display: block; margin: auto; text-align: center; border: solid 1px black">
    <th>
      <h1>Users Registration</h1>
    </th>
    <tr>
      <td>
        First Name*: <label><input type="text" name="firstName"
                                   value="<%=request.getAttribute("fName")%>"
                                   placeholder="name" size="15" maxlength="20"><br>
        <span style="font-size: x-small; color: red; "><%=request.getAttribute("errorsFName") != null?request.getAttribute("errorsFName"):request.getAttribute("nullErrors")%></span></label>
      </td>
      <td>
        Second Name*: <input type="text" name="secondName"
                                  value="<%=request.getAttribute("sName")%>"
                                  placeholder="second name" size="15" maxlength="20"><br>
        <span style="font-size: x-small; color: red; "><%=request.getAttribute("errorsSName") != null?request.getAttribute("errorsSName"):request.getAttribute("nullErrors")%></span>
      </td>
    </tr>
    <tr>
      <td>
        Birth Date*: <label><input type="text" name="birthDate"
                                   value="<%=request.getAttribute("birthDate")%>"
                                   placeholder="yyyy-mm-dd" size="15" maxlength="20"></label><br>
        <span style="font-size: x-small; color: red; "><%=request.getAttribute("errorsBirthDate")!=null?request.getAttribute("errorsBirthDate"):request.getAttribute("nullErrors")%></span>
      </td>
    </tr>
    <tr>
      <td>
        Login*: <label><input type="text" name="login" placeholder="login" size="15" maxlength="20"></label><br>
        <span style="font-size: x-small; color: red; "><%=request.getAttribute("errorsLogin")!=null?request.getAttribute("errorsLogin"):request.getAttribute("nullErrors")%></span>
      </td>
      <td>
        Password*: <label><input type="password" name="password" placeholder="password" size="15" maxlength="20"></label><br>
        <span style="font-size: x-small; color: red; "><%=request.getAttribute("errorsPassword")!=null?request.getAttribute("errorsPassword"):request.getAttribute("nullErrors")%></span>
      </td>
    </tr>
    <tr>
      <td>
        E-mail*: <label><input type="email" name="email"
                               value="<%=request.getAttribute("eMail")%>"
                               placeholder="e-mail" size="15" maxlength="20"></label><br>
        <span style="font-size: x-small; color: red; "><%=request.getAttribute("errorsEmail")!=null?request.getAttribute("errorsEmail"):request.getAttribute("nullErrors")%></span>
      </td>
      <td>
        Phone number*: <label><input type="text" name="phone"
                                     value="<%=request.getAttribute("phone")%>"
                                     placeholder="375-**-***-**-**" size="15" maxlength="20"></label><br>
        <span style="font-size: x-small; color: red; "><%=request.getAttribute("errorsPhone")!=null?request.getAttribute("errorsPhone"):request.getAttribute("nullErrors")%></span>
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

<div>

  <%--Test2 : - <%=request.getAttribute("fName")%><br>--%>
  <%--Test2 : - ${user.fName}<br>--%>
  <%--Test2 : - <%=request.getAttribute("errorsFName")%><br>--%>
  <%--Test2 : - ${pageContext}<br>--%>
  <%--Test2 : - ${requestScope.get("eMail")}--%>



</div>

  <%--<input type="submit" name="registration" value="registration">--%>
</form>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
