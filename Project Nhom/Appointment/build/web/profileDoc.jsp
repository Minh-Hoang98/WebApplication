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
        <title>Profile Doctor</title>
    </head>

    <body>
    <center>
        <strong><h1> Your Profile </h1></strong>

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
            <tr>
                <td>${profileDoc.dId}</td>
                <td>${profileDoc.dName}</td>
                <td>${profileDoc.dEmail}</td>
                <td>${profileDoc.dPassword}</td>
                <td>${profileDoc.dGender}</td>
                <td>${profileDoc.DOB}</td>
                <td>${profileDoc.degree}</td>
                <td>${profileDoc.department}</td>
                <td>${profileDoc.dContact}</td>
                <td>${profileDoc.dAddress}</td>
                <td>${profileDoc.registerdate}</td>
                <td> <img src="avatarDoc/${profileDoc.filename}" width="200" height="200" /></td>
                <td> <a href="editProfileDoc?dId=${profileDoc.dId}"><button type="submit" class="btn btn-primary">Edit</button></a></td>
            </tr>
        </table>
    </center>
</body>
</html>
<%@include  file="/include/footer.jsp" %>
