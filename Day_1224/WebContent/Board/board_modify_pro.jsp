<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<%@ page import = "Day_1224.model.*" %>
<%
	request.setCharacterEncoding("utf-8");

	BoardVO vo = new BoardVO();
	int idx = Integer.parseInt(request.getParameter("idx"));
	vo.setIdx(idx);
	vo.setEmail(request.getParameter("email"));
	vo.setPass(request.getParameter("pass"));
	vo.setSubject(request.getParameter("subject"));
	vo.setContents(request.getParameter("contents"));
	
	BoardDAO dao = BoardDAO.getInstance();
	int row = dao.boardEdit(vo);
	
	if(row == 1){
%>
	<script>
		alert("수정 성공");
		location.href="board_list.jsp";
	</script>
<%
	}
	else{
	
%>
<script>
		alert("비밀번호가 틀립니다!!")
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