package com.xt.basic.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.xt.model.User;
import com.xt.servlet.LoginServlet;

/**
* EasyMock框架在使用时只需要一个easymock-3.1.jar 
* 下载地址为http://sourceforge.net/projects/easymock/files/
* @create Jul 9, 2013 2:28:41 PM
* @author 玄玉<HTTP: jadyer="" net="" csdn="" blog="">
*/ 
public class LoginServletTest { 
   private LoginServlet servlet; 
   private HttpServletRequest request; 
   private HttpSession session; 
    
   @Before 
   public void init(){ 
       servlet = new LoginServlet(); 
       request = EasyMock.createStrictMock(HttpServletRequest.class); 
       session = EasyMock.createStrictMock(HttpSession.class); 
   } 
    
   /**
    * 测试登录失败的情况(session为空)
    */ 
   @Test 
   public void testIsLoginFailSessionIsNull(){ 
       //声明HttpServletRequest获取到的HttpSession是空的  
       EasyMock.expect(request.getSession()).andReturn(null); 
       EasyMock.replay(request, session); 
       //验证HttpSession为空时登录应该是失败的  
       Assert.assertFalse(servlet.isLogin(request)); 
       EasyMock.verify(request, session); 
   } 
    
   /**
    * 测试登录失败的情况(session中无用户)
    */ 
   @Test 
   public void testIsLoginFailSessionNoUser(){ 
       //声明HttpServletRequest获取到的是正常的HttpSession  
       EasyMock.expect(request.getSession()).andReturn(session); 
       //声明HttpSession中无用户  
       EasyMock.expect(session.getAttribute("loginUser")).andReturn(null); 
       EasyMock.replay(request, session); 
       //验证HttpSession中无用户时登录应该是失败的  
       Assert.assertFalse(servlet.isLogin(request)); 
       EasyMock.verify(request, session); 
   } 
    
   /**
    * 测试登录成功的情况
    */ 
   @Test 
   public void testIsLoginSuccess(){ 
       //声明HttpServletRequest获取到的是正常的HttpSession  
       EasyMock.expect(request.getSession()).andReturn(session); 
       //声明HttpSession中存在用户  
       EasyMock.expect(session.getAttribute("loginUser")).andReturn(new User()); 
       EasyMock.replay(request, session); 
       //验证HttpSession有效且存在用户时登录应该是成功的  
       Assert.assertTrue(servlet.isLogin(request)); 
       EasyMock.verify(request, session); 
   } 
}