<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="Dao.ProductDao" %>
<%@ page import="connection.DbConnection" %>
<%@ page import="bean.productBean" %>
<%@page import="java.util.*"%>

<%
ProductDao pd = new ProductDao(DbConnection.getConnection());
List<productBean> products = pd.getAllProducts();
%>
<!--

    General workflow:
    Landing page (index.html), after logging in get redirected to indexAfterLogin.jsp page
    This is the main page where you can add items to your cart and remove them and checkout(just a simulation)
    and will also give you the price and every other features. The features are implemented with the
    corresponding servlets.

    All Servlets are in demo1 package
    connection package has the database connection information so that I don't have to trigger it on every page
    Dao package has the query that is being executed in the database
    bean package has all the javaBean by which we access the products and also the items in the cart with
    their prices, quantity etc.

-->
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <%@include file="/include/head.jsp"%>
</head>
<body>

<%@include file="include/navBeforeLogin.jsp"%>

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
                                    <a href="#" class="btn btn-primary disabled">Add to Cart</a>
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