package com.koreait.board2.board;

import com.koreait.board2.MyUtils;
import com.koreait.board2.model.BoardParamVO;
import com.koreait.board2.model.BoardVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/board/list")
public class BoardListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        BoardParamVO param = new BoardParamVO();
        int recordCnt = 5;
        param.setRecordCnt(recordCnt);
        req.setAttribute("maxPage", BoardDAO.selMaxPage(param));

        int page = MyUtils.getParameterInt(req, "page",1);
        HttpSession session = req.getSession();
        session.setAttribute("listpage", page );
        param.setPage(page);
        List<BoardVO> list = BoardDAO.selListBoard(param);

        req.setAttribute("data", list);
        MyUtils.disForward(req,res,"board/list");
    }
}
