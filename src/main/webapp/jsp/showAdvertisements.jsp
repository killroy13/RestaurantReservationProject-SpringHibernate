<%@ page import="com.java.lesson.restaurant.reservation.dto.Advertisement" %>
<%@ page import="java.util.List" %>
<%@ page
        import="static com.java.lesson.restaurant.reservation.attributes.RestaurantReservationAttributes.ADVERTISEMENT_DTO" %>
<%--
  Created by IntelliJ IDEA.
  UserDto: UserDto
  Date: 21.03.2018
  Time: 13:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Restaurant Reservation</title>
</head>


<body>
<jsp:include page="header.jsp"/>
<div style="text-align: center">
    <p>ADVERTISEMENTS DATA</p>
</div>

<div id="advdata">

<%
    List<Advertisement> advertisements = (List<Advertisement>) request.getAttribute(ADVERTISEMENT_DTO);
%>
<table border="1" align="center" style="border: solid 1px black; align-content: center; " bgcolor="#EBF1F4">
    <tr>
        <th>ID</th>
        <th>Restaurant Offer</th>
        <th>Restaurant (id)</th>
    </tr>
    <%
        for (Advertisement advertisement : advertisements) {
    %>
    <tr>
        <td><%=advertisement.getId()%>
        </td>
        <td><%=advertisement.getOfferText()%>
        </td>
        <td><%=advertisement.getRestaurantId()%>
        </td>
    </tr>
    <%
        }
    %>
</table><br/>

</div>

<a <%--href="/jsp/editAdvertisement.jsp"--%>>Edit Advertisement</a> / <a href="/jsp/addAdvertisement.jsp">Add New
    Advertisement</a>

<form action="myServlet" method="post">
    <p> id: <label><input type="text" name="advertisementIdForDelete" placeholder="insert id for del"></label></p>
    <input type="submit" name="deleteAdvertisement" value="delete"/>
</form>




<form id="fordel">
    <input type="text" id="delid">
    <input id="deladv" type="button" name="deleteAdvertisementAjax" value="test request">

    <div id="result"></div>
    <script src="../js/javascript.js"></script>

</form>





<br/><a href="/index.jsp">main page</a>
<br/>
<jsp:include page="footer.jsp"/>
</body>
</html>
