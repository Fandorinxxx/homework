package ru.alternation.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * http://devcolibri.com/как-создать-servlet-полное-руководство/
 *
 * Деплой на Tomcat:
 * http://devcolibri.com/intellij-idea-деплой-на-tomcat/
 * https://tomcat.apache.org/
 *
 * Архивные URL. (Больше не работают)
 * http://devcolibri.com/4284
 * http://devcolibri.com/4249
 */

//@WebServlet("/s") // сделал с помощью web.xml
public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // формируем вручную содержимое отдаваемой html страницы
//        PrintWriter out = resp.getWriter();
//        out.print("<h1>Hello Servlet</h1>");
//        out.close();


        req.setAttribute("name", "Devcolibri");
        RequestDispatcher dispatcher = req.getRequestDispatcher("/main.jsp");
        dispatcher.forward(req, resp);
//      req.getRequestDispatcher("main.jsp").forward(req, resp); // то же самое, одной строкой
    }
}
