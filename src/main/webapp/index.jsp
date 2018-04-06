<%@ page import="java.sql.Connection" %>
<%--
  Created by IntelliJ IDEA.
  UserDto: UserDto
  Date: 08.02.2018
  Time: 21:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="CONTENT-TYPE" content="text/html; charset=UTF-8">
    <title>Restaurant Reservation</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
<div>
    <jsp:include page="jsp/header.jsp"/>
    <jsp:include page="jsp/adminPanel.jsp"/>
</div>

<div id="" style="display: block;
    padding: 16px 5px 0;
    ">

    <div style="border: solid black 1px;
         display: block;
         float: left;
         padding:16px 0.5% 0 0!important;
         height: 507px;
         width: 269px;">

    </div>
    <div style="border: solid black 1px;
        display: block;
        padding:16px 0.5% 0 0!important;
        float: right;
        height: 507px;
        width: 269px;">
    </div>
</div>


<div style="display: block;
    ">
    <jsp:include page="jsp/footer.jsp"/>
</div>

</body>
</html>
