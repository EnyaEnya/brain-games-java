package com.qq.braingames.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletOutputStream out = null;
        try {
            out = resp.getOutputStream();

            out.println("<html>");
            out.println("<head><title>Hello Servlet</title></head>");

            out.println("<body>");
            out.println("<h3>Hello World</h3>");
            out.println("This is my first Servlet");
            out.println("</body>");
            out.println("<html>");
        } finally {
            if (out != null) {
                out.flush();
                out.close();
            }
        }
    }
}
