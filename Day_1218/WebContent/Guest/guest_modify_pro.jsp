<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import = "java.sql.*" %> 
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
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
	ResultSet rs = null;
	int idx = Integer.parseInt(request.getParameter("idx"));  
	String subject = request.getParameter("subject");
	String contents = request.getParameter("contents");
	String sql = "update tbl_guest set subject = ? ,contents = ? where idx = ?";
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, subject);
	pstmt.setString(2, contents);
	pstmt.setInt(3, idx);
	rs = pstmt.executeQuery();
	
	if(rs.next()){
		
	%>
	<script>
		alert("수정성공");
		location.href="guest_list.jsp";
	</script>
	<%
	}
	else{
	%>
	<script>
		alert("수정실패");
		history.back();
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