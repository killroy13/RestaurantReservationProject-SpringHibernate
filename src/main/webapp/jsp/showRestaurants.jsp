<%@ page import="com.java.lesson.restaurant.reservation.dto.RestaurantDto" %>
<%@ page import="java.util.List" %>
<%--<%@ page import="com.java.lesson.restaurant.reservation.dto.RestaurantDtoDto" %>--%>
<%--<%@ page import="java.util.List" %>--%>
<%--
  Created by IntelliJ IDEA.
  UserDto: UserDto
  Date: 20.03.2018
  Time: 21:55
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
<div style="text-align: center">
  <p>RESTAURANTS DATA</p>
</div>
<%
  List<RestaurantDto> restaurants = (List<RestaurantDto>) request.getAttribute("restaurants");
%>
<table border="1" align="center"  style="border: solid 1px black; align-content: center; " bgcolor="#EBF1F4">
  <tr>
    <th>ID</th>
    <th>Restaurant Name</th>
    <th>City</th>
    <th>District</th>
    <th>Street</th>
    <th>House number</th>
    <th>Phone number</th>
    <th>Describe</th>
    <th>Photo</th>
  </tr>
  <%
    for (RestaurantDto restaurant: restaurants) {
  %>
  <tr>
    <td><%=restaurant.getId()%></td>
    <td><%=restaurant.getName()%></td>
    <td><%=restaurant.getCity()%></td>
    <td><%=restaurant.getDistrict()%></td>
    <td><%=restaurant.getStreet()%></td>
    <td><%=restaurant.getHouseNumber()%></td>
    <td><%=restaurant.getPhone()%></td>
    <td><%=restaurant.getDescribe()%></td>
    <td><%=restaurant.getPhoto()%></td>
  </tr>
  <%
    }
  %>
</table>
<br/>
<a href="/jsp/editRestaurant.jsp">Edit Restaurant</a> / <a href="/jsp/addRestaurant.jsp">Add New Restaurant</a>
<form action="myServlet" method="post">
  <p> id: <label><input type="text" name="restaurantIdForDelete" placeholder="insert id"></label></p>
  <input type="submit" name="deleteRestaurant" value="delete"/>
</form>
<br/><a href="/index.jsp">main page</a>
<br/>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>