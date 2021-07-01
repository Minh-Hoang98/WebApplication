<%@page contentType="text/html" import="model.*" pageEncoding="utf-8" %>
<%@taglib  prefix="s" uri="/struts-tags" %>
<%@ include file="/includes/header.jsp" %>
<%@ include file="/includes/column_left_home.jsp" %>
<s:bean name="model.Product" var="list"/>
<!-- start the middle column -->

<section>
    <h1>Welcome to FPT Shop Online</h1>

    <p>Thanks for visiting. Make yourself at home. We 
    hope you like it as much as we do.</p>

</section>


<!-- end the middle column -->

<%@ include file="/includes/column_right_news.jsp" %>
<%@ include file="/includes/footer.jsp" %>
