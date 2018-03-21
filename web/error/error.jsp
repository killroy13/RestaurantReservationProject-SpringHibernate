<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 05.03.2018
  Time: 17:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<jsp:useBean id="error" scope="page" class="com.java.lesson.restaurant.reservation.controller.MyServlet"></jsp:useBean>--%>

<html>
<head>
    <title>Error</title>
</head>
<body>
<jsp:include page="../jsp/header.jsp"></jsp:include>
<div>
  <p><a href="../index.jsp">Home</a></p>
  <p><h1>Incorrect or empty data... Sorry, please try again!</h1>
  <%--<p>Error: ${error}</p>--%>
  <span style="color: red"><%=request.getAttribute("error")!= null?request.getAttribute("error"):' '%>

</div>

<jsp:include page="../jsp/footer.jsp"></jsp:include>
</body>
</html>
