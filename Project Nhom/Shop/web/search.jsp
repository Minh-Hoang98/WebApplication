<%@page contentType="text/html" import="model.*" pageEncoding="utf-8" %>
<%@taglib  prefix="s" uri="/struts-tags" %>
<%@taglib  prefix="m" uri="/WEB-INF/tlds/mytag_library.tld" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ include file="/includes/header.jsp" %>
<%@ include file="/includes/column_left_home.jsp" %>

<!-- start the middle column -->

<section>
    <h1>Welcome to FPT Shop Online</h1>
    <m:product pid="-1"/>
    <c:forEach  begin="1" end="10" step="1" var="i">
        <c:set var="m" value="${m+1}"/>
        <LI>${i} - ${m}
    </c:forEach>
</section>


<!-- end the middle column -->

<%@ include file="/includes/column_right_news.jsp" %>
<%@ include file="/includes/footer.jsp" %>
