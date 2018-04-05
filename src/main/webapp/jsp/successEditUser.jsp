<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 19.03.2018
  Time: 21:01
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
  <p>SUCCESSFUL! User is update!</p>
</div>

Id:  <%=request.getAttribute("id")%> <br/>
User name: <%=request.getAttribute("fName")%><br/>
User last_name: <%=request.getAttribute("sName")%><br/>
login: <%=request.getAttribute("login")%><br/>
e_mail: <%=request.getAttribute("eMail")%><br/>
phone: <%=request.getAttribute("phone")%><br/>

<br/><form action="/myServlet" method="get">
  <input type="submit" name="showUsers" value="show users">
</form>
<br/><a href="/index.jsp">main page</a>
<br/>


<jsp:include page="footer.jsp"/>
</body>
</html>
