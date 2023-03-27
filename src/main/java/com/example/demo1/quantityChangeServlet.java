package com.example.demo1;

import bean.cartBean;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class quantityChangeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String action = request.getParameter("action");
            String name = request.getParameter("id");
            ArrayList<cartBean> cart_list = (ArrayList<cartBean>) request.getSession().getAttribute("cart-list");

            if (action != null && name != null) {
                if (action.equals("inc")) {
                    for (cartBean c : cart_list) {
                        if (c.getNameOfProduct().equals(name)) {
                            int quantity = c.getQuantity();
                            System.out.println("Before inc:" + quantity);
                            quantity++;
                            System.out.println(quantity);
                            c.setQuantity(quantity);
                            System.out.println("get: " + c.getQuantity());
                            response.sendRedirect("indexAfterLogin.jsp");
                        }
                    }
                }

                if (action.equals("dec")) {
                    for (cartBean c : cart_list) {
                        if (c.getNameOfProduct().equals(name) && c.getQuantity() > 1) {
                            int quantity = c.getQuantity();
                            quantity--;
                            c.setQuantity(quantity);
                            break;
                        }
                    }
                    response.sendRedirect("indexAfterLogin.jsp");
                }
            } else {
                response.sendRedirect("indexAfterLogin.jsp");
            }
        }
    }

}
