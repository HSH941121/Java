<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<%@ page import="java.sql.*" %>

<%	
	//1.드라이버 로딩
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		out.print("드라이브 로딩 성공");
	}
	catch(Exception e){
		e.printStackTrace();
	}
	
	//2. DB 연결 설정
	try{
		Connection conn = DriverManager.getConnection("jdbc:orcle:thin:@localhost:1521:xe","jslrd46","1234");
	}
	catch(Exception e){
		e.printStackTrace();
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