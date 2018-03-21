<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 21.03.2018
  Time: 1:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Restaurant Reservation</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div style="align-content: center">
  <p>SUCCESSFUL! Restaurant is update!</p>
</div>

id:  <%=request.getAttribute("id")%> <br/>
Name: <%=request.getAttribute("name")%><br/>
city: <%=request.getAttribute("city")%><br/>
district: <%=request.getAttribute("district")%><br/>
street: <%=request.getAttribute("street")%><br/>
house number: <%=request.getAttribute("houseNumber")%><br/>
phone: <%=request.getAttribute("phone")%><br/>
describe: <%=request.getAttribute("describe")%><br/>
photo: <%=request.getAttribute("photo")%><br/>

<br/>
<form action="/myServlet" method="post">
  <input type="submit" name="showRestaurants" value="show restaurants">
</form>
<br/><a href="/index.jsp">main page</a>
<br/>


<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
