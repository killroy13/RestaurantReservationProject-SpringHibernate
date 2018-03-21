<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 21.03.2018
  Time: 10:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Restaurant Reservation</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

<form action="/myServlet" method="post" style="align-content: center">
    <table align="center" style="display: block; margin: auto; border: solid 1px black">
        <th>Add New Restaurant</th>
        <tr>
            <td>Restaurant Name*: <label><input type="text" name="restName"></label></td>
        </tr>
        <tr>
            <td>city*: <label><input type="text" name="restCity"></label></td>
            <td>district*: <label><input type="text" name="restDistrict"></label></td>
        </tr>
        <tr>
            <td>street*: <label><input type="text" name="restStreet"></label></td>
            <td>house number*: <label><input type="text" name="houseNumber"></label></td>
        </tr>
        <tr>
            <td>phone*: <label><input type="text" name="restPhone" placeholder="375-**-***-**-**"></label></td>
        </tr>
        <tr>
            <td>describe*: <label><textarea name="restDescribe" cols="40" rows="10"></textarea></label></td>
        </tr>
        <tr>
            <td>photo: <label><input type="text" name="restPhoto2"></label></td>
        </tr>
        <tr>
            <th>
                <small>
                    <input type="submit" name="insertRestaurant" value="Save"/>
                </small>
            </th>
            <th>
            </th>
        </tr>
    </table>
    <div>
        <p><a href="/index.jsp">Home</a></p>
    </div>
</form>

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
