<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>

<%
	int row = (int)request.getAttribute("row");

	if(row == 1){

%>

<script>
	alert("등록되었습니다.")
	location.href="guest_list.do?page=${page}";
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