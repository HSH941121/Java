<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%@ page import = "java.sql.*" %>


<%
//db ����
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	int totcount = 0; //��ü �Ǽ� ī��Ʈ
	
//1.����̹� �ε�
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","jslhrd46","1234");
	
	}
	catch(Exception e){
		e.printStackTrace();
	}
	
	int idx = Integer.parseInt(request.getParameter("idx"));
	String pass = request.getParameter("pass");
	
	String sql = "delete from tbl_board where idx = ? and pass = ?";
	pstmt = conn.prepareStatement(sql);
	pstmt.setInt(1, idx);
	pstmt.setString(2, pass);
	int row = pstmt.executeUpdate();
	
	if(row == 1){
		
%>

<script>
	alert("�����Ǿ����ϴ�.");
	self.close();

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