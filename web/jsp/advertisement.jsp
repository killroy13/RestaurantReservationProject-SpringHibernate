<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 21.03.2018
  Time: 12:32
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
  <p>ADVERTISEMENT INFO</p>
</div>
<jsp:useBean id="advertisement" class="com.java.lesson.restaurant.reservation.dto.Advertisement" scope="request"/>

#:  ${advertisement.id} <br/>
Restaurants Offer: <%=advertisement.getOfferText()%><br/>
Restaurant id: <%=advertisement.getRestaurantId()%><br/>

<br/><a href="../index.jsp">main page</a>
<br/>
<form action="/myServlet" method="post">
  <p> id: <label><input type="text" name="id" placeholder="id"></label></p>
  <input type="submit" name="showAdvertisementById" value="show advertisement">
</form>
<br/>
<form action="/myServlet" method="post">
  <input type="submit" name="showAdvertisements" value="show advertisements">
</form>

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
