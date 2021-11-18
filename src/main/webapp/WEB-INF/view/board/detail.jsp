<%@ page import="com.koreait.board2.model.BoardVO" %>
<%@ page import="com.koreait.board2.model.UserVO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    BoardVO vo = (BoardVO) request.getAttribute("detail");
    UserVO loginUser = (UserVO) session.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>디테일</title>
    <style>
    </style>
</head>
<body>
    <h1><%=vo.getTitle()%></h1>
    <div>
        <a href="/board/list"><input type="button" value="리스트로 돌아가기"></a>
    </div>
    <% if(loginUser != null && loginUser.getIuser()==vo.getWriter()){%>
        <a href="/board/mod?iboard=<%=vo.getIboard()%>"><input type="button" value="수정"></a>
        <a href="/board/del?iboard=<%=vo.getIboard()%>"><input type="button" value="삭제"></a>
    <%}%>
    <div>${requestScope.err}</div>
    <div>[ <%=vo.getIboard()%> ]</div>
    <div>제목 : <%=vo.getTitle()%></div>
    <div>작성자 : <%=vo.getWriterNm()%></div>
    <div>(<%=vo.getRdt()%>)</div>
    <hr>
    <div><%=vo.getCtnt()%></div>
</body>
</html>
