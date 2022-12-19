package controller;

import jakarta.servlet.ServletException;
import entity.Product;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import entity.Category;
import dao.Dao;

/**
 * Servlet implementation class SearchControl
 */
public class SearchControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchControl() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String txtSearch = request.getParameter("txt");// giay chay bo
		Dao dao = new Dao();
		List<Product> list = dao.searchByName(txtSearch);
		List<entity.Category> listC = dao.getAllCategory();
		Product last = dao.getLast();

		request.setAttribute("listP", list);
		request.setAttribute("listCC", listC);
		request.setAttribute("p", last);
		request.setAttribute("txtS", txtSearch);
		request.getRequestDispatcher("Home.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
