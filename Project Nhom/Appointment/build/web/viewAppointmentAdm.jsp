<%-- 
    Document   : homeAdm
    Created on : Oct 31, 2019, 6:51:13 PM
    Author     : h
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include  file="/include/headerAdm.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<jsp:useBean id="admin" class="Model.Admin" scope="session"></jsp:useBean>
    <!DOCTYPE html>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Appointment</title>
        </head>
        <style> 
            body {
                background-image: url("image/vinmec-pq.jpg");
                background-repeat: no-repeat, repeat;
            }
        </style>
        <body>
        <center>
            <strong><h1>List Appointment</h1></strong>
            <table border="1" cellpadding="5" cellspacing="1" >
                <tr>
                    <th>pId</th>
                    <th>pName</th>
                    <th>dId</th>       
                    <th>dName</th>       
                    <th>Department</th>       
                    <th>Fee</th>  
                    <th>Roomtype</th> 
                    <th>AppointmentDate</th>       
                    <th>AppointmentTime</th>       
                    <th>Message</th>               
                </tr>
            <c:forEach items="${admin.getAllAppointment()}" var="appointment" >
                <tr>
                    <td>${appointment.pID}</td>
                    <td>${appointment.pName}</td>
                    <td>${appointment.dID}</td>
                    <td>${appointment.dName}</td>
                    <td>${appointment.department}</td>
                    <td>${appointment.dFee}</td>
                    <td>${appointment.roomType}</td>
                    <td>${appointment.appointmentDate}</td>
                    <td>${appointment.appointmentTime}</td>
                    <td>${appointment.message}</td>    
                    <td> <a href="deleteAppointmentAdm?dId=${appointment.pID}&&pId=${appointment.pID}"><button type="submit" class="btn btn-primary">Delete</button></a></td>                   
                </tr>
            </c:forEach>
        </table>
    </center>
</body>
</html>
<%@include  file="/include/footer.jsp" %>