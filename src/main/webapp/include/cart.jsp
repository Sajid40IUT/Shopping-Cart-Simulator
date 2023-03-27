<%@ page import="bean.cartBean" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="Dao.ProductDao" %>
<%@ page import="connection.DbConnection" %>
<%@ page import="bean.productBean" %>
<%@page import="java.util.*"%>

<%
ArrayList<cartBean> cart_list = (ArrayList<cartBean>) session.getAttribute("cart-list");
List<cartBean> cartProducts = null;

if (cart_list != null) {
    ProductDao pDao = new ProductDao(DbConnection.getConnection());
    cartProducts = pDao.getCartProducts(cart_list);
    int total = pDao.getTotalCartPrice(cart_list);
    request.setAttribute("cart_list", cart_list);
    request.setAttribute("total", total);
}

%>

<script>
    function removedFromCart() {
        alert("Item removed from Cart");
    }

    function alertCheckout() {
        const alertPlaceholder = document.getElementById('checkoutAlert')
        const wrapper = document.createElement('div')
        wrapper.innerHTML = [
            `<div class="alert alert- alert-dismissible fade" role="alert">`,
            `   <div></div>`,
            '   <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>',
            '</div>'
        ].join('')

        alertPlaceholder.append(wrapper)
    }

    function triggerAlertCheckout() {
        const alertTrigger = document.getElementById('checkout')
        if (alertTrigger) {
            alertCheckout()
        }
    }

</script>

<div class="container">

    <div class="d-flex py-3">
        <h3>Total price: BDT${ total }</h3>
        <div id="checkoutAlert"></div>
        <a href="checkoutServlet" class="mx-3 btn btn-primary" id="checkout" onclick="triggerAlertCheckout()">Check out</a>
    </div>

    <table class="table table-light">
        <thead>
        <tr>
            <th scope="col">Name</th>
            <th scope="col">Price</th>
        </tr>
        </thead>

        <tbody>
         <%
            if (cart_list != null) {
                for (cartBean c:cartProducts) {%>
                 <tr>
                     <td><%= c.getNameOfProduct() %></td>
                     <td><%= c.getPrice() %></td>

                     <td>
                         <form action="" method="post" class="form-inline">
                             <input type="hidden" name="id" value="1" class="form-input">
                             <div class="form-group d-flex justify-content-between">
                                 <a class="btn btn-sm btn-decre" id="sub" href="quantityChangeServlet?action=dec&id=<%= c.getNameOfProduct() %>"><i class="fas fa-minus-square"></i></a>
                                 <input type="text" name="quantity" class="form-control"  value="<%= c.getQuantity() %>" readonly>
                                 <% System.out.println("Cart q: " + c.getQuantity()); %>
                                 <a class="btn btn-sm btn-incre" id="add" href="quantityChangeServlet?action=inc&id=<%= c.getNameOfProduct() %>"><i class="fas fa-plus-square"></i></a>
                             </div>
                         </form>
                     <td><a href="removeFromCartServlet?id=<%= c.getNameOfProduct() %>" class="btn btn-sm btn-danger" id="removed" onclick="removedFromCart()">Remove</a></td>
                     </td>
                 </tr>
                <%}
            }
         %>

        </tbody>
    </table>

</div>