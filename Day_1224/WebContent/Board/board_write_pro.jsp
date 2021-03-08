<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<%@ page import = "Day_1224.model.*" %>
<%
	request.setCharacterEncoding("utf-8");
	String name = request.getParameter("name");
	String pass = request.getParameter("pass");
	String subject = request.getParameter("subject");
	String contents = request.getParameter("contents");
	String email = request.getParameter("email");
	String ip = request.getRemoteAddr();
	
	BoardVO vo = new BoardVO();
	vo.setName(name);
	vo.setPass(pass);
	vo.setSubject(subject);
	vo.setContents(contents);
	vo.setEmail(email);
	vo.setIp(ip);
	
	BoardDAO dao = BoardDAO.getInstance();
	int row = dao.boardWrite(vo);
	if(row == 1){
%>
	<script>
		alert("등록 성공");
		location.href="board_list.jsp";
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