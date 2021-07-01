<%@page contentType="text/html" import="model.*" pageEncoding="utf-8" %>
<%@taglib  prefix="s" uri="/struts-tags" %>
<%@ include file="/includes/header.jsp" %>
<%@ include file="/includes/column_left_home.jsp" %>
<jsp:useBean class="model.ShopCart" id="cart" scope="session"/>
<!-- start the middle column -->

<section>
    <h1>Welcome to FPT Shop Online</h1>
    Your cart: ${cart.count} items.
    <Table border="1">
        <TR><TH>Product ID</TH><TH>Product Name</TH><TH>Price</TH><TH>Quantity</TH><TH>Total</TH><TH>Remove</TH></TR>
        <c:forEach items="${cart.cart}" var="item">
            <TR><TD>${item.productID}</TD><TD>${item.productName}</TD><TD>${item.price}</TD><TD>${item.quantity}</TD><TD>${item.total}</TD><TD><A href="remove?pid=${item.productID}">Remove</A></TD>
        </c:forEach> 
    </Table><P>
        <s:form action="order" method="POST">
            <s:textfield name="payment" label="Payment method"/>
            <s:submit value="Make Order"/>
        </s:form>        
<
</section>


<!-- end the middle column -->

<%@ include file="/includes/column_right_news.jsp" %>
<%@ include file="/includes/footer.jsp" %>
