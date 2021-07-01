<%-- 
    Document   : signInDoc
    Created on : Oct 28, 2019, 8:16:34 AM
    Author     : h
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include  file="/include/headerAdm.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile Patient</title>
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
                <strong><h1>Edit Profile</h1></strong>
                <c:if test="${editPatSuccess!=null ||editPatFail!=null}">
                    <div class="alert alert-danger" role="alert">
                        ${editPatFail}
                    </div>
                </c:if>
                <div class="col-8">
                    <form action="editProfilePatAdm" method="POST">

                        <div class="form-group row">
                            <label for="example-search-input" class="col-2 col-form-label">ID</label>
                            <div class="col-10">
                                <input class="form-control" type="text"  id="example-search-input" name="id" value="${editProfilePatAdm.pId}" required readonly>
                            </div>
                        </div>

                        <div class="form-group row">
                            <label for="example-search-input" class="col-2 col-form-label">Name</label>
                            <div class="col-10">
                                <input class="form-control" type="text"  id="example-search-input" name="name" value="${editProfilePatAdm.pName}" required>
                            </div>
                        </div>

                        <div class="form-group row">
                            <label for="example-search-input" class="col-2 col-form-label">Email</label>
                            <div class="col-10">
                                <input class="form-control" type="text"  id="example-search-input" name="email" value="${editProfilePatAdm.pEmail}" required>
                            </div>
                        </div>

                        <div class="form-group row">
                            <label for="example-password-input" class="col-2 col-form-label">Password</label>
                            <div class="col-10"> 
                                <input class="form-control" type="text"  id="example-password-input" name="password" value="${editProfilePatAdm.pPassword}" required>
                            </div>              
                        </div>

                        <div class="form-group row">
                            <label for="example-password-input" class="col-2 col-form-label">Gender</label>
                            <div class="col-10">
                                <select class="custom-select" name="gender" required>
                                    <option selected="${editProfilePatAdm.pGender}">${editProfilePatAdm.pGender}</option>
                                    <option>Male</option>
                                    <option>Female</option>
                                    <option>Other</option>
                                </select>
                            </div>
                        </div>

                        <div class="form-group row">
                            <label for="example-date-input" class="col-2 col-form-label">Date of Birth</label>
                            <div class="col-10">
                                <input class="form-control" type="date" id="example-date-input" name="dob" value="${editProfilePatAdm.DOB}" required>
                            </div>
                        </div>

                        <div class="form-group row">
                            <label for="example-password-input" class="col-2 col-form-label">Disease</label>
                            <div class="col-10"> 
                                <input class="form-control" type="text"  id="example-password-input" name="disease" value="${editProfilePatAdm.disease}" required>
                            </div>              
                        </div>

                        <div class="form-group row">
                            <label for="example-password-input" class="col-2 col-form-label">Status</label>
                            <div class="col-10"> 
                                <input class="form-control" type="text"  id="example-password-input" name="status" value="${editProfilePatAdm.status}" required>
                            </div>              
                        </div>

                        <div class="form-group row">
                            <label for="example-tel-input" class="col-2 col-form-label">Contact</label>
                            <div class="col-10">
                                <input class="form-control" type="tel" id="example-tel-input" name="contact" value="${editProfilePatAdm.pContact}" required>
                            </div>
                        </div>

                        <div class="form-group row">
                            <label for="example-search-input" class="col-2 col-form-label">Address</label>
                            <div class="col-10">
                                <input class="form-control" type="text"  id="example-search-input" name="address" value="${editProfilePatAdm.pAddress}" required>
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="offset-sm-2 col-sm-10">
                                <button type="submit" class="btn btn-primary">Edit</button>
                            </div>
                        </div>
                    </form> 
                </div>
            </center>
        </div>
    </body>
</html>
<%@include  file="/include/footer.jsp" %>
