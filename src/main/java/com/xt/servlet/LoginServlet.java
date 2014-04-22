package com.xt.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.xt.model.User;

public class LoginServlet extends HttpServlet { 
    private static final long serialVersionUID = 6655227641354075528L; 
 
    public boolean isLogin(HttpServletRequest request){ 
    	
        HttpSession session = request.getSession(); 
        if(null == session){ 
            return false; 
        } 
        User user = (User)session.getAttribute("loginUser"); 
        if(null == user){ 
            return false; 
        } 
        return true; 
    } 
} 
