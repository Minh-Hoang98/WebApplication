<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<aside id="sidebarA">
    <nav>
      <ul>
          <li><a class="current" href="index.jsp">
                  Home</a></li>
                  <li><a href=<c:url value="login.jsp"/>>
                 Customer Login</a></li>
                 <li><a href=<c:url value="changepass"/>>
                  Change Password</a></li>
                  <li><a href=<c:url value="list"/>>
                  List Product</a></li>
                  <li><a href=<c:url value="viewcart"/>>
                  View shopcart</a></li>
                  <li><a href=<c:url value="search"/>>
                  Product Search</a></li>
                  <li><a href=<c:url value="order"/>>
                  Order </a></li>
                  <li><a href=<c:url value="logout"/>>
                  Logout</a></li>
      </ul>
    </nav>
</aside>