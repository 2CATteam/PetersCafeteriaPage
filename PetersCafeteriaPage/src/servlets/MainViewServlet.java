package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.DataInterface;
import beans.DishInstance;

/**
 * Servlet implementation class MainViewServlet
 */
@WebServlet("/Main")
public class MainViewServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MainViewServlet()
	{
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		if (request.getAttribute("dateToUse") == null)
		{
			Date toAdd = new Date();
			try
			{
				toAdd = DishInstance.DATE_FORMATTER.parse(DishInstance.DATE_FORMATTER.format(toAdd));
			}
			catch (ParseException e)
			{
				e.printStackTrace();
			}
			request.setAttribute("dateToUse", toAdd);
		}
		if (request.getAttribute("isLunch") == null)
		{
			request.setAttribute("isLunch", new Boolean(true));
		}
		SimpleDateFormat dateFormatter = new SimpleDateFormat("MMMMMMMMM dd, yyyy");
		request.setAttribute("dateToShow", dateFormatter.format((Date) request.getAttribute("dateToUse")));
		request.setAttribute("dishList", DataInterface.queryDishesOn((Date) request.getAttribute("dateToUse"),
			(Boolean) request.getAttribute("isLunch")));
		request.setAttribute("shorthandFormatter", new SimpleDateFormat("MM/dd/yy"));
		if ((Boolean) request.getAttribute("isLunch"))
		{
			request.setAttribute("meal", "Lunch");
		}
		else
		{
			request.setAttribute("meal", "Breakfast");
		}
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/mainView.jsp");
		dispatcher.forward(request, response);
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
