<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<%@ page import = "java.sql.*" %>
<%
	request.setCharacterEncoding("utf-8");
%>

<%
	//�� �ޱ�
	String name = request.getParameter("name");
	String subject = request.getParameter("subject");
	String contents = request.getParameter("contents");

	//DB�����ϱ�
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
			alert("��ϵǾ����ϴ�.");
			location.href = "guest_list.jsp";
		</script>
		<%
	}
	else{
		%>
		<script>
			alert("��Ͻ���");
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