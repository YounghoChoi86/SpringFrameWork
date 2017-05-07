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
	<jsp:include page="menu.jsp" flush="false" />
	<form action="modifyForm" method="post">

		<a href="list" class="btn btn-info">목록가기</a> 
		<a href="replyForm?bId=${content_view.bId}" class="btn btn-info">답변달기</a> 
		<a href="delete?bId=${content_view.bId}" class="btn btn-info">삭제하기</a>
		<input type="submit" class="btn btn-info" value="수정하기" /> <br> 
		<input
			type="hidden" name="bId" value="${content_view.bId}"> 
		<input
			type="hidden" name="bTitle" value="${content_view.bTitle}"> 
		<input
			type="hidden" name="bName" value="${content_view.bName}">
		<input
			type="hidden" name="bContent" value="${content_view.bContent}">
	</form>

	<table class="table table-bordered table-striped nanum">
		<colgroup>
			<col class="col-xs-1">
			<col class="col-xs-7">
		</colgroup>
		<tr>
			<td>이름</td>
			<td>${content_view.bName}</td>
		</tr>
		<tr>
			<td>조회수</td>
			<td>${content_view.bHit }</td>
		</tr>

		<tr>
			<td>제목</td>
			<td>${content_view.bTitle }</td>
		</tr>
		<tr>
			<td>내용</td>
			<td>${content_view.bContent }</td>
		</tr>
		<tr>
		</tr>
	</table>
	
</body>
</html>