<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 21.03.2018
  Time: 12:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Restaurant Reservation</title>

    <%-- ******  Ajax  ***** --%>
    <%--<script> function showAdv() {--%>
    <%--var request = new XMLHttpRequest();--%>
    <%--var sForm = document.getElementById('someForm');--%>
    <%--var id = sForm.elements.id.value;--%>
    <%--request.open('GET', '../users' + '?' + 'showAdvertisementByIdAjax' + '&' + 'id=' + encodeURIComponent(id), true);--%>
    <%--request.addEventListener('readystatechange', function () {--%>
    <%--if (request.readyState == 4 && request.status == 200) {--%>
    <%--document.getElementById("select").innerHTML = request.responseText;--%>
    <%--}--%>
    <%--});--%>
    <%--request.send();--%>
    <%--}--%>
    <%--</script>--%>


    <%-- ******  jQuery  ***** --%>
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <%--<script src="../js/javascript.js"></script>--%>

    <script>
        $(document).ready(function () {
            $("#sub").click(function () {
                $.ajax({
                    url: '../users?showAdvertisementByIdAjax',
                    data: {id: $('#id').val()},
                    success: function (responseText) {
                        $("#select").html(responseText);
                    }
                });
            });
        });

    </script>

</head>
<body>
<jsp:include page="header.jsp"/>

<div style="align-content: center">
    <p>ADVERTISEMENT INFO</p>
</div>
<jsp:useBean id="advertisement" class="com.java.lesson.restaurant.reservation.dto.Advertisement" scope="request"/>

<div id="select">
    #: ${advertisement.id} <br/>
    Restaurants Offer: <%=advertisement.getOfferText()%><br/>
    Restaurant id: <%=advertisement.getRestaurantId()%><br/>
</div>

<br/><a href="../index.jsp">main page</a>
<br/>

<H3>
    Показать по id
</H3>

<form id="someForm" method="get">
    <p> id: <label><input type="text" id="id" placeholder="insert id" value=""></label></p>
</form>
<button type="button" id="sub" form="someForm" onclick="showAdv(); return false;">ShowAdvByIdAjax</button>

<br>
<br>
<br>

<form action="/myServlet" method="post">
    <p> id: <label><input type="text" name="id" placeholder="id"></label></p>
    <input type="submit" name="showAdvertisementById" value="show advertisement">
</form>
<br/>

<form action="/myServlet" method="post">
    <input type="submit" name="showAdvertisements" value="show advertisements">
</form>

<jsp:include page="footer.jsp"/>
</body>
</html>
