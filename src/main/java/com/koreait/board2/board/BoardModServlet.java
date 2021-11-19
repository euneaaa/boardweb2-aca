package com.koreait.board2.board;

import com.koreait.board2.MyUtils;
import com.koreait.board2.model.BoardVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/board/mod")
public class BoardModServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        if(MyUtils.isLogout(req)){
            res.sendRedirect("/user/login");
            return;
        }

        int iboard = Integer.parseInt(req.getParameter("iboard"));
        BoardVO param = new BoardVO();
        param.setIboard(iboard);
        if(req.getAttribute("detail")==null){
            BoardVO result = BoardDAO.selBoard(param);
            req.setAttribute("detail", result);
        }
        MyUtils.disForward(req, res, "board/mod");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String sIboard = req.getParameter("iboard");
        int iboard = Integer.parseInt(sIboard);
        BoardVO param = new BoardVO();
        param.setIboard(iboard);
        param.setTitle(req.getParameter("title"));
        param.setCtnt(req.getParameter("ctnt"));
        param.setWriter(MyUtils.getLoginUserPk(req));
        int result = BoardDAO.modBoard(param);
        switch(result) {
            case 1:
                res.sendRedirect("/board/detail?iboard="+sIboard);
                break;
            case 0:
                req.setAttribute("err", "수정에 실패하였습니다.");
                req.setAttribute("detail" ,param);
                doGet(req,res);
                break;
        }

    }
}
