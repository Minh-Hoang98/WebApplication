<%@page contentType="text/html" pageEncoding="utf-8" %>
<%@taglib  prefix="s" uri="/struts-tags" %>
<%@ include file="/includes/header.jsp" %>
<%@ include file="/includes/column_left_home.jsp" %>

<!-- start the middle column -->

<section>
    <h1>Welcome to FPT Shop Online</h1>
    <h2>Login System</h2>
    <s:form action="login" method="POST">
        <s:textfield name="custNo" label="Cust ID"/>
        <s:password name="password" label="Password"/>
        <s:submit value="Login"/>
    </s:form>
    

</section>


<!-- end the middle column -->

<%@ include file="/includes/column_right_news.jsp" %>
<%@ include file="/includes/footer.jsp" %>
