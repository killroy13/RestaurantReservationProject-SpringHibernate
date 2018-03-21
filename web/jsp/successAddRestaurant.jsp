<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 21.03.2018
  Time: 11:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Restaurant Reservation</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

<form action="/myServlet" method="post" style="align-content: center">
  <table align="center" style="display: block; margin: auto; border: solid 1px black">
    <th><h1>Restaurant is Added!</h1></th>
    <tr>
      <td>Restaurant Name*: <label><%=request.getAttribute("name")%></label></td>
    </tr>
    <tr>
      <td>city*: <label><%=request.getAttribute("city")%></label></td>
      <td>district*: <label><%=request.getAttribute("district")%></label></td>
    </tr>
    <tr>
      <td>street*: <label><%=request.getAttribute("street")%></label></td>
      <td>house number*: <label><%=request.getAttribute("houseNumber")%></label></td>
    </tr>
    <tr>
      <td>phone*: <label><%=request.getAttribute("phone")%></label></td>
    </tr>
    <tr>
      <td>describe*: <label><%=request.getAttribute("describe")%></label></td>
    </tr>
    <tr>
      <td>photo: <label></label></td>
    </tr>
    <tr>
    </tr>
  </table>
  <div>
    <p><a href="/index.jsp">Home</a></p>
  </div>
</form>

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
