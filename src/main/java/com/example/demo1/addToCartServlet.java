package com.example.demo1;

import bean.cartBean;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class addToCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        try (PrintWriter out = response.getWriter()){
            ArrayList<cartBean> cartList = new ArrayList<>();

            String name = request.getParameter("id");
            cartBean cm = new cartBean();
            cm.setNameOfProduct(name);
            cm.setQuantity(1);

            HttpSession session = request.getSession();
            ArrayList<cartBean> cart_list = (ArrayList<cartBean>) session.getAttribute("cart-list");

            if (cart_list == null) {
                cartList.add(cm);
                session.setAttribute("cart-list", cartList);
                //out.println("session Created and added to the list");

                RequestDispatcher rd = request.getRequestDispatcher("indexAfterLogin.jsp");
                rd.include(request,response);
            }
            else {
                cartList = cart_list;
                boolean exist = false;

                for (cartBean c:cart_list) {
                    if (c.getNameOfProduct().equals(name)) {
                        exist = true;
                        //out.println("Product Exists");

                        RequestDispatcher rd = request.getRequestDispatcher("indexAfterLogin.jsp");
                        rd.include(request,response);
                    }
                }

                if (!exist) {
                    cartList.add(cm);
                    //out.println("Product added");

                    RequestDispatcher rd = request.getRequestDispatcher("indexAfterLogin.jsp");
                    rd.include(request,response);
                }
            }

        }
    }
}
