package servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.DataInterface;
import beans.DishesInterface;

/**
 * Servlet implementation class EditMenuServlet
 */
@WebServlet("/EditMenu")
public class EditMenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditMenuServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().setAttribute("dishesInDB", DishesInterface.getDishNames((Boolean) request.getSession().getAttribute("isLunch")));
		request.getSession().setAttribute("dishList", DataInterface.queryDishesOn((Date) request.getSession().getAttribute("dateToUse"),
			(Boolean) request.getSession().getAttribute("isLunch")));
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/editMenuView.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
