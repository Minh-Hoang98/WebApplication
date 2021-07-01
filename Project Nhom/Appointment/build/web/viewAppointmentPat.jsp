<%-- 
    Document   : signInDoc
    Created on : Oct 28, 2019, 8:16:34 AM
    Author     : h
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include  file="/include/headerDoc.jsp" %>
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
                <strong><h1>View Appointment</h1></strong>
                <c:if test="${DeleteSuccess!=null ||editPatSuccess!=null}">
                    <div class="alert alert-success" role="alert">
                        ${DeleteSuccess}${editPatSuccess}
                    </div>
                </c:if>
                <c:if test="${DeleteFail!=null ||editPatFail!=null}">
                    <div class="alert alert-danger" role="alert">
                        ${DeleteFail}${editPatFail}
                    </div>
                </c:if>
                <c:choose>
                    <c:when test="${aList.isEmpty()}">
                        <div class="alert alert-danger" role="alert">
                            <b>You don`t have any appointment.</b>
                        </div>
                    </c:when>  
                    <c:when test="${!aList.isEmpty()}">
                        <table border="1" cellpadding="5" cellspacing="1" >
                            <tr>                      
                                <th>pName</th>                                          
                                <th>Roomtype</th> 
                                <th>AppointmentDate</th>       
                                <th>AppointmentTime</th>       
                                <th>Message</th>           
                            </tr>
                            <c:forEach items="${aList}" var="appointment" >
                                <tr>
                                    <td>${appointment.pName}</td>                             
                                    <td>${appointment.roomType}</td>
                                    <td>${appointment.appointmentDate}</td>
                                    <td>${appointment.appointmentTime}</td>
                                    <td>${appointment.message}</td>                         
                                    <td> <a href="editAppointmentPat?dId=${appointment.dID}&&pId=${appointment.pID}"> <button type="submit" class="btn btn-primary">Accept</button></a></td>                        
                                    <td> <a href="cancelAppointmentPat?dId=${appointment.dID}&&pId=${appointment.pID}"> <button type="submit" class="btn btn-primary">Cancel</button></a></td>  
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
