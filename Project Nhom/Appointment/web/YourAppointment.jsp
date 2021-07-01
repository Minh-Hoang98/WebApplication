<%-- 
    Document   : signInDoc
    Created on : Oct 28, 2019, 8:16:34 AM
    Author     : h
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include  file="/include/headerPat.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sign In Doctor</title>
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
                <strong><h1>Your Appointment</h1></strong>
               
                <c:choose>
                    <c:when test="${appPatient.isEmpty()}">
                        <div class="alert alert-danger" role="alert">
                            <b>No Appointment or Doctor don`t accept your appointment</b>
                        </div>
                    </c:when>  
                    <c:when test="${!appPatient.isEmpty()}">
                        <table border="1" cellpadding="5" cellspacing="1" >
                            <tr>      
                                <th>dName</th>       
                                <th>Department</th>                                    
                                <th>Roomtype</th> 
                                <th>AppointmentDate</th>       
                                <th>AppointmentTime</th>       
                                    
                            </tr>
                            <c:forEach items="${appPatient}" var="appointment" >
                                <tr>                              
                                    <td>${appointment.dName}</td>
                                    <td>${appointment.department}</td>                               
                                    <td>${appointment.roomType}</td>
                                    <td>${appointment.appointmentDate}</td>
                                    <td>${appointment.appointmentTime}</td>                                     
                                </tr>
                            </c:forEach>
                        </table>
                    </c:when>
                </c:choose>
            </center>
        </div>
    </body>
</html>
<%@include  file="/include/footer.jsp" %>
