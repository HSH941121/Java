<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<%@ page import="java.sql.*" %>

<%	
	//1.����̹� �ε�
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		out.print("����̺� �ε� ����");
	}
	catch(Exception e){
		e.printStackTrace();
	}
	
	//2. DB ���� ����
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