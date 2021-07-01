<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isErrorPage="true" %>
<%@include  file="/include/header.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <center>
                  <h3>Sorry an exception occured!</h3>
                <div class="alert alert-danger" role="alert">        
                    <p>Exception is:</p>
                    <%=exception%>
                </div>
            </center>
        </div>
    </body>
</html>
<%@include  file="/include/footer.jsp" %>
