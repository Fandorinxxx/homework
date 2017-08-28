package ru.alternation.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<Integer, String> users = new ConcurrentHashMap<>();
	private AtomicInteger counter;
	
	
	@Override
	public void init() throws ServletException {
		super.init();
		users.put(1, "Vanya");
		users.put(2, "Ivan");
		users.put(3, "Vova");
		counter = new AtomicInteger(3);
	}

	/**
	 * see user.html
	 * метод получения пользователя по id
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Optional<Integer> id = Optional.ofNullable(request.getParameter("id"))
				.filter(s -> {
					System.out.println("Пользователь ввел id: " + s);
					return s.matches("^\\d+$");
				})
				.map(Integer::parseInt);

		Optional<String> user = Optional.ofNullable(users.get(id.orElse(-1)));
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<h3>Ответ на запрос</h3><br>");
		out.println("<p>user: "+ user.orElse("не найден") +"<p><br>");
		out.print("<a href='javascript:history.back();'>Назад</a>");
		out.close();
	}

	/**
	 * see edit.html
	 * метод добавления пользователя
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		Optional<String> name = Optional.ofNullable(request.getParameter("name"));

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		if (name.isPresent() && name.get().length() > 0){
			if (!users.containsValue(name.get())) {
				addUser(name.get());
				out.println("<h3>Создан user " + name.get() + " c id=" + counter.get() + "</h3>");
			} else {
				out.println("<h3>user " + name.get() + " уже существует</h3>");
			}
		} else {
			out.println("<h3>Некорректное имя пользователя<h3>");
		}

		out.print("<br>");
		out.println("<a href='http://localhost:8080/'>На главную</a>");
		out.close();
	}

	private void addUser(String name) {
		Integer id = counter.incrementAndGet();
		users.put(id, name);
	}

}
