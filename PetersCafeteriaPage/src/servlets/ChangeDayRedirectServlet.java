package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.MonthMatcher;

/**
 * Servlet implementation class ChangeDayRedirectServlet
 */
@WebServlet("/ChangeDayBox")
public class ChangeDayRedirectServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChangeDayRedirectServlet()
	{
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		Date toSet = (Date) request.getSession().getAttribute("dateToUse");
		Calendar toExtract = new GregorianCalendar();
		toExtract.setTime(toSet);
		int day = toExtract.get(Calendar.DAY_OF_MONTH);
		int month = toExtract.get(Calendar.MONTH) + 1;
		int year = toExtract.get(Calendar.YEAR);
		request.getSession().setAttribute("day", day);
		request.getSession().setAttribute("month", month);
		request.getSession().setAttribute("year", year);
		if (request.getSession().getAttribute("daysArray") == null)
		{
			ArrayList<Integer> daysArray = new ArrayList<Integer>();
			for (int index = 1; index <= 31; ++index)
			{
				daysArray.add(new Integer(index));
			}
			request.getSession().setAttribute("daysArray", daysArray);
		}
		if (request.getSession().getAttribute("monthsArray") == null)
		{
			ArrayList<MonthMatcher> monthsArray = new ArrayList<MonthMatcher>();
			for (int index = 1; index <= 12; ++index)
			{
				monthsArray.add(new MonthMatcher(index));
			}
			request.getSession().setAttribute("monthsArray", monthsArray);
		}
		if (request.getSession().getAttribute("yearsArray") == null)
		{
			ArrayList<Integer> yearsArray = new ArrayList<Integer>();
			for (int index = 2017; index <= 2021; ++index)
			{
				yearsArray.add(new Integer(index));
			}
			request.getSession().setAttribute("yearsArray", yearsArray);
		}
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/changeDayView.jsp");
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
