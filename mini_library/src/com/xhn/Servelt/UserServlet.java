package com.xhn.Servelt;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xhn.Service.IUserService;
import com.xhn.Service.impel.IUserServiceImpel;
import com.xhn.constans.UserConstant;
import com.xhn.model.userInfo;
@WebServlet("/userServlet")
public class UserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private IUserService userService = new IUserServiceImpel();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//将需要显示的用户信息放到session中
		HttpSession session = request.getSession();
		String type = request.getParameter("type");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String realname = request.getParameter("realname");
		String email = request.getParameter("email");
		String role = request.getParameter("role");
		
		if(type.equals("login")) {
			login(request, response, username, password,session);
		}else if(type.equals("loginOut")) {
			loginOut(request, response, session);
		}else if(type.equals("getAll")) {
			getAll(request, response);
		}else if(type.equals("add")) {
			userInfo user = new userInfo(username, realname, email, UserConstant.DEFAULT_PASSWORD, Integer.parseInt(role));
			if(role.equals("2")) {
				user.setMaxNumber(UserConstant.STUDENT_MAX_NUMBER);
			}else {
				user.setMaxNumber(UserConstant.TEACHER_MAX_NUMBER);
			}
			int result = this.userService.add(user);
			if(result>0) {
				response.sendRedirect(request.getContextPath()+"/userServlet?type=getAll");
			}
		}
	}
	private void getAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<userInfo> modelList = this.userService.getAll();
		request.setAttribute("modelList", modelList);
		//请求转发（在请求中保存数据）
		request.getRequestDispatcher("/jsp/user/userList.jsp").forward(request, response);
		//重定向（不保存数据）
		//response.sendRedirect(request.getContextPath()+"/login.jsp");
	}
	private void loginOut(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		//session.invalidate(); 让session不可用
		session.removeAttribute("loginOut");
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}
	private void login(HttpServletRequest request, HttpServletResponse response, String username, String password,HttpSession session)
			throws ServletException, IOException {
		userInfo userinfo = this.userService.login(username,password);
		if(userinfo!=null) {
			session.setAttribute("loginUser", userinfo);
			request.getRequestDispatcher("/main.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}
	
}
