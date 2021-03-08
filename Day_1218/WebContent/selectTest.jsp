<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<%@ page import = "java.sql.*" %>
<%
	//db 연걸
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
	String sql = "select * from department";
	ResultSet rs = null;
	pstmt = conn.prepareStatement(sql);
	rs = pstmt.executeQuery();


%>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table border = 1>
		<tr>
			<td>부서번호</td><td>부서명</td><td>지역명</td>
		</tr>
		<%
			while(rs.next()){
				int dno = rs.getInt("dno");
				String name = rs.getString("dname");
				String loc = rs.getString("loc");
		%>
		<tr>
			<td><%=rs.getInt("dno") %></td><td><%=rs.getString("dname") %></td><td><%=rs.getString("loc") %></td>
		</tr>
	<%
			}
	%>
	
	</table>
</body>
</html>