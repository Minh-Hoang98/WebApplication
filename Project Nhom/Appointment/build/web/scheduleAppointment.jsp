<%-- 
    Document   : listDoctor
    Created on : Oct 22, 2019, 3:16:11 PM
    Author     : OS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/include/headerDoc.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<jsp:useBean id="AppOfficial" class="Model.Appointment" scope="session"></jsp:useBean>
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
        <center>
            <strong><h1>Schedule of Appointment</h1></strong>
        <c:choose>
            <c:when test="${AppOfficial.getAllAppointmentOfficial().isEmpty()}">
                <div class="alert alert-danger" role="alert">
                    <b>Schedule is Empty</b>
                </div>
            </c:when>  
            <c:when test="${!AppOfficial.getAllAppointmentOfficial().isEmpty()}">
                <table border="1" cellpadding="5" cellspacing="1" >
                    <tr>
                       
                        <th>pName</th>             
                        <th>Roomtype</th> 
                        <th>AppointmentDate</th>       
                        <th>AppointmentTime</th>       
                        <th>Message</th>        
                    </tr>
                    <c:forEach items="${AppOfficial.getAllAppointmentOfficial() }" var="appointment" >
                        <tr>
                           
                            <td>${appointment.pName}</td>
                            <td>${appointment.roomType}</td>
                            <td>${appointment.appointmentDate}</td>
                            <td>${appointment.appointmentTime}</td>
                            <td>${appointment.message}</td>     
                            <td><a href="metAppointment?pId=${appointment.pID}&&dId=${appointment.dID}&&appointmentDate=${appointment.appointmentDate}&&roomtype=${appointment.roomType}"><button type="submit" class="btn btn-primary">Met</button></a></td>
                        </tr>
                    </c:forEach>
                </table>
            </c:when>
        </c:choose>     
    </center>
</body>
</html>
<%@ include file="/include/footer.jsp" %>
