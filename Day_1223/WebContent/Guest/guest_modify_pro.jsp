<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<%@ page import = "Day_1223.model.*" %>
<%
	request.setCharacterEncoding("utf-8");

	GuestVO vo = new GuestVO();
	int idx = Integer.parseInt(request.getParameter("idx"));
	vo.setIdx(idx);
	vo.setPass(request.getParameter("pass"));
	vo.setSubject(request.getParameter("subject"));
	vo.setContents(request.getParameter("contents"));
	
	GuestDAO dao = new GuestDAO();
	int row = dao.guestEdit(vo);
	out.print(row);
	if(row == 1){
%>
	<script>
		alert("수정 성공");
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