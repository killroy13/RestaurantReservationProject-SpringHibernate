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
<jsp:include page="header.jsp"/>
<form action="/myServlet" method="post">
    <p> id: <label><input type="text" name="id" placeholder="id"
                          value="<%=request.getAttribute("id")%>"></label></p>
    <span style="font-size: x-small; color: red; "><%=request.getAttribute("errorId") != null?request.getAttribute("errorId"):request.getAttribute("nullErrors")%></span>

    <p> Name: <label><input type="text" name="restName" placeholder="name"
                            value="<%=request.getAttribute("name")%>"></label></p>
    <span style="font-size: x-small; color: red; "><%=request.getAttribute("errorsName") != null?request.getAttribute("errorsName"):request.getAttribute("nullErrors")%></span>

    <p> city: <label><input type="text" name="restCity" placeholder="City"
                            value="<%=request.getAttribute("city")%>"></label></p>
    <span style="font-size: x-small; color: red; "><%=request.getAttribute("errorsCity") != null?request.getAttribute("errorsCity"):request.getAttribute("nullErrors")%></span>

    <p> district: <label><input type="text" name="restDistrict" placeholder="District"
                                value="<%=request.getAttribute("district")%>"></label></p>
    <span style="font-size: x-small; color: red; "><%=request.getAttribute("errorsDistrict") != null?request.getAttribute("errorsDistrict"):request.getAttribute("nullErrors")%></span>

    <p> street: <label><input type="text" name="restStreet" placeholder="Street"
                              value="<%=request.getAttribute("street")%>"></label></p>
    <span style="font-size: x-small; color: red; "><%=request.getAttribute("errorsStreet") != null?request.getAttribute("errorsStreet"):request.getAttribute("nullErrors")%></span>

    <p> house number: <label><input type="text" name="houseNumber" placeholder="house number"
                                    value="<%=request.getAttribute("houseNumber")%>"></label></p>
    <span style="font-size: x-small; color: red; "><%=request.getAttribute("errorsHouseNumber") != null?request.getAttribute("errorsHouseNumber"):request.getAttribute("nullErrors")%></span>

    <p> phone: <label><input type="text" name="restPhone" placeholder="375-**-***-**-**"
                             value="<%=request.getAttribute("phone")%>"></label></p>
    <span style="font-size: x-small; color: red; "><%=request.getAttribute("errorsPhone") != null?request.getAttribute("errorsPhone"):request.getAttribute("nullErrors")%></span>

    <p> describe: <label>
        <textarea name="restDescribe" cols="40" rows="10"><%=request.getAttribute("describe")%></textarea></label></p>
    <span style="font-size: x-small; color: red; "><%=request.getAttribute("errorsDescribe") != null?request.getAttribute("errorsDescribe"):request.getAttribute("nullErrors")%></span>

    <p> photo: <label><input type="text" name="restPhoto" placeholder="links to photo"></label></p>
    <input type="submit" name="updateRestaurant" value="edit"/>
</form>
<div>
    <p><a href="/index.jsp">Home</a></p>
</div>

<jsp:include page="footer.jsp"/>
</body>
</html>