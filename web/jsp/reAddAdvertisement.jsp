<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 21.03.2018
  Time: 14:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Restaurant Reservation</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

<h1>New Offers</h1>
<form action="/myServlet" method="post">
  <p> Restaurant offer*: <label><textarea name="offerText" cols="40" rows="10"><%=request.getAttribute("offerText")%></textarea></label></p>
  <span style="font-size: x-small; color: red; "><%=request.getAttribute("errorsOfferText") != null?request.getAttribute("errorsOfferText"):request.getAttribute("nullErrors")%></span>
  <p> Restaurant (id)*: <label><input type="text" name="restaurantId" placeholder="id"
                                      value="<%=request.getAttribute("restaurantId")%>"></label></p>
  <span style="font-size: x-small; color: red; "><%=request.getAttribute("errorsRestaurantId") != null?request.getAttribute("errorsRestaurantId"):request.getAttribute("nullErrors")%></span>
  <br><input type="submit" name="addAdvertisement" value="Add"/>
</form>

<div>
  <p><a href="/index.jsp">Home</a></p>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
