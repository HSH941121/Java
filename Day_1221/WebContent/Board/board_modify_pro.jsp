<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<%@ page import = "java.sql.*" %>


<%
//db 연걸
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	int totcount = 0; //전체 건수 카운트
	
//1.드라이버 로딩
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","jslhrd46","1234");
	
	}
	catch(Exception e){
		e.printStackTrace();
	}
	
	request.setCharacterEncoding("utf-8");
	int idx = Integer.parseInt(request.getParameter("idx"));
	String email = request.getParameter("email");
	String subject = request.getParameter("subject");
	String contents = request.getParameter("contents");
	String pass = request.getParameter("pass");
	String ip = request.getRemoteAddr();
	
	String sql = "update tbl_board set email = ?, subject = >= ?, contents = ? where idx = ? and pass = ?";
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, email);
	pstmt.setString(2, subject);
	pstmt.setString(3, contents);
	pstmt.setInt(4, idx);
	pstmt.setString(5, pass);
	
	
	int row = pstmt.executeUpdate();
	
	if(row == 0){
		
%>
<script>
	alert("오류");
	history.back();
</script>
<%
	}
	else{
%>
<script>
	alert("수정되었습니다.");
	location.href = "board_list.jsp";
</script>
<%
	}
%>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

</body>
</html>