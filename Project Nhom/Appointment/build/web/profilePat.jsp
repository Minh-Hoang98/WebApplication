<%-- 
    Document   : signInDoc
    Created on : Oct 28, 2019, 8:16:34 AM
    Author     : h
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include  file="/include/headerPat.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile Patient</title>
    </head>

    <body>
        <div class="container">
            <center>
                <strong><h1>Profile Patient</h1></strong>
                <table border="1" cellpadding="5" cellspacing="1" >
                    <tr>
                        <th>Id</th>
                        <th>Name</th>
                        <th>Email</th>       
                        <th>Password</th>       
                        <th>Gender</th>       
                        <th>DOB</th>       
                        <th>Disease</th>       
                        <th>Status</th>                              
                        <th>Contact</th>       
                        <th>Address</th>  
                        <th>Avatar</th>
                    </tr>        
                    <tr>
                        <td>${profilePat.pId}</td>
                        <td>${profilePat.pName}</td>
                        <td>${profilePat.pEmail}</td>
                        <td>${profilePat.pPassword}</td>
                        <td>${profilePat.pGender}</td>
                        <td>${profilePat.DOB}</td>
                        <td>${profilePat.disease}</td>
                        <td>${profilePat.status}</td>
                        <td>${profilePat.pContact}</td>
                        <td>${profilePat.pAddress}</td> 
                        <td> <img src="avatarPat/${profilePat.filename}" width="200" height="200" /></td>
                        <td> <a href="editProfilePat?pId=${profilePat.pId}"><button type="submit" class="btn btn-primary">Edit</button></a></td>
                    </tr>
                </table>
            </center>
        </div>
    </body>
</html>
<%@include  file="/include/footer.jsp" %>
