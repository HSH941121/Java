<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<%@ page import = "Day_1223.model.*" %>
<%
	request.setCharacterEncoding("utf-8");
	String name = request.getParameter("name");
	String pass = request.getParameter("pass");
	String subject = request.getParameter("subject");
	String contents = request.getParameter("contents");
	
	GuestVO vo = new GuestVO();
	vo.setName(name);
	vo.setPass(pass);
	vo.setSubject(subject);
	vo.setContents(contents);
	
	GuestDAO dao = new GuestDAO();
	int row = dao.guestWrite(vo);
	if(row == 1){
%>
	<script>
		alert("등록 성공");
		location.href="guest_list.jsp";
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