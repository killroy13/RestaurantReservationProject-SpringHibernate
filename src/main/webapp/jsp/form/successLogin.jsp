<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 10.03.2018
  Time: 17:21
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Restaurant Reservation</title>
</head>
<body>
<jsp:useBean id="user" class="com.java.lesson.restaurant.reservation.dto.User" scope="request"/>
<h1>Hello! <%=session.getAttribute("name")%>  <%=session.getAttribute("sName")%>
</h1>


login = <%=session.getAttribute("name")%><br/>
password = <%=session.getAttribute("sName")%><br/>
session id = <%=session.getId()%><br>

<%--Id:  ${user.id} <br/>--%>
<%--UserDto name: <%=request.getAttribute("name")%><br/>--%>
<%--UserDto last_name: <%=request.getAttribute("second")%><br/>--%>
<%--login: ${user.login}<br/>--%>
<%--password: ${user.password}<br/>--%>
<%--e_mail: ${user.eMail}<br/>--%>
<%--phone: ${user.phone}<br/>--%>

<%--<%=request.getRequestedSessionId()%>--%>




<br/><a href="../../index.jsp">main page</a>
<br/>
<jsp:include page="/jsp/footer.jsp"></jsp:include>
</body>
</html>
