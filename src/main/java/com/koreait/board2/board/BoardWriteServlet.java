package com.koreait.board2.board;

import com.koreait.board2.MyUtils;
import com.koreait.board2.model.BoardVO;
import com.koreait.board2.model.UserVO;

import javax.jws.soap.SOAPBinding;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/board/write")
public class BoardWriteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession();
        UserVO loginUser = (UserVO) session.getAttribute("loginUser");
        if (loginUser == null) {
            res.sendRedirect("/board/list");
            return;
        }
        MyUtils.disForward(req,res,"board/write");
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        BoardVO board = new BoardVO();
        board.setTitle(req.getParameter("title"));
        board.setCtnt(req.getParameter("ctnt"));
        HttpSession session = req.getSession();
        UserVO loginUser = (UserVO) session.getAttribute("loginUser");
        board.setWriter(loginUser.getIuser());
        int result = BoardDAO.insBoard(board);
        switch (result){
            case 1:
                res.sendRedirect("/board/list");
                break;
            case 0:
                req.setAttribute("err", "글 등록에 실패하였습니다.");
                doGet(req,res);
                break;
        }
    }
}
