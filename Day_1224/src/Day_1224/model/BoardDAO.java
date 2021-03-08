package Day_1224.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;









public class BoardDAO {
	//싱글톤
	private BoardDAO() {
		
	}
	
	private static BoardDAO instance = new BoardDAO();
	public static BoardDAO getInstance() {
		return instance;
	}
	
	
	private static Connection getConnection() {
		
		Connection conn = null;
		
		
	//1.드라이버 로딩
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","jslhrd46","1234");
		
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return conn;
}


//메소드 정의

	public int boardCount() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int row = 0;
		String sql = "select count(*) from tbl_board";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
		
			if(rs.next()) {
				row = rs.getInt(1);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	
		return row; 
	}
	
	public List<BoardVO> boardList() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BoardVO> list = new ArrayList<BoardVO>();
		String sql = "select * from tbl_board order by idx desc";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setSubject(rs.getString("subject"));
				vo.setRegdate(rs.getString("regdate"));
				vo.setReadcnt(rs.getInt("readcnt"));
				
				list.add(vo);
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return list; 
	}
	
	public int boardWrite(BoardVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int row = 0;
		String sql = "insert into tbl_board(idx,name,pass,email,subject,contents,ip) values(tbl_board_seq_idx.nextval,?,?,?,?,?,?)";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPass());
			pstmt.setString(3, vo.getEmail());
			pstmt.setString(4, vo.getSubject());
			pstmt.setString(5, vo.getContents());
			pstmt.setString(6, vo.getIp());
			row = pstmt.executeUpdate();
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				pstmt.close();
				conn.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return row; 
	}
	
	
	public BoardVO boardSelect(int idx) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardVO vo = new BoardVO();
		String sql = "select * from tbl_board where idx = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setPass(rs.getString("pass"));
				vo.setSubject(rs.getString("subject"));
				vo.setContents(rs.getString("contents"));
				vo.setRegdate(rs.getString("regdate"));
				vo.setReadcnt(rs.getInt("readcnt"));
			}
			
						
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return vo; 
	}
	
	public void boardHits(int idx) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "update tbl_board set readcnt = readcnt + 1 where idx = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {

				pstmt.close();
				conn.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
	
	public int boardEdit(BoardVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		int row = 1;
		String sql = "update tbl_board set subject = ? , contents = ? , email = ?  where idx = ? and pass = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getSubject());
			pstmt.setString(2, vo.getContents());
			pstmt.setString(3, vo.getEmail());
			pstmt.setInt(4, vo.getIdx());
			pstmt.setString(5, vo.getPass());
			row = pstmt.executeUpdate();
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				pstmt.close();
				conn.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return row; 
	}
	
	public int boardDelete(int idx, String pass) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		int row = 1;
		String sql = "delete from tbl_board where idx = ? and pass = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,idx);
			pstmt.setString(2,pass);
			row = pstmt.executeUpdate();
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				pstmt.close();
				conn.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return row; 
	}
	
	public int boardCount(String search, String key) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int row = 0;
		String sql = "select count(*) from tbl_board where " + search + " like '%" + key + "%'";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
		
			if(rs.next()) {
				row = rs.getInt(1);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	
		return row; 
	}
	
	public List<BoardVO> boardList(String search, String key) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BoardVO> list = new ArrayList<BoardVO>();
		String sql = "select * from tbl_board where " + search + " like '%" + key + "%' order by idx desc";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setSubject(rs.getString("subject"));
				vo.setRegdate(rs.getString("regdate"));
				vo.setReadcnt(rs.getInt("readcnt"));
				
				list.add(vo);
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return list; 
	}
	
	public List<BoardVO> boardList(int startpage, int endpage) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BoardVO> list = new ArrayList<BoardVO>();
		String sql = "select X.* from (select rownum as rnum, A.* from (select * from tbl_board order by idx desc) A where rownum <=? ) X where X.rnum >= ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, endpage);
			pstmt.setInt(2, startpage);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setSubject(rs.getString("subject"));
				vo.setRegdate(rs.getString("regdate"));
				vo.setReadcnt(rs.getInt("readcnt"));
				
				list.add(vo);
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return list; 
	}
	public List<BoardVO> boardList(String search, String key, int startpage, int endpage) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BoardVO> list = new ArrayList<BoardVO>();
		String sql = "select X.* from (select rownum as rnum, A.* from (select * from tbl_board order by idx desc) A where " + search + " like '%" + key + "%' and rownum <=? ) X where X.rnum >= ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, endpage);
			pstmt.setInt(2, startpage);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setSubject(rs.getString("subject"));
				vo.setRegdate(rs.getString("regdate"));
				vo.setReadcnt(rs.getInt("readcnt"));
				
				list.add(vo);
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return list; 
	}
}
