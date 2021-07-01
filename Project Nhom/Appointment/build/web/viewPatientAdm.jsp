<%-- 
    Document   : homeAdm
    Created on : Oct 31, 2019, 6:51:13 PM
    Author     : h
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include  file="/include/headerAdm.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<jsp:useBean id="admin" class="Model.Admin" scope="session"></jsp:useBean>
    <!DOCTYPE html>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Profile Patient</title>
        </head>
    
        <body>
        <center>
            <strong><h1>List Patient</h1></strong>
        <c:if test="${DeleteSuccess!=null ||editPatSuccess!=null}">
            <div class="alert alert-success" role="alert">
                ${DeleteSuccess}${editPatSuccess}
            </div>
        </c:if>
        <c:if test="${DeleteFail!=null ||editPatFail!=null}">
            <div class="alert alert-danger" role="alert">
                ${DeleteFail}${editPatFail}
            </div>
        </c:if>
        <form action="searchPatient" method="POST">
            <div class="form-row align-items-center">
                <div class="col-auto my-1">
                    <select class="custom-select mr-sm-2" id="inlineFormCustomSelect" name="attribute">
                        <option selected>Choose Attribute</option>
                        <option>ID</option>
                        <option>Name</option>
                        <option >Gender</option>
                        <option >DOB</option>
                        <option >Disease</option>               
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
                <th>Disease</th>       
                <th>Status</th>            
                <th>Contact</th>       
                <th>Address</th>     
                   <th>Avatar</th>
            </tr>
            <c:forEach items="${admin.getAllPatient()}" var="patient" >
                <tr>
                    <td>${patient.pId}</td>
                    <td>${patient.pName}</td>
                    <td>${patient.pEmail}</td>
                    <td>${patient.pPassword}</td>
                    <td>${patient.pGender}</td>
                    <td>${patient.DOB}</td>
                    <td>${patient.disease}</td>
                    <td>${patient.status}</td>               
                    <td>${patient.pContact}</td>
                    <td>${patient.pAddress}</td>    
                      <td> <img src="avatarPat/${patient.filename}" width="200" height="200" /></td>
                    <td> <a href="deleteProfilePatAdm?pId=${patient.pId}"><button type="submit" class="btn btn-primary">Delete</button></a></td>                   
                </tr>
            </c:forEach>
        </table>
    </center>
</body>
</html>
<%@include  file="/include/footer.jsp" %>