<%@page contentType="text/html" import="model.*" pageEncoding="utf-8" %>
<%@taglib  prefix="s" uri="/struts-tags" %>
<%@ include file="/includes/header.jsp" %>
<%@ include file="/includes/column_left_home.jsp" %>
<!-- start the middle column -->

<section>
    <h1>Welcome to FPT Shop Online</h1>
    <H3>Order ID: ${orders.maDH} </h3> 
    <LI>Customer ID: ${CUST.custNo}
    <LI>Customer Name: ${CUST.custFName} ${CUST.custLName}
    <LI>Payment method: ${orders.payment}
    <LI>General order total: ${orders.total} 
        <BR><BR>
    <Table border="1">
        <TR><TH>Product ID</TH><TH>Product Name</TH><TH>Price</TH><TH>Quantity</TH><TH>Total</TH></TR>
        <c:forEach items="${orders.cart}" var="item">
            <TR><TD>${item.productID}</TD><TD>${item.productName}</TD><TD>${item.price}</TD><TD>${item.quantity}</TD><TD>${item.total}</TD></TR>
        </c:forEach> 
    </Table><BR>
<B>Thank you for shopping with us.. </B>
</section>


<!-- end the middle column -->

<%@ include file="/includes/column_right_news.jsp" %>
<%@ include file="/includes/footer.jsp" %>
