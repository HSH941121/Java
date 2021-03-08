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
 * Servlet implementation class guestmodifyservlet
 */
@WebServlet("/guest_modify")
public class guestmodifyservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public guestmodifyservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		GuestDAO dao = GuestDAO.getInstance();
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		int page = Integer.parseInt(request.getParameter("page"));
		
		GuestDTO dto = dao.guestSelect(idx);
		
		request.setAttribute("page", page);
		request.setAttribute("guest", dto);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Guest/guest_modify.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		GuestDTO guest = new GuestDTO();
		GuestDAO dao = GuestDAO.getInstance();
		guest.setIdx(Integer.parseInt(request.getParameter("idx")));
		guest.setPass(request.getParameter("pass"));
		guest.setSubject(request.getParameter("subject"));
		guest.setContents(request.getParameter("contents"));
		int page = Integer.parseInt(request.getParameter("pgae"));
		
		int row = dao.guestModify(guest);
		request.setAttribute("page", page);
		request.setAttribute("row", row);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Guest/guest_modify_pro.jsp");
		dispatcher.forward(request, response);
	}

}
