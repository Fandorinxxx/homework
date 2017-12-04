package ru.alternation.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * Наипростейший сервлет. Пригодится для проверки работы.
 *
 * Для запуска см. java-doc к MainServlet.
 * @see MainServlet
 * Т.е. создать war-ник и задеплоить в Tomcat.
 * Правда, другие сервлеты в этом проeкте также будут достпуны по своим URL.
 */

@WebServlet("/username")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.print("<h1>Привет, username</h1>");
        out.close();
    }
}
