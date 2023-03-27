package com.example.demo1;

import bean.cartBean;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
public class removeFromCartServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            String name = request.getParameter("id");
            if (name != null) {
                ArrayList<cartBean> cart_list = (ArrayList<cartBean>) request.getSession().getAttribute("cart-list");
                if (cart_list != null) {
                    for (cartBean c : cart_list) {
                        if (c.getNameOfProduct().equals(name)) {
                            cart_list.remove(cart_list.indexOf(c));
                            break;
                        }
                    }
                }
                response.sendRedirect("indexAfterLogin.jsp");

            } else {
                response.sendRedirect("indexAfterLogin.jsp");
            }
        }

    }
}
