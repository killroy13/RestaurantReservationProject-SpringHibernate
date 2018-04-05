<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 21.03.2018
  Time: 0:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Restaurant Reservation</title>
</head>
<body>
<jsp:include page="header.jsp"/>

<form action="/myServlet" method="post">
  <p> id: <label><input type="text" name="id" placeholder="id"></label></p>
  <p> Name: <label><input type="text" name="restName" placeholder="name"></label></p>
  <p> city: <label><input type="text" name="restCity" placeholder="City"></label></p>
  <p> district: <label><input type="text" name="restDistrict" placeholder="District"></label></p>
  <p> street: <label><input type="text" name="restStreet" placeholder="Street"></label></p>
  <p> house number: <label><input type="text" name="houseNumber" placeholder="house number"></label></p>
  <p> phone: <label><input type="text" name="restPhone" placeholder="375-**-***-**-**"></label></p>
  <p> describe: <label><textarea name="restDescribe" cols="40" rows="10"></textarea></label></p>
  <p> photo: <label><input type="text" name="restPhoto" placeholder="photo"></label></p>
  <input type="submit" name="updateRestaurant" value="edit"/>
</form>
<div>
  <p><a href="/index.jsp">Home</a></p>
</div>

<jsp:include page="footer.jsp"/>
</body>
</html>
