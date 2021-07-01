<%-- 
    Document   : listDoctor
    Created on : Oct 22, 2019, 3:16:11 PM
    Author     : OS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/include/headerPat.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<jsp:useBean id="listDoc" class="Model.Doctor" scope="session"></jsp:useBean>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Home Doctor</title>
        </head>
     
        <body>
            <div class="container">
                <center>
                    <strong><h1>Book Appointment</h1></strong>
                    <div class="col-8">
                    <c:if test="${bookFail!=null}||${DateAppFail!=null}">
                        <div class="alert alert-danger" role="alert">
                            ${bookFail}${DateAppFail}
                        </div>
                    </c:if>

                    <form action="bookAppointmentPat" method="POST">
                        <input type="hidden" name="pId" value="${patAppointment.pId}">
                        <input type="hidden" name="pName" value="${patAppointment.pName}">
                        <input type="hidden" name="dId" value="${docAppointment.dId}">
                        <div class="form-group row">
                            <label for="example-search-input" class="col-2 col-form-label">Doctor Name</label>
                            <div class="col-10">
                                <input type="text" class="form-control" id="example-search-input" name="dName" value="${docAppointment.dName}" readonly> 
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="example-search-input" class="col-2 col-form-label">Department</label>
                            <div class="col-10">
                                <input type="text" class="form-control" id="example-search-input" name="department" value="${docAppointment.department}" readonly>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="example-search-input" class="col-2 col-form-label">Room type</label>
                            <div class="col-10">
                                <select id="custom-select" name="roomtype" >
                                    <option selected>VIP</option>
                                    <option>NORMAL1</option>
                                    <option>NORMAL2</option>
                                    <option>NORMAL3</option>
                                </select>
                            </div>
                        </div>

                        <div class="form-group row">
                            <label for="example-search-input" class="col-2 col-form-label">Appointment Date</label>
                            <div class="col-10">
                                <input type="date" class="form-control" id="example-date-input" name="appointmentDate"  required>
                            </div>
                        </div>

                        <div class="form-group row">
                            <label for="example-search-input" class="col-2 col-form-label">Appointment Time</label>
                            <div class="col-10">
                                <input type="time" class="form-control" id="example-search-input" name="appointmentTime"  required>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="example-search-input" class="col-2 col-form-label">Message</label>
                            <div class="col-10">
                                <input type="text" class="form-control" id="example-search-input" name="message" required>
                            </div>
                        </div>
                        <button type="submit" class="btn btn-primary">Book Appointment</button>  
                    </form>
                    <a href="listDoctorInPatient.jsp">Return</a>
                </div>
        </div> 
    </center>
</body>
</html>

<%@ include file="/include/footer.jsp" %>
