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
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Restaurant Reservation</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<div style="align-content: center">
  <p>SUCCESSFUL! Offer of <%=request.getAttribute("restaurantId")%> is added</p>
  <p>Text Offer: <%=request.getAttribute("offerText")%> </p>
</div>

<br/>
<form action="/myServlet" method="post">
  <input type="submit" name="showAdvertisements" value="show advertisements">
</form>
<br/><a href="/index.jsp">main page</a>
<br/>


<jsp:include page="footer.jsp"/>
</body>
</html>