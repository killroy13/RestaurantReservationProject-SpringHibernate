<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 21.03.2018
  Time: 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Restaurant Reservation</title>
</head>
<body>
<jsp:include page="header.jsp"/>

<form action="/myServlet" method="post" style="align-content: center">
  <table align="center" style="display: block; margin: auto; border: solid 1px black">
    <th>Add New Restaurant</th>
    <tr>
      <td>Restaurant Name*: <label><input type="text" name="restName"
                                          value="<%=request.getAttribute("name")%>"></label>
        <br><span style="font-size: x-small; color: red; "><%=request.getAttribute("errorsName")!=null?request.getAttribute("errorsName"):request.getAttribute("nullErrors")%></span></td>
    </tr>
    <tr>
      <td>city*: <label><input type="text" name="restCity"
                               value="<%=request.getAttribute("city")%>"></label>
        <br><span style="font-size: x-small; color: red; "><%=request.getAttribute("errorsCity")!=null?request.getAttribute("errorsCity"):request.getAttribute("nullErrors")%></span></td>
      <td>district*: <label><input type="text" name="restDistrict"
                                   value="<%=request.getAttribute("district")%>"></label>
        <br><span style="font-size: x-small; color: red; "><%=request.getAttribute("errorsDistrict")!=null?request.getAttribute("errorsDistrict"):request.getAttribute("nullErrors")%></span></td>
    </tr>
    <tr>
      <td>street*: <label><input type="text" name="restStreet"
                                 value="<%=request.getAttribute("street")%>"></label>
        <br><span style="font-size: x-small; color: red; "><%=request.getAttribute("errorsStreet")!=null?request.getAttribute("errorsStreet"):request.getAttribute("nullErrors")%></span></td>
      <td>house number*: <label><input type="text" name="houseNumber"
                                       value="<%=request.getAttribute("houseNumber")%>"></label>
        <br><span style="font-size: x-small; color: red; "><%=request.getAttribute("errorsHouseNumber")!=null?request.getAttribute("errorsHouseNumber"):request.getAttribute("nullErrors")%></span></td>
    </tr>
    <tr>
      <td>phone*: <label><input type="text" name="restPhone" placeholder="375-**-***-**-**"
                                value="<%=request.getAttribute("phone")%>"></label>
        <br><span style="font-size: x-small; color: red; "><%=request.getAttribute("errorsPhone")!=null?request.getAttribute("errorsPhone"):request.getAttribute("nullErrors")%></span></td>
    </tr>
    <tr>
      <td>describe*: <label><textarea name="restDescribe" cols="40" rows="10"><%=request.getAttribute("describe")%></textarea></label><br><span style="font-size: x-small; color: red; "><%=request.getAttribute("errorsDescribe")!=null?request.getAttribute("errorsDescribe"):request.getAttribute("nullErrors")%></span></td>
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

<jsp:include page="footer.jsp"/>
</body>
</html>
