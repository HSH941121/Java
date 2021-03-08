<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<%@ page import = "java.sql.*" %>
<%
	request.setCharacterEncoding("utf-8");
%>

<%
	//값 받기
	String name = request.getParameter("name");
	String subject = request.getParameter("subject");
	String contents = request.getParameter("contents");

	//DB연결하기
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
	
	String sql = "insert into tbl_guest(idx,name,subject,contents) values(tbl_guest_seq_idx.nextval,?,?,?)";
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, name);
	pstmt.setString(2, subject);
	pstmt.setString(3, contents);
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