package controller;

import jakarta.servlet.ServletException;
import dao.Dao;
import entity.Product;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import entity.Category;

/**
 * Servlet implementation class CategoryControl
 */
public class CategoryControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CategoryControl() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String cateID = request.getParameter("cid");
		// da lay dc category id ve roi
		Dao dao = new Dao();
		List<Product> list = dao.getProductByCID(cateID);
		List<Category> listC = dao.getAllCategory();
		Product last = dao.getLast();

		request.setAttribute("listP", list);
		request.setAttribute("listCC", listC);
		request.setAttribute("p", last);
		request.setAttribute("tag", cateID);
		request.getRequestDispatcher("Home.jsp").forward(request, response);
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
