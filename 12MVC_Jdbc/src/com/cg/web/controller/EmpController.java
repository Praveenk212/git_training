package com.cg.web.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cg.web.service.EmpServices;

//http://localhost:9097/12MVC_Jdbc/empService/home.do
@Controller
@RequestMapping("/empService")
public class EmpController 
{
	@Autowired
	private EmpServices service;
	@RequestMapping("/home.do")
	public String getHomePage()
	{
		return "Home";
	}
	@RequestMapping("/login.do")
	public String getLoginPage()
	{
		return "Login";
	}
	
	@RequestMapping("/authenticate.do")
	public ModelAndView authenticate(
			       @RequestParam("userName") String userName,
			       @RequestParam("password") String passWord  )
	{
		System.out.println(userName+" "+passWord);
		
		String fullName=service.authenticate(userName, passWord);
		
		ModelAndView mAndView=null;
//		String userName=request.getParameter("userName");
//		String password=request.getParameter("password");
		if(fullName!=null)
		{
			mAndView=new ModelAndView("AfterAuthentication");
			mAndView.addObject("fullName",fullName);
		}
		else
		{
			mAndView=new ModelAndView("Login");
			mAndView.addObject("msg","authentication failed");
		}
	return mAndView;
	}

}
