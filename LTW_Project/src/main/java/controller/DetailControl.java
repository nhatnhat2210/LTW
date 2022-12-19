package controller;

import jakarta.servlet.ServletException;
import dao.Dao;
import entity.Category;
import entity.Product;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class DetailControl
 */
public class DetailControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DetailControl() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String id = request.getParameter("pid");
		Dao dao = new Dao();
		Product p = dao.getProductByID(id);
		List<Category> listC = dao.getAllCategory();
		Product last = dao.getLast();

		request.setAttribute("detail", p);
		request.setAttribute("listCC", listC);
		request.setAttribute("p", last);
		request.getRequestDispatcher("Detail.jsp").forward(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
