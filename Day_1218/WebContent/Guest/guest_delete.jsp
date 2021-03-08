<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import = "java.sql.*" %>
<%
Connection conn = null;
PreparedStatement pstmt = null;
//1.드라이버 로딩
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//out.print("드라이브 로딩 성공");
	}
	catch(Exception e){
		e.printStackTrace();
	}
	
	//2. DB 연결 설정
	try{
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","jslhrd46","1234");
	}
	catch(Exception e){
		e.printStackTrace();
	}
	
	int idx = Integer.parseInt(request.getParameter("idx"));
	String sql = "delete from tbl_guest where idx = ?";
	pstmt = conn.prepareStatement(sql);
	pstmt.setInt(1, idx);
	int row = pstmt.executeUpdate();
	
	if(row == 1){
		%>
		<script>
			alert("삭제 성공");
			location.href="guest_list.jsp";
		</script>
	<%
	}
	%>
	

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

</body>
</html>