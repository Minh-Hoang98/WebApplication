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
        <title>Edit Appointment</title>
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
                <strong><h1>Edit Appointment</h1></strong>
                <form action="editAppointmentPat" method="POST">
                    <input type="hidden" name="dId" value="${editApp.dID}">
                    <input type="hidden" name="dName" value="${editApp.dName}">
                    <input type="hidden" name="department" value="${editApp.department}">       
                    <input type="hidden" name="pId" value="${editApp.pID}">
                    <input type="hidden" name="message" value="${editApp.message}">
                    <div class="form-group row">
                        <label for="example-search-input" class="col-2 col-form-label">Patient Name</label>
                        <div class="col-10">
                            <input class="form-control" type="text"  id="example-search-input" name="pName" value="${editApp.pName}" readonly required>
                        </div>
                    </div>     
                         <div class="form-group row">
                        <label for="example-search-input" class="col-2 col-form-label">Roomtype</label>
                        <div class="col-10">
                            <input class="form-control" type="text"  id="example-search-input" name="roomtype" value="${editApp.roomType}" readonly required>
                        </div>
                    </div>    
                    <div class="form-group row">
                        <label for="example-date-input" class="col-2 col-form-label">Appointment Date</label>
                        <div class="col-10">
                            <input class="form-control" type="date" id="example-date-input" name="appointmentDate" value="${editApp.appointmentDate}" required readonly="true">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="example-date-input" class="col-2 col-form-label">Appointment Date</label>
                        <div class="col-10">
                            <input class="form-control" type="time" id="example-date-input" name="appointmentTime" value="${editApp.appointmentTime}" required readonly="true">
                        </div>
                    </div>

                    <button type="submit" class="btn btn-primary">Confirm</button>    
                </form>
            </center>
        </div>
    </body>
</html>
<%@include  file="/include/footer.jsp" %>
