<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>

<%
	int row = (int)request.getAttribute("row");

	if(row == 1){

%>

<script>
	alert("삭제되었습니다.")
	opener.location.href="guest_list.do?page=${page}";
	self.close();
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