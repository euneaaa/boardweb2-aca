package com.koreait.board2.board;

import com.koreait.board2.MyUtils;
import com.koreait.board2.model.BoardVO;
import com.koreait.board2.model.UserVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/board/del")
public class BoardDelServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int iboard = MyUtils.getParameterInt(req, "iboard");
        HttpSession session = req.getSession();
        UserVO loginUser = (UserVO) session.getAttribute("loginUser");
        if(loginUser ==null){
            req.setAttribute("err", "로그인 해주세요.");
            req.getRequestDispatcher("/board/detail").forward(req,res);
            return;
        }
        BoardVO param = new BoardVO();
        param.setWriter(loginUser.getIuser());
        param.setIboard(iboard);
        int result = BoardDAO.delBoard(param);
        if(result == 0){
            req.setAttribute("err", "로그인 사용자가 작성한 글이 아닙니다.");
            req.getRequestDispatcher("/board/detail").forward(req,res);
            return;
        }
        res.sendRedirect("/board/list");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

    }
}
