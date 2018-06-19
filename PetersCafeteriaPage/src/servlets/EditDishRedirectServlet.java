package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.DishInstance;

/**
 * Servlet implementation class EditDishRedirectServlet
 */
@WebServlet("/EditDish")
public class EditDishRedirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditDishRedirectServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dishNameToEdit = (String) request.getParameter("dishToEdit");
		ArrayList<DishInstance> toCompare = (ArrayList<DishInstance>) request.getSession().getAttribute("dishList");
		int positionScalar = 0;
		DishInstance beingEdited = null;
		for (int index = 0; index < toCompare.size(); ++index)
		{
			if (toCompare.get(index).dishName.equals(dishNameToEdit))
			{
				positionScalar=index;
				beingEdited = toCompare.get(index);
			}
		}
		request.setAttribute("positionScalar", positionScalar);
		request.setAttribute("dishToEdit", beingEdited);
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/editDishView.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
