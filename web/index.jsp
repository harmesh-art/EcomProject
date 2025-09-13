<%-- File: index.jsp --%>
<%@ page import="db.DBConnection, dao.ProductDao, model.*, java.util.*" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    // Get DAO and fetch products
    ProductDao pd = new ProductDao(DBConnection.getConnection());
    List<Product> products = pd.getAllProducts();
    
    // Set products as an attribute for JSTL to use
    request.setAttribute("products", products);
%>
<%@include file="header.jsp" %>

<div class="row">
    <c:forEach items="${products}" var="p">
        <div class="col-md-4 col-lg-3 mb-4">
            <div class="card h-100">
                <img src="${p.getImageUrl()}" class="card-img-top" alt="${p.getName()}" style="height: 200px; object-fit: cover;">
                <div class="card-body">
                    <h5 class="card-title">${p.getName()}</h5>
                    <h6 class="card-subtitle mb-2 text-muted">Price: $${p.getPrice()}</h6>
                </div>
                <div class="card-footer text-center">
                    <a href="add-to-cart?id=${p.getId()}" class="btn btn-primary">Add to Cart</a>
                </div>
            </div>
        </div>
    </c:forEach>
</div>

<%@include file="footer.jsp" %>