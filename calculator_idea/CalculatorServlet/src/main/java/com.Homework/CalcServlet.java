package com.Homework;

import javax.servlet.ServletOutputStream;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;


public class CalcServlet extends HttpServlet {

@Override
    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();

    Calc in = new Calc();

    out.print("<html><body bgcolor=\"#d3d3d3\"><br><h1>");
    String inputLine = request.getParameter("INPUT");

    out.print("Result:  " + in.evaluate(inputLine));
    out.print("</h1></body></html>");

    }
@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     doGet(request, response);
    }
}




