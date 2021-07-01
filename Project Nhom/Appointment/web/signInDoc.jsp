<%-- 
    Document   : signInDoc
    Created on : Oct 28, 2019, 8:16:34 AM
    Author     : h
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include  file="/include/header.jsp" %>
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
                <strong><h1>SIGN IN DOCTOR</h1></strong>
                <div class="col-8">
                    <form action="signInDoc" method="POST" enctype="multipart/form-data">
                        <div class="form-group row">
                            <label for="example-search-input" class="col-2 col-form-label">Name</label>
                            <div class="col-10">
                                <input class="form-control" type="text"  id="example-search-input" name="name" required>
                            </div>
                        </div>

                        <div class="form-group row">
                            <label for="example-search-input" class="col-2 col-form-label">Email</label>
                            <div class="col-10">
                                <input class="form-control" type="text"  id="example-search-input" name="email" required>
                            </div>
                        </div>

                        <div class="form-group row">
                            <label for="example-password-input" class="col-2 col-form-label">Password</label>
                            <div class="col-10"> 
                                <input class="form-control" type="password"  id="example-password-input" name="password" required>
                            </div>              
                        </div>
                        <div class="form-group row">
                            <label for="example-password-input" class="col-2 col-form-label">Choose Avatar</label>
                            <div class="col-10"> 
                                <input type="file" class="form-control-file" id="exampleFormControlFile1" name="file">
                            </div>              
                        </div>
                        <div class="form-group row">
                            <label for="example-password-input" class="col-2 col-form-label">Gender</label>
                            <div class="col-10">
                                <select class="custom-select" name="gender" required>
                                    <option selected>Male</option>
                                    <option>Female</option>
                                    <option>Other</option>
                                </select>
                            </div>
                        </div>

                        <div class="form-group row">
                            <label for="example-date-input" class="col-2 col-form-label">Date of Birth</label>
                            <div class="col-10">
                                <input class="form-control" type="date" id="example-date-input" name="dob"  required>
                            </div>
                        </div>

                        <div class="form-group row">
                            <label for="example-password-input" class="col-2 col-form-label">Degree</label>
                            <div class="col-10">
                                <select class="custom-select" name="degree" required>
                                    <option selected>MBA</option>
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
                                    <option selected>General surgery</option>
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
                            <label for="example-tel-input" class="col-2 col-form-label">Contact</label>
                            <div class="col-10">
                                <input class="form-control" type="tel" id="example-tel-input" name="contact" required>
                            </div>
                        </div>

                        <div class="form-group row">
                            <label for="example-search-input" class="col-2 col-form-label">Address</label>
                            <div class="col-10">
                                <input class="form-control" type="text"  id="example-search-input" name="address" required>
                            </div>
                        </div>

                        <div class="form-group row">
                            <div class="offset-sm-2 col-sm-10">
                                <button type="submit" class="btn btn-primary">Sign in</button>
                            </div>
                        </div>
                    </form>   
                </div>
            </center>
        </div>
    </body>
</html>

