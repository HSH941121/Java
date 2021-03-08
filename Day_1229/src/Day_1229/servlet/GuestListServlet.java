package Day_1229.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Day_1229.model.GuestDAO;
import Day_1229.model.GuestDTO;
import Day_1229.util.PageIndex;

/**
 * Servlet implementation class GuestListServlet
 */
@WebServlet("/guest_list.do")
public class GuestListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuestListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GuestDAO DAO = GuestDAO.getInstance();
		String sql = "", search = "",key="";
		int totcount = 0; //게시글 총 수
		
		//검색이 있을경우
		if(request.getParameter("key") != null) {
			key = request.getParameter("key");
			search = request.getParameter("search");
			sql = search + " like '%" + key + "%'";
			totcount = DAO.guestCount(sql);
		}
		else {
			totcount = DAO.guestCount();
		}
		
		int nowpage = 1;
		int maxlist = 10;
		int totpage = 1;
		
		//총페이지수 계산
		if(totcount % maxlist == 0) {
			totpage = totcount / maxlist;
		}
		else {
			totpage = (totcount / maxlist) + 1;
		}
		
		//페이지번호가 입력될 경우
		if(request.getParameter("page") != null) {
			nowpage = Integer.parseInt(request.getParameter("page"));
		}
		
		int startpage = (nowpage-1)*maxlist + 1;
		int endpage = nowpage * maxlist;
		int listcount = totcount -(nowpage-1)*maxlist;
		
		List<GuestDTO> list = null;
		if(key.equals("")) {
			list = DAO.guestList(startpage,endpage);
		}
		else {
			list = DAO.guestList(startpage,endpage,sql);
		}
		
		String pageSkip = "";
		if(key.equals("")) {
			pageSkip = PageIndex.pageList(nowpage, totpage, "guest_list", "");
		}
		else {
			pageSkip = PageIndex.pageListHan(nowpage, totpage, "guest_list", search, key);
		}
		
		request.setAttribute("page", nowpage);
		request.setAttribute("totcount", totcount);
		request.setAttribute("listcount", listcount);
		request.setAttribute("totpage", totpage);
		request.setAttribute("list", list);
		request.setAttribute("pageSkip", pageSkip);
		request.setAttribute("search", search);
		request.setAttribute("key", key);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("Guest/guest_list.jsp");
		
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
