<%-- 
    Document   : homeAdm
    Created on : Oct 31, 2019, 6:51:13 PM
    Author     : h
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include  file="/include/headerAdm.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile Doctor</title>
    </head>
   
    <body>
    <center>
        <strong><h1>List Doctor</h1></strong>
        <form action="searchDoctor" method="POST">
            <div class="form-row align-items-center">
                <div class="col-auto my-1">
                    <select class="custom-select mr-sm-2" id="inlineFormCustomSelect" name="attribute">
                        <option selected>Choose Attribute</option>
                        <option>ID</option>
                        <option>Name</option>
                        <option >Gender</option>
                        <option >DOB</option>
                        <option >Degree</option>
                        <option >Department</option>
                    </select>
                </div>
                <div class="col-sm-3 my-1">
                    <input type="text" class="form-control" id="inlineFormInputName" placeholder="Enter Value" name="value">
                </div>
                <div class="col-auto my-1">
                    <button type="submit" class="btn btn-primary">Search</button>
                </div>
            </div>
        </form>
        <table border="1" cellpadding="5" cellspacing="1" >
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Email</th>       
                <th>Password</th>       
                <th>Gender</th>       
                <th>DOB</th>       
                <th>Degree</th>       
                <th>Department</th>                  
                <th>Contact</th>       
                <th>Address</th>       
                <th>Register Date</th>  
                <th>Image</th>
            </tr>
            <c:forEach items="${listDoctorSearch}" var="doctor" >
                <tr>
                    <td>${doctor.dId}</td>
                    <td>${doctor.dName}</td>
                    <td>${doctor.dEmail}</td>
                    <td>${doctor.dPassword}</td>
                    <td>${doctor.dGender}</td>
                    <td>${doctor.DOB}</td>
                    <td>${doctor.degree}</td>
                    <td>${doctor.department}</td>
                    <td>${doctor.dContact}</td>
                    <td>${doctor.dAddress}</td>
                    <td>${doctor.registerdate}</td>     
                    <td> <img src="avatarDoc/${profileDoc.filename}" width="200" height="200" /></td>
                </tr>
            </c:forEach>
        </table>
    </center>
</body>
</html>
<%@include  file="/include/footer.jsp" %>