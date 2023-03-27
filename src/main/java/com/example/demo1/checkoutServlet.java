package com.example.demo1;

import bean.cartBean;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
public class checkoutServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        ArrayList<cartBean> cart_list = (ArrayList<cartBean>) request.getSession().getAttribute("cart-list");
        cart_list.clear();

        response.sendRedirect("indexAfterLogin.jsp");
    }
}