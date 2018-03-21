<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 20.03.2018
  Time: 22:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Restaurant Reservation</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

<div style="align-content: center"  >
  <p>RESTAURANT INFO</p>
</div>
<jsp:useBean id="restaurant" class="com.java.lesson.restaurant.reservation.dto.Restaurant" scope="request"/>

#:  ${restaurant.id} <br/>
Name: <%=restaurant.getName()%><br/>
City: <%=restaurant.getCity()%><br/>
District: <%=restaurant.getDistrict()%><br/>
Street: <%=restaurant.getStreet()%><br/>
House Number: <%=restaurant.getHouseNumber()%><br/>
phone: <%=restaurant.getPhone()%><br/>
Describe: <%=restaurant.getDescribe()%><br/>
Photo: <%=restaurant.getPhoto()%><br/>

<br/><a href="../index.jsp">main page</a>
<br/>
<form action="/myServlet" method="post">
  <p> id: <label><input type="text" name="id" placeholder="id"></label></p>
  <input type="submit" name="showRestaurantById" value="show restaurant">
</form>
<br/>
<form action="/myServlet" method="post">
  <input type="submit" name="showRestaurants" value="show restaurants">
</form>

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>

