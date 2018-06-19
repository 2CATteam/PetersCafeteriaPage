package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.DishInstance;

/**
 * Servlet implementation class EditDishServlet
 */
@WebServlet("/MarkDish")
public class EditDishServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditDishServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String toUpdateName = request.getParameter("dishNameToEdit");
		ArrayList<DishInstance> dishList = (ArrayList<DishInstance>) request.getSession().getAttribute("dishList");
		DishInstance toUpdate = null;
		for (DishInstance updateCandidate: dishList)
		{
			if (updateCandidate.dishName.equals(toUpdateName))
			{
				toUpdate = updateCandidate;
			}
		}
		try
		{
			int amountPrepped = Integer.parseInt(request.getParameter("updateAmountPrepped"));
			toUpdate.setAmountPrepped(amountPrepped);
		}
		catch (Exception e)
		{
		}
		try
		{
			int amountLeft = Integer.parseInt(request.getParameter("updateAmountLeft"));
			toUpdate.setAmountLeft(amountLeft);
		}
		catch (Exception e)
		{
		}
		try
		{
			double tempStart = Double.parseDouble(request.getParameter("updateTempStart"));
			toUpdate.setTempStart(tempStart);
		}
		catch (Exception e)
		{
		}
		try
		{
			double tempEnd = Double.parseDouble(request.getParameter("updateTempEnd"));
			toUpdate.setTempEnd(tempEnd);
		}
		catch (Exception e)
		{
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
