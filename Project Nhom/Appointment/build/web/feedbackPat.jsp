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
        <title>Feedback Patient</title>
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
                <strong><h1>FEED BACK PATIENT</h1></strong>
                <form action="feedbackPat" method="POST">
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <input type="hidden" name="pId" value="${loginPat.pId}">
                            <input type="hidden" name="pName" value="${loginPat.pName}">
                            <label for="inputState">How was your Services?</label>
                            <select id="inputState" class="form-control" name="service">
                                <option>Excellent</option>
                                <option>Good</option>
                                <option>Average</option>
                                <option>Poor</option>
                                <option>Very Poor</option>
                            </select>
                        </div>
                        <div class="form-group col-md-6">
                            <label for="inputState">Give your point to our Services.</label>
                            <select id="inputState" class="form-control" name="point">
                                <option >5</option>
                                <option>4</option>
                                <option>3</option>
                                <option>2</option>
                                <option>1</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="inputState">Quality of Doctor</label>
                            <select id="inputState" class="form-control" name="quality">
                                <option selected>Handsome</option>
                                <option>Delicious</option>
                                <option>Intelligent</option>
                                <option>Generous</option>
                            </select>
                        </div>
                        <div class="form-group col-md-6">
                            <label for="inputEmail4">Status</label>
                            <input type="text" class="form-control" id="inputEmail4" name="status" >
                        </div>
                    </div> 

                    <button type="submit" class="btn btn-primary">Feedback</button>
                </form>
            </center>
        </div>
    </body>
</html>
<%@include  file="/include/footer.jsp" %>
