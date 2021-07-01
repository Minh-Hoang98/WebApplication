<%@page contentType="text/html" import="model.*" pageEncoding="utf-8" %>
<%@taglib  prefix="s" uri="/struts-tags" %>
<%@ include file="/includes/header.jsp" %>
<%@ include file="/includes/column_left_home.jsp" %>
<%@taglib  prefix="m" uri="/WEB-INF/tlds/newtag_library.tld" %>
<!-- start the middle column -->

<section>
    <h1>Welcome to FPT Shop Online</h1>

    <m:customer custNo="32"/>
</section>


<!-- end the middle column -->

<%@ include file="/includes/column_right_news.jsp" %>
<%@ include file="/includes/footer.jsp" %>
