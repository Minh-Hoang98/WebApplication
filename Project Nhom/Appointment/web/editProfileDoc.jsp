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
        <title>Profile Doctor</title>
    </head>
    <style> 

    </style>
    <body>
    <center>
        <div class="container">
            <strong><h1>Edit Profile Doctor</h1></strong>
            <c:if test="${editDocSuccess!=null ||editDocFail!=null}">
                <div class="alert alert-danger" role="alert">
                    ${editDocFail}
                </div>
            </c:if>
            <form action="editProfileDoc" method="POST">

                <div class="form-group row">
                    <label for="example-search-input" class="col-2 col-form-label">ID</label>
                    <div class="col-10">
                        <input class="form-control" type="text"  id="example-search-input" name="id" value="${editProfileDoc.dId}" required readonly>
                    </div>
                </div>

                <div class="form-group row">
                    <label for="example-search-input" class="col-2 col-form-label">Name</label>
                    <div class="col-10">
                        <input class="form-control" type="text"  id="example-search-input" name="name" value="${editProfileDoc.dName}" required>
                    </div>
                </div>

                <div class="form-group row">
                    <label for="example-search-input" class="col-2 col-form-label">Email</label>
                    <div class="col-10">
                        <input class="form-control" type="text"  id="example-search-input" name="email" value="${editProfileDoc.dEmail}" required>
                    </div>
                </div>

                <div class="form-group row">
                    <label for="example-password-input" class="col-2 col-form-label">Password</label>
                    <div class="col-10"> 
                        <input class="form-control" type="text"  id="example-password-input" name="password" value="${editProfileDoc.dPassword}" required>
                    </div>              
                </div>

                <div class="form-group row">
                    <label for="example-password-input" class="col-2 col-form-label">Gender</label>
                    <div class="col-10">
                        <select class="custom-select" name="gender" required>
                            <option selected="${editProfileDoc.dGender}">${editProfileDoc.dGender}</option>
                            <option>Male</option>
                            <option>Female</option>
                            <option>Other</option>
                        </select>
                    </div>
                </div>

                <div class="form-group row">
                    <label for="example-date-input" class="col-2 col-form-label">Date of Birth</label>
                    <div class="col-10">
                        <input class="form-control" type="date" id="example-date-input" name="dob"  value="${editProfileDoc.DOB}" required>
                    </div>
                </div>

                
                            <div class="form-group row">
                    <label for="example-password-input" class="col-2 col-form-label">Degree</label>
                    <div class="col-10"> 
                        <input class="form-control" type="text"  id="example-password-input" name="degree" value="${editProfileDoc.degree}" readonly="">
                    </div>              
                </div>
                    
                            
                <div class="form-group row">
                    <label for="example-password-input" class="col-2 col-form-label">Department</label>
                    <div class="col-10"> 
                        <input class="form-control" type="text"  id="example-password-input" name="department" value="${editProfileDoc.department}" readonly="">
                    </div>              
                </div>
                    
             
                <div class="form-group row">
                    <label for="example-tel-input" class="col-2 col-form-label">Contact</label>
                    <div class="col-10">
                        <input class="form-control" type="tel" id="example-tel-input" name="contact" value="${editProfileDoc.dContact}" required>
                    </div>
                </div>
                <div class="form-group row">
                    <label for="example-search-input" class="col-2 col-form-label">Address</label>
                    <div class="col-10">
                        <input class="form-control" type="text"  id="example-search-input" name="address" value="${editProfileDoc.dAddress}" required>
                    </div>
                </div>                                      
                <button type="submit" class="btn btn-primary">Submit</button>
            </form> 
        </div>
    </center>
</body>
</html>
<%@include  file="/include/footer.jsp" %>
