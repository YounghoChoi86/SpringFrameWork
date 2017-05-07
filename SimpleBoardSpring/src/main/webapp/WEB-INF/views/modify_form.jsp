<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<jsp:include page="header.jsp" flush="false" />
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp" flush="false" />
	
	<a href="list" class="btn btn-info">목록가기</a>
	<a href="reply" class="btn btn-info">답변달기</a> 
	<a href="delete" class="btn btn-info">삭제하기</a> <br>
	<form action="modify" method="post">
	<table class="table table-bordered table-striped nanum">
		<colgroup>
			<col class="col-xs-1">
			<col class="col-xs-2">
		</colgroup>
		
		<tr>
			<td><input type="hidden" class="form-control" name="bId"  value="${bId }" readonly /></td>       
		</tr>
		<tr>
			<td>이름</td>
			<td><input type="text" class="form-control" name="bName" value="${bName }"></td>
		</tr>
		
		<tr>
			<td>제목</td>
			<td><input type="text"class="form-control"  name="bTitle" value="${bTitle }"></td>
		</tr>
		<tr>
			<td>내용</td>
			<td><textarea class="form-control" name="bContent">${bContent}</textarea></td>
		</tr>
	</table>
	<input type="submit" class="btn btn-info" value="수정완료"><a href="list" class="btn btn-info">취소</a>
	</form>
	


</body>
</html>