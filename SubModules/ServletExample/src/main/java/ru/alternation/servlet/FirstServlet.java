package ru.alternation.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * https://www.youtube.com/playlist?list=PLwcDaxeEINad0vuk7vVxlWLrVI-Y5UK3H
 * https://cloud.mail.ru/public/JAji/ETwyAdNam
 *
 * + Пофиксин NPE добавления Optional'ов
 */

@WebServlet(urlPatterns = "/FirstServlet", description = "Моё описание сервлета", displayName = "FirstServletDisplayName")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String mainPageLink = "  <br>\n" +
			"  <div>\n" +
			"    <hr>\n" +
			"    <a href=\"/index.html\">Main Page</a>\n" +
			"  </div>";


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter("firstName");//""
		String surname = request.getParameter("secondName");
		String gender = request.getParameter("gender");
		if (gender == null) {
			gender = "-";
		}
		String age18 = request.getParameter("age18");
		if (age18 == null) {
			age18 = "-";
		}

		System.out.println("Имя: " + name);
		System.out.println("Фамилия: " + surname);

        //String job = request.getParameter("job");
        //String[] jobs = request.getParameterValues("job");
        Optional<String[]> jobs = Optional.ofNullable(request.getParameterValues("job"));
        jobs.ifPresent(strings ->  System.out.println("Количество ролей: " + strings.length));
        jobs.map(strings -> Arrays.stream(strings).collect(Collectors.joining(", ", "", ".")))
                .ifPresent(System.out::println);


		System.out.println();
		System.out.println("Пол: " + gender);
		System.out.println("Старше 18: " + age18);

//		response.setContentType("text/html");
//		response.setCharacterEncoding("UTF-8");
//or
		response.setContentType("text/html;charset=utf-8");

		PrintWriter out = response.getWriter();
		out.println("<h3>Профиль сотрудника</h3>");
		out.println("Имя: "+ name + "<br>");
		out.println("Фамилия: "+ surname + "<br>");
		//out.println("Профессия: "+ jobs + "<br>");

		out.println("Профессия: "+ Arrays.deepToString(jobs.orElseGet(() -> new String[0])) + "<br>");
		out.println("Пол: "+ gender + "<br>");
		out.println("Старше 18: "+ age18 + "<br>");
		out.println(mainPageLink);
		out.close();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("firstName");
		String surname = request.getParameter("secondName");
		System.out.println(name);
		System.out.println(surname);


//		response.setContentType("text/html");
//		response.setCharacterEncoding("UTF-8");
//or
		response.setContentType("text/html;charset=utf-8");

		PrintWriter out = response.getWriter();
		out.println("<h3>Привет от FirstServlet.POST " + name + " " + surname + "</h3>");
		out.println(mainPageLink);
		out.close();
	}
}
