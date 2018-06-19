package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.DishesInterface;

/**
 * Servlet implementation class AddDBServlet
 */
@WebServlet("/AddDB")
public class AddDBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddDBServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String toAdd = (String) request.getParameter("dishName");
		String isMain = (String) request.getParameter("isMain");
		String units = (String) request.getParameter("unitsType");
		DishesInterface.createDish(toAdd, units, (isMain != null), (Boolean) request.getSession().getAttribute("isLunch"));
        response.sendRedirect(request.getContextPath() + "/Main");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
