package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.DishInstance;

/**
 * Servlet implementation class ChangeDayServlet
 */
@WebServlet("/ChangeDay")
public class ChangeDayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeDayServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		if (month.length() == 1)
		{
			month = "0" + month;
		}
		if (day.length() == 1)
		{
			day = "0" + day;
		}
		String toParse = year+month+day;
		Date toSave;
		try
		{
			toSave = DishInstance.DATE_FORMATTER.parse(toParse);
		}
		catch (ParseException e)
		{
			toSave = new Date();
			e.printStackTrace();
		}
		request.getSession().setAttribute("dateToUse", toSave);
		if (request.getParameter("isLunch").equals("true"))
		{
			request.getSession().setAttribute("isLunch", new Boolean(true));
		}
		else
		{
			request.getSession().setAttribute("isLunch", new Boolean(false));
		}
		response.sendRedirect(request.getContextPath() + "/Main");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
