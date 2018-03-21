<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 21.03.2018
  Time: 0:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Restaurant Reservation</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<form action="/myServlet" method="post">
    <p> id: <label><input type="text" name="id" placeholder="id"
                          value="<%=request.getAttribute("id")%>"></label></p>
    <font size="2" color="red"><%=request.getAttribute("errorId") != null?request.getAttribute("errorId"):request.getAttribute("nullErrors")%></font>

    <p> Name: <label><input type="text" name="restName" placeholder="name"
                            value="<%=request.getAttribute("name")%>"></label></p>
    <font size="2" color="red"><%=request.getAttribute("errorsName") != null?request.getAttribute("errorsName"):request.getAttribute("nullErrors")%></font>

    <p> city: <label><input type="text" name="restCity" placeholder="City"
                            value="<%=request.getAttribute("city")%>"></label></p>
    <font size="2" color="red"><%=request.getAttribute("errorsCity") != null?request.getAttribute("errorsCity"):request.getAttribute("nullErrors")%></font>

    <p> district: <label><input type="text" name="restDistrict" placeholder="District"
                                value="<%=request.getAttribute("district")%>"></label></p>
    <font size="2" color="red"><%=request.getAttribute("errorsDistrict") != null?request.getAttribute("errorsDistrict"):request.getAttribute("nullErrors")%></font>

    <p> street: <label><input type="text" name="restStreet" placeholder="Street"
                              value="<%=request.getAttribute("street")%>"></label></p>
    <font size="2" color="red"><%=request.getAttribute("errorsStreet") != null?request.getAttribute("errorsStreet"):request.getAttribute("nullErrors")%></font>

    <p> house number: <label><input type="text" name="houseNumber" placeholder="house number"
                                    value="<%=request.getAttribute("houseNumber")%>"></label></p>
    <font size="2" color="red"><%=request.getAttribute("errorsHouseNumber") != null?request.getAttribute("errorsHouseNumber"):request.getAttribute("nullErrors")%></font>

    <p> phone: <label><input type="text" name="restPhone" placeholder="375-**-***-**-**"
                             value="<%=request.getAttribute("phone")%>"></label></p>
    <font size="2" color="red"><%=request.getAttribute("errorsPhone") != null?request.getAttribute("errorsPhone"):request.getAttribute("nullErrors")%></font>

    <p> describe: <label>
        <textarea name="restDescribe" cols="40" rows="10"><%=request.getAttribute("describe")%></textarea></label></p>
    <font size="2" color="red"><%=request.getAttribute("errorsDescribe") != null?request.getAttribute("errorsDescribe"):request.getAttribute("nullErrors")%></font>

    <p> photo: <label><input type="text" name="restPhoto" placeholder="links to photo"></label></p>
    <input type="submit" name="updateRestaurant" value="edit"/>
</form>
<div>
    <p><a href="/index.jsp">Home</a></p>
</div>

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>