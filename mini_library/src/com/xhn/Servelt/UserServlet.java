package com.xhn.Servelt;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xhn.Service.IUserService;
import com.xhn.Service.impel.IUserServiceImpel;
import com.xhn.model.userInfo;
@WebServlet("/userServlet")
public class UserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private IUserService userService = new IUserServiceImpel();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("type");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if(type.equals("login")) {
			userInfo userinfo = this.userService.login(username,password);
			if(userinfo!=null) {
				request.getRequestDispatcher("/main.jsp").forward(request, response);
			}else {
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
		}
	}
	
}
