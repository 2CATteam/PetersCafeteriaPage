package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.DishInstance;

/**
 * Servlet implementation class AddMenuServlet
 */
@WebServlet("/AddMenu")
public class AddMenuServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddMenuServlet()
	{
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String toAdd = (String) request.getParameter("toAdd");
		ArrayList<DishInstance> toCompare = (ArrayList<DishInstance>) request.getSession().getAttribute("dishList");
		boolean shouldContinue = true;
		for (DishInstance toCheck : toCompare)
		{
			if (toCheck.dishName.equals(toAdd))
			{
				shouldContinue = false;
			}
		}
		if (shouldContinue)
		{
			new DishInstance(toAdd, (Date) request.getSession().getAttribute("dateToUse"),
				(Boolean) request.getSession().getAttribute("isLunch"), true);
		}
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
