package Day_1229.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Day_1229.model.GuestDAO;
import Day_1229.model.GuestDTO;

/**
 * Servlet implementation class GuestWriteServlet
 */
@WebServlet("/guest_write")
public class GuestWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuestWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int page = Integer.parseInt(request.getParameter("page"));
		
		request.setAttribute("page", page);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("Guest/guest_write.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		GuestDAO DAO = GuestDAO.getInstance();
		GuestDTO DTO = new GuestDTO();
		DTO.setName(request.getParameter("name"));
		DTO.setPass(request.getParameter("pass"));
		DTO.setSubject(request.getParameter("subject"));
		DTO.setContents(request.getParameter("contents"));
		int page = Integer.parseInt(request.getParameter("page"));
		
		int row = DAO.guestWrite(DTO);
		
		request.setAttribute("row", row);
		request.setAttribute("page", page);
		
		//response.sendRedirect("guest_list?page="+page);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Guest/guest_write_pro.jsp");
		dispatcher.forward(request, response);
	}

}
