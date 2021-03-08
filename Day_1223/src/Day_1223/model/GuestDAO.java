package Day_1223.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/* Data Access Object
 * 1. 드라이버로딩 - 커넥션 연결 - CRUD
 * 
 * 
 */
public class GuestDAO {
	
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
	
	public int guestCount() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int row = 0;
		String sql = "select count(*) from tbl_guest";
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
				rs.close();
				pstmt.close();
				conn.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return row; 
	}
	
	
	public int guestWrite(GuestVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int row = 0;
		String sql = "insert into tbl_guest(idx,name,pass,subject,contents) values(tbl_guest_seq_idx.nextval,?,?,?,?)";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPass());
			pstmt.setString(3, vo.getSubject());
			pstmt.setString(4, vo.getContents());
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
	
	public List<GuestVO> guestList() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<GuestVO> list = new ArrayList<GuestVO>();
		String sql = "select * from tbl_guest order by idx desc";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				GuestVO vo = new GuestVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setSubject(rs.getString("subject"));
				vo.setContents(rs.getString("contents"));
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
	
	public GuestVO guestSelect(int idx) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		GuestVO vo = new GuestVO();
		String sql = "select * from tbl_guest where idx = ?";
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
	
	public void guestHits(int idx) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "update tbl_guest set readcnt = readcnt + 1 where idx = ?";
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
	
	public int guestEdit(GuestVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		int row = 1;
		String sql = "update tbl_guest set subject = ? , contents = ? where idx = ? and pass = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getSubject());
			pstmt.setString(2, vo.getContents());
			pstmt.setInt(3, vo.getIdx());
			pstmt.setString(4, vo.getPass());
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
	
	public int guestDelete(int idx, String pass) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		int row = 1;
		String sql = "delete from tbl_guest where idx = ? and pass = ?";
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
}
