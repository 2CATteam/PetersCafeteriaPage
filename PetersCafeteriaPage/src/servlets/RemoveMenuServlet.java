package servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.DataInterface;
import beans.DishInstance;

/**
 * Servlet implementation class RemoveMenuServlet
 */
@WebServlet("/RemoveMenu")
public class RemoveMenuServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RemoveMenuServlet()
	{
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String toRemove = (String) request.getParameter("toRemove");
		DataInterface.deleteDish(new DishInstance(toRemove, (Date) request.getSession().getAttribute("dateToUse"),
			(Boolean) request.getSession().getAttribute("isLunch"), false));
		response.sendRedirect(request.getContextPath() + "/Main");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}

}
