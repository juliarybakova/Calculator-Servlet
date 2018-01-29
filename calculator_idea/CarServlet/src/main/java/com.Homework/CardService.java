package com.Homework;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class CardService extends HttpServlet {
    private Map<Integer, String> storage = new HashMap();

    private AtomicInteger counter;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = new PrintWriter(response.getOutputStream());
        out.println("<!DOCTYPE HTML>");
        out.println("<html>");
        out.println("<head>");
        out.println("<body>");
        out.println("<table>");
        for (Map.Entry<Integer, String> entry: storage.entrySet()
                ) {
            out.printf("<tr><td>%d</td>%std></td></tr>", entry.getKey(), entry.getValue());

        };

        out.println("</table>");
        out.println("</body>");
        out.println("/head>");
        out.println("</html>");

        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {

       /* Scanner sc = new Scanner(resp.getInputStream());
                int id = counter.getAndIncrement();*/
    }


}
