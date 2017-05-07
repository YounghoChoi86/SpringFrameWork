<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<jsp:include page="header.jsp" flush="false" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="header.jsp" flush="false" />
<title>Insert title here</title>
</head>
<body>
	
	<jsp:include page="menu.jsp" flush="false" />
	<a href="list" class="btn btn-info">목록가기</a>
	<form action="write" method="post">
		<table class="table table-bordered table-striped nanum">
			<colgroup>
				<col class="col-xs-1">
				<col class="col-xs-7">
			</colgroup>
			<tr>
				<td>이름</td>
				<td><input class="mywidth" type="text" name="bName"></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input class="mywidth" type="text" name="bTitle"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea class="mywidth" name="bContent"></textarea></td>
			</tr>
			<tr>
				<td><input type="submit" value="올리기" class="btn btn-info"></td>
				<td><input type="reset" value="초기화 " class="btn btn-info"></td>
			</tr>
		</table>
	</form>

</body>
</html>