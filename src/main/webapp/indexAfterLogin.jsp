<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="Dao.ProductDao" %>
<%@ page import="connection.DbConnection" %>
<%@ page import="bean.productBean" %>
<%@page import="java.util.*"%>

<%
    ProductDao pd = new ProductDao(DbConnection.getConnection());
    List<productBean> products = pd.getAllProducts();
%>

<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <%@include file="/include/head.jsp"%>
</head>
<body>

<%@include file="include/navAfterLogin.jsp"%>
<%@include file="include/cart.jsp"%>

<script>
    function addedToCart() {
        alert("Item added to cart");
    }
</script>

<div class="container">
    <div class="card-header my-3">Products</div>
    <div class="row">

        <%
            if ( !products.isEmpty() )
            {
                for (productBean p:products){ %>
                <div class="col-md-3 my-3">
                    <div class="card w-100" style="width: 18rem">
                        <img src="image/Screenshot%202023-03-24%20at%2011.15.57%20PM.png" alt="card image" class="card-img-top">
                        <div class="card-body">
                            <h5 class="card-title"><%= p.getName() %></h5>
                            <h6 class="processor">Processor: <%= p.getProcessor() %></h6>
                            <h6 class="RAM">RAM: <%= p.getRam() %></h6>
                            <h6 class="price">Price: BDT <%= p.getPrice() %></h6>

                            <div class="mt-3 d-flex justify-content-between">
                                <a href="add-to-cart?id=<%= p.getName() %>" class="btn btn-primary" id="addedToCart" onclick="addedToCart()">Add to Cart</a>
                            </div>
                        </div>
                    </div>
                </div>
        <%}
        }
        %>

    </div>
</div>

<%@include file="/include/foot.jsp"%>
</body>
</html>