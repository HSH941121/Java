<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<%@ page import="java.sql.*" %>
<%
int dno = 50;
String dname = "aaaaa";
String loc = "ddd";


Connection conn = null;
PreparedStatement pstmt = null;
//1.����̹� �ε�
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//out.print("����̺� �ε� ����");
	}
	catch(Exception e){
		e.printStackTrace();
	}
	
	//2. DB ���� ����
	try{
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","jslhrd46","1234");
	}
	catch(Exception e){
		e.printStackTrace();
	}
	String sql = "insert into department (dno,dname,loc) values(?,?,?)";
	pstmt = conn.prepareStatement(sql);
	pstmt.setInt(1, dno);
	pstmt.setString(2, dname);
	pstmt.setString(3, loc);
	int row = pstmt.executeUpdate();
	
	if(row == 1){
		%>
		<script>
			alert("����");
		</script>
		<%
	}
	else{
		%>
		<script>
			alert("����");
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