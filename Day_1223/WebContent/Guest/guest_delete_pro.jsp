<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<%@ page import = "Day_1223.model.*" %>
<%
	request.setCharacterEncoding("utf-8");
	int idx = Integer.parseInt(request.getParameter("idx"));
	String pass = request.getParameter("pass");
	
	GuestDAO dao = new GuestDAO();
	
	int row = dao.guestDelete(idx, pass);
	
	if(row == 1){
%>
	<script>
	opener.location.replace("guest_list.jsp");
	self.close();
	</script>
<% 
	}
	else{
%>
<script>
	alert("��й�ȣ�� ���� �ʽ��ϴ�.");
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