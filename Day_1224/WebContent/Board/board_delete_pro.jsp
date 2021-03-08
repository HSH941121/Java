<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<%@ page import = "Day_1224.model.*" %>
<%
	request.setCharacterEncoding("utf-8");
	int idx = Integer.parseInt(request.getParameter("idx"));
	String pass = request.getParameter("pass");
	
	BoardDAO dao = BoardDAO.getInstance();
	
	int row = dao.boardDelete(idx, pass);
	
	if(row == 1){
%>
	<script>
	opener.location.replace("board_list.jsp");
	self.close();
	</script>
<% 
	}
	else{
%>
<script>
	alert("비밀번호가 맞지 않습니다.");
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