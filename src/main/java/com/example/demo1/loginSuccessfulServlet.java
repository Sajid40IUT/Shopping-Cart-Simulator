package com.example.demo1;

import javax.print.DocFlavor;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class loginSuccessfulServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie [] cookieArray = request.getCookies();
        PrintWriter out = response.getWriter();

        // flag is initialized in case the session is invalid
        int flag = 0;

        for (Cookie c:cookieArray)
        {
            if (c.getName().equals("usernameKey"))
            {
                //here the session is valid

                flag = 1;

                out.println("<h1> Welcome! </h1>");

                RequestDispatcher rd = request.getRequestDispatcher(
                        "indexAfterLogin.jsp");
                rd.forward(request, response);

            }

        }
        if (flag == 0)
        {   // No cookies were matched so the session was deemed invalid
            out.println("<h1> Invalid session. Please log in again. " +
                    "</h1>");
            RequestDispatcher rd = request.getRequestDispatcher(
                    "index.jsp");
            rd.include(request, response);
        }
    }
}