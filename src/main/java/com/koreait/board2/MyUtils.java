package com.koreait.board2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
}
