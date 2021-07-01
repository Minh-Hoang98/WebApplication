<%@page contentType="text/html" import="model.*" pageEncoding="utf-8" %>
<%@taglib  prefix="s" uri="/struts-tags" %>
<%@ include file="/includes/header.jsp" %>
<%@ include file="/includes/column_left_home.jsp" %>
<s:bean name="model.Product" var="list"/>
<jsp:useBean class="model.ShopCart" id="cart" scope="session"/>
<!-- start the middle column -->

<section>
    <h1>Welcome to FPT Shop Online</h1>
    Your cart: ${cart.count} items.
    <Table border="1">
        <TR><TH>Product ID</TH><TH>Product Image</TH><TH>Product Name</TH><TH>Price</TH><TH>Add to Cart</TH></TR>
        <c:forEach items="${list.all}" var="item">
            <TR><TD>${item.productID}</TD><TD><img src="${item.pic}" ></TD><TD>${item.productName}</TD><TD>${item.price}</TD><TD><A href="buy?pid=${item.productID}">Buy</A></TD>
        </c:forEach> 
    </Table>
<A href="viewcart">View your shopcart</A>
</section>


<!-- end the middle column -->

<%@ include file="/includes/column_right_news.jsp" %>
<%@ include file="/includes/footer.jsp" %>
