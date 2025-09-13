<%-- File: cart.jsp --%>
<%@ page import="db.DBConnection, model.*, dao.*, java.util.*, java.text.DecimalFormat" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    // --- Setup and Data Fetching ---
    DecimalFormat dcf = new DecimalFormat("#.##");
    request.setAttribute("dcf", dcf);

    ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
    double total = 0;

    if (cart_list != null) {
        ProductDao pDao = new ProductDao(DBConnection.getConnection());
        List<Cart> cartProducts = pDao.getCartProducts(cart_list);
        total = pDao.getTotalCartPrice(cart_list);
        
        // ** THE CRUCIAL FIX **
        // Set the list of products as a request attribute so JSTL can access it
        request.setAttribute("cart_products", cartProducts);
    }
%>

<%@include file="header.jsp" %>

<div class="container my-3">
    <div class="d-flex justify-content-between align-items-center">
        <h3>Total Price: $${(total>0) ? dcf.format(total) : 0}</h3>
        <a class="btn btn-primary" href="#">Check Out</a>
    </div>
    <hr>
    <table class="table table-light">
        <thead>
            <tr>
                <th scope="col">Name</th>
                <th scope="col">Category</th>
                <th scope="col">Price</th>
                <th scope="col">Quantity</th>
                <th scope="col">Cancel</th>
            </tr>
        </thead>
        <tbody>
            <c:if test="${not empty cart_products}">
                <c:forEach items="${cart_products}" var="c">
                    <tr>
                        <td>${c.getName()}</td>
                        <td>${c.getCategory()}</td>
                        <td>$${dcf.format(c.getPrice())}</td>
                        <td>
                           <form action="#" method="post" class="form-inline">
                                <input type="hidden" name="id" value="${c.getId()}" class="form-input">
                                <div class="input-group">
                                    <a class="btn btn-sm btn-secondary" href="#">-</a>
                                    <input type="text" name="quantity" class="form-control form-control-sm text-center" value="${c.getQuantity()}" readonly>
                                    <a class="btn btn-sm btn-secondary" href="#">+</a>
                                </div>
                            </form>
                       <%-- In File: cart.jsp --%>
    <td>
        <%-- This is the line to change --%>
        <a href="remove-from-cart?id=${c.getId()}" class="btn btn-sm btn-danger">Remove</a>
    </td>
                </c:forEach>
            </c:if>
        </tbody>
    </table>
</div>

<%@include file="footer.jsp" %>