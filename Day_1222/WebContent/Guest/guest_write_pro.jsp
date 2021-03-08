<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<%@ page import = "java.sql.*" %>
<%
//db 연걸
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
//1.드라이버 로딩
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","jslhrd46","1234");
	
	}
	catch(Exception e){
		e.printStackTrace();
	}
	request.setCharacterEncoding("utf-8");
	String name = request.getParameter("name");
	String pass = request.getParameter("pass");
	String subject = request.getParameter("subject");
	String contents = request.getParameter("contents");
	String ip = request.getRemoteAddr();
	
	String sql = "insert into tbl_guest2(idx,name,subject,contents,ip,pass) values(tbl_guest_seq_idx2.nextval,?,?,?,?,?)";
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, name);
	pstmt.setString(2, subject);
	pstmt.setString(3, contents);
	pstmt.setString(4, ip);
	pstmt.setString(5, pass);
	int row = pstmt.executeUpdate();
	if(row == 1){
		//response.sendRedirect("guest_list.jsp?row"+row);
		%>
		<script>
			alert("등록되었습니다.");
			location.href = "guest_list.jsp";
		</script>
		<%
	}
	else{
		%>
		<script>
			alert("등록실패");
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