<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 10.03.2018
  Time: 13:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page isErrorPage="true" contentType="text/html;charset=UTF-8" language="java" %>

<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<%--<%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %>--%>
<%--<c: out></c:>--%>

<div
        style="background-color:lavender; text-align: center; padding: 5px; margin-top: 30px;">
    <div>
        <h1>Restaurant Reservation</h1>
    </div>

    <%--<c:set var="name1" scope="session" value="null"/>--%>

    <%--<c:choose>--%>
        <%--<c:when test="null">--%>
            <%--<p>NULL</p>--%>
        <%--</c:when>--%>
        <%--<c:otherwise>--%>
            <%--<p>NOT NULL</p>--%>
        <%--</c:otherwise>--%>
    <%--</c:choose>--%>



    <div style=" text-align: right">


        <%--<c:chose>--%>
        <%--<c:when <%=session.getAttribute("name")%> == null>--%>
        <div id="registration" align="right" style="display: inline-block">
            <p><a href="/jsp/registration.jsp">Registration</a></p>
        </div>
        <div id="login" align="right" style="display: inline-block">
            <p><a href="/jsp/form/login.jsp">Login</a></p>
        </div>
        <%--</c:when>--%>
        <%--<c:otherwise>--%>
        <div align="right" style="display: inline-block">
            <p>
                <a href="/jsp/form/successLogin.jsp"><%=session.getAttribute("name")%> <%=session.getAttribute("sName")%>
                </a></p>
        </div>
        <form action="myServlet" method="post">
            <small>
                <input type="submit" name="logout" value="Logout">
            </small>
        </form>
        <%--</c:otherwise>--%>
        <%--</c:chose>--%>

    </div>
</div>

