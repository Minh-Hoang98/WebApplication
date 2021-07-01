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
        <title>Profile Doctor</title>
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
                <c:if test="${editDocSuccess!=null ||editDocFail!=null}">
                    <div class="alert alert-danger" role="alert">
                        ${editDocFail}
                    </div>
                </c:if>
                <div class="col-8">
                    <form action="editProfileDocAdm" method="POST">

                        <div class="form-group row">
                            <label for="example-search-input" class="col-2 col-form-label">ID</label>
                            <div class="col-10">
                                <input class="form-control" type="text"  id="example-search-input" name="id" value="${editProfileDocAdm.dId}" required readonly>
                            </div>
                        </div>

                        <div class="form-group row">
                            <label for="example-search-input" class="col-2 col-form-label">Name</label>
                            <div class="col-10">
                                <input class="form-control" type="text"  id="example-search-input" name="name" value="${editProfileDocAdm.dName}" required>
                            </div>
                        </div>

                        <div class="form-group row">
                            <label for="example-search-input" class="col-2 col-form-label">Email</label>
                            <div class="col-10">
                                <input class="form-control" type="text"  id="example-search-input" name="email" value="${editProfileDocAdm.dEmail}" required>
                            </div>
                        </div>

                        <div class="form-group row">
                            <label for="example-password-input" class="col-2 col-form-label">Password</label>
                            <div class="col-10"> 
                                <input class="form-control" type="text"  id="example-password-input" name="password" value="${editProfileDocAdm.dPassword}" required>
                            </div>              
                        </div>

                        <div class="form-group row">
                            <label for="example-password-input" class="col-2 col-form-label">Gender</label>
                            <div class="col-10">
                                <select class="custom-select" name="gender" required>
                                    <option selected="${editProfileDocAdm.dGender}">${editProfileDocAdm.dGender}</option>
                                    <option>Male</option>
                                    <option>Female</option>
                                    <option>Other</option>
                                </select>
                            </div>
                        </div>

                        <div class="form-group row">
                            <label for="example-date-input" class="col-2 col-form-label">Date of Birth</label>
                            <div class="col-10">
                                <input class="form-control" type="date" id="example-date-input" name="dob"  value="${editProfileDocAdm.DOB}" required>
                            </div>
                        </div>

                        <div class="form-group row">
                            <label for="example-password-input" class="col-2 col-form-label">Degree</label>
                            <div class="col-10">
                                <select class="custom-select" name="degree" required>
                                    <option selected="${editProfileDocAdm.degree}">${editProfileDocAdm.degree}</option>
                                    <option>MBA</option>
                                    <option>HAO</option>
                                    <option>CBA</option>
                                    <option>ODA</option>
                                    <option>PHD</option>
                                    <option>DHA</option>
                                    <option>WHO</option>
                                    <option>Other</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="example-password-input" class="col-2 col-form-label">Department</label>
                            <div class="col-10">
                                <select class="custom-select" name="department" required>
                                    <option selected="${editProfileDocAdm.department}">${editProfileDocAdm.department}</option>
                                    <option>General surgery</option>
                                    <option>Cardiology</option>
                                    <option>Breast screening</option>
                                    <option>Chaplaincy</option>
                                    <option>Critical care</option>                           
                                    <option>Gynaecology</option>
                                    <option>Gastroenterology</option>
                                    <option>Microbiology</option>
                                    <option>Haematology</option>
                                </select>
                            </div>
                        </div>

                        <div class="form-group row">
                            <label for="example-number-input" class="col-2 col-form-label">Fee</label>
                            <div class="col-10">
                                <input class="form-control" type="number" id="example-number-input" name="fee" value="${editProfileDocAdm.fee}" required>
                            </div>
                        </div>

                        <div class="form-group row">
                            <label for="example-tel-input" class="col-2 col-form-label">Contact</label>
                            <div class="col-10">
                                <input class="form-control" type="tel" id="example-tel-input" name="contact" value="${editProfileDocAdm.dContact}" required>
                            </div>
                        </div>

                        <div class="form-group row">
                            <label for="example-search-input" class="col-2 col-form-label">Address</label>
                            <div class="col-10">
                                <input class="form-control" type="text"  id="example-search-input" name="address" value="${editProfileDocAdm.dAddress}" required>
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
