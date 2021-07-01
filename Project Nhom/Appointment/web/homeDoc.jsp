<%-- 
    Document   : signInDoc
    Created on : Oct 28, 2019, 8:16:34 AM
    Author     : h
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@include  file="/include/headerDoc.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Doctor</title>
    </head>
    <style> 
        body {
            background-image: url("image/vinmec-pq.jpg");
            background-repeat: no-repeat, repeat;
        }
    </style>
    <body>
        <div class="container">
            <center>
                <c:if test="${editDocSuccess!=null||AcceptAppointment!=null}">
                    <div class="alert alert-success" role="alert">
                        ${editDocSuccess}${AcceptAppointment}</div>
                </c:if> 
            </center>
        </div>
    </body>
</html>
<%@include  file="/include/footer.jsp" %>
