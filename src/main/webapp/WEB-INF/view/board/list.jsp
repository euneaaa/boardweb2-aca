<%@ page import="com.koreait.board2.model.UserVO" %>
<%@ page import="java.util.List" %>
<%@ page import="com.koreait.board2.model.BoardVO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    UserVO loginUser = (UserVO) session.getAttribute("loginUser");
    List<BoardVO> list = (List<BoardVO>) request.getAttribute("data");
    int maxPage = (int) request.getAttribute("maxPage");
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>List</title>
    <style>
        table , tr{ border-collapse: collapse; border: 1px solid black;
        }
        td {text-align: center;
            padding: 3px 15px 3px 15px;
        }
        .page {margin-top: 20px;
            text-align: center;}
        .line {border-right: 1px solid black;}
    </style>
</head>
<body>
    <% if(loginUser != null){%>
        <div>
            <a href="/board/write"><input type="button" value="글쓰기"></a>
            <%=loginUser.getNm()%>님 환영합니다. <a href="/user/logout"><input type="button" value="로그아웃"></a>
        </div>
    <%}else {%>
        <div><a href="/user/login"><input type="button" value="로그인"></a> </div>
    <%}%>
    <h1>목록</h1>
    <table>
        <tr>
            <th class="line">번호</th>
            <th>제목</th>
            <th>작성일시</th>
            <th>글쓴이</th>
        </tr>
        <%for(BoardVO vo : list){%>
        <tr>
            <td class="line"><%=vo.getIboard()%></td>
            <td><a href="/board/detail?iboard=<%=vo.getIboard()%>"><%=vo.getTitle()%></td></a>
            <td><%=vo.getRdt()%></td>
            <td><%=vo.getWriterNm()%></td>
        </tr>
        <%}%>
    </table>
    <div class="page" style="margin-top: 20px">

        <%for(int i= 1; i<=maxPage; i++){%>
        <span>
            <a href="/board/list?page=<%=i%>"><%=i%></a>
        </span>&nbsp;
        <%}%>
    </div>

</body>
</html>
