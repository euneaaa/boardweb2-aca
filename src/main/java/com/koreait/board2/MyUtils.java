package com.koreait.board2;

import com.koreait.board2.model.UserVO;

import javax.jws.soap.SOAPBinding;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class MyUtils {

    public static void disForward(HttpServletRequest req, HttpServletResponse res, String s) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/view/"+s+".jsp").forward(req,res);
    }

    public static int parseStringToInt(String str, int defVal){
        try {
            return Integer.parseInt(str);
        }catch (Exception e){
            e.printStackTrace();
        }
        return defVal;
    }

    public static int parseStringToInt(String str){
        return parseStringToInt(str, 0);
    }

    public static int getParameterInt(HttpServletRequest req, String str){
        return parseStringToInt(req.getParameter(str));
    }

    public static int getParameterInt(HttpServletRequest req, String str, int defVal){
        return parseStringToInt(req.getParameter(str), defVal);
    }

    public static int getLoginUserPk(HttpServletRequest req){
        UserVO loginUser = getLoginUser(req);
        return loginUser == null? 0 : loginUser.getIuser();
    }

    public static boolean isLogin(HttpServletRequest req){
        return getLoginUser(req)!=null;
    }
    public static boolean isLogout(HttpServletRequest req){
        return getLoginUser(req)==null;
    }

    public static UserVO getLoginUser(HttpServletRequest req){
        HttpSession session = req.getSession();
        return (UserVO) session.getAttribute("loginUser");
    }
}
