<%@ page import="com.koreait.board2.model.BoardVO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String err = (String) request.getAttribute("err");
    BoardVO moderr = (BoardVO) request.getAttribute("moderrdata");
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Write</title>
</head>
<body>
    <h1>글수정</h1>
        <div>${requestScope.err}</div>
    <div>
        <form action="/board/mod" method="post">
            <input type="hidden" name="iboard" value="${requestScope.detail.iboard}">
            <div><input type="text" name="title" placeholder="title" value="${requestScope.detail.title}"></div>
            <div>
                <textarea name="ctnt" placeholder="content">${requestScope.detail.ctnt}</textarea>
            </div>
            <div>
                <input type="submit" value="수정">
                <input type="reset" value="초기화">
            </div>
        </form>
    </div>
</body>
</html>
