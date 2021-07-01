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
        <center>
            <strong><h1>Doctor</h1></strong>
        <c:if test="${BK!=null}">
            <div class="alert alert-danger" role="alert">
                ${BK}
            </div>
        </c:if>
        <form action="searchDepartmentDoctor" method="POST">
            <div class="form-row align-items-center">
                <div class="col-auto my-1">
                    <select class="custom-select mr-sm-2" id="inlineFormCustomSelect" name="attribute">
                        <option selected>Choose Department</option>
                        <option>General surgery</option>
                        <option>Cardiology</option>
                        <option>Breast screening</option>
                        <option>Chaplaincy</option>
                        <option>Critical care</option>                                  
                        <option>Gynaecology</option>
                        <option>Gastroenterology</option>
                        <option>Microbiology</option>
                        <option>Haematology</option>
                        <option>Other</option>
                    </select>
                </div>
                <div class="col-auto my-1">
                    <button type="submit" class="btn btn-primary">Search</button>
                </div>
            </div>
        </form>
        <c:choose>
            <c:when test="${listDoctorSearch.isEmpty()}">
                <div class="alert alert-danger" role="alert">
                    <b>Don`t have any doctor in department</b>
                </div>
            </c:when>  
            <c:when test="${!listDoctorSearch.isEmpty()}">
                <c:forEach items="${listDoctorSearch}" var="doctor" >
                    <table border="1" cellpadding="5" cellspacing="1" >
                        <tr>            
                            <th>Name</th>
                            <th>Email</th>                     
                            <th>Gender</th>       
                            <th>DOB</th>       
                            <th>Degree</th>       
                            <th>Department</th>               
                            <th>Contact</th>       
                            <th>Address</th> 
                           
                        </tr>          
                        <tr>                  
                            <td>${doctor.dName}</td>
                            <td>${doctor.dEmail}</td>                  
                            <td>${doctor.dGender}</td>
                            <td>${doctor.DOB}</td>
                            <td>${doctor.degree}</td>
                            <td>${doctor.department}</td>               
                            <td>${doctor.dContact}</td>
                            <td>${doctor.dAddress}</td>   
                            <td> <img src="avatarDoc/${doctor.filename}" width="200" height="200" /></td>
                            <td> <a href="bookAppointmentPat?dId=${doctor.dId}&&pId=${loginPat.pId}"><button type="submit" class="btn btn-primary">Book Appointment</button></a></td>                   
                        </tr>
                    </c:forEach>
                </c:when>
            </c:choose>
        </table>
    </center>

</body>
</html>
<%@ include file="/include/footer.jsp" %>
