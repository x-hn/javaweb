package com.xhn.Servelt;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xhn.DAO.BaseDAO;
import com.xhn.Service.IUserService;
import com.xhn.Service.impel.IUserServiceImpel;
import com.xhn.constans.UserConstant;
import com.xhn.model.userInfo;
@WebServlet("/userServlet")
public class UserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private IUserService userService = new IUserServiceImpel();
	private BaseDAO baseDAO=new BaseDAO();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//将需要显示的用户信息放到session中
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String type = request.getParameter("type");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String realname = request.getParameter("realname");
		String email = request.getParameter("email");
		String role = request.getParameter("role");
		String isUserCookie=request.getParameter("isUserCookie");
		String id = request.getParameter("id");
		
		if(type.equals("login")) {
			login(request, response, username, password,session,isUserCookie);
		}else if(type.equals("loginOut")) {
			loginOut(request, response, session);
		}else if(type.equals("getAll")) {
			getAll(request, response);
		}else if(type.equals("add")) {
			add(request, response, username, realname, email, role);
		}else if(type.equals("delete")) {
			delete(request, response,id);
		}else if(type.equals("get")) {
			get(request, response, id);
		}else if(type.equals("updateUser")) {
			updateUser(request, response, username, realname, email, role, id);
		}
	}
	private void updateUser(HttpServletRequest request, HttpServletResponse response, String username, String realname,
			String email, String role, String id) throws ServletException, IOException {
		userInfo user = new userInfo(username, realname, email, UserConstant.DEFAULT_PASSWORD, Integer.parseInt(role));
		user.setId(Integer.parseInt(id));
		if(role.equals("2")) {
			user.setMaxNumber(UserConstant.STUDENT_MAX_NUMBER);
		}else {
			user.setMaxNumber(UserConstant.TEACHER_MAX_NUMBER);
		}
		this.userService.update(user);
		request.getRequestDispatcher("/userServlet?type=getAll").forward(request, response);
	}
	private void get(HttpServletRequest request, HttpServletResponse response, String id)
			throws ServletException, IOException {
		userInfo user = this.userService.get(Integer.parseInt(id));
		request.setAttribute("obj", user);
		request.getRequestDispatcher("/jsp/user/editUserInfo.jsp").forward(request, response);
	}
	private void delete(HttpServletRequest request, HttpServletResponse response,String id) throws IOException {
		//检查在借阅记录中是否有该用户，
		this.userService.delete(Integer.parseInt(id));
		response.sendRedirect(request.getContextPath()+"/userServlet?type=getAll");
	}
	private void add(HttpServletRequest request, HttpServletResponse response, String username, String realname,
			String email, String role) throws IOException {
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
	private void getAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//当前页
		String p=request.getParameter("page");
		int page;
		try {
			page=Integer.valueOf(p);
		} catch (Exception e) {
			page=1;
		}
		//每页页数
		int pageSizes=3;
		//开始索引
		int beginIndex=(page-1)*pageSizes;

		List<userInfo> modelList = this.userService.getAll(page,pageSizes);

		String sql="SELECT COUNT(*) FROM userInfo where 1=1";
		Object[] obj=new Object[] {};
		//总记录数
		int totalRecords=baseDAO.count(sql,obj);
		//总页数
		int totalPages=totalRecords % pageSizes ==0?totalRecords / pageSizes:totalRecords / pageSizes +1;
		//结束索引
		int endIndex=beginIndex+pageSizes;
		if(endIndex>totalRecords) {
			endIndex=totalRecords;
		}
		request.setAttribute("page", page);
		request.setAttribute("totalRecords", totalRecords);
		request.setAttribute("totalPages", totalPages);
		request.setAttribute("beginIndex", beginIndex);
		request.setAttribute("endIndex", endIndex);
		request.setAttribute("pageSizes", pageSizes);
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
	private void login(HttpServletRequest request, HttpServletResponse response, String username, String password,HttpSession session,String isUserCookie)
			throws ServletException, IOException {
		userInfo userinfo = this.userService.login(username,password);
		if(userinfo!=null) {
			//判断是否记住登录状态
			if(isUserCookie!=null) {
				Cookie usernameCookie=new Cookie("username",username);
				Cookie passwordCookie=new Cookie("password",password);
				usernameCookie.setMaxAge(7*24*60*60);
				passwordCookie.setMaxAge(7*24*60*60);
				response.addCookie(usernameCookie);
				response.addCookie(passwordCookie);
			}else {
				Cookie[] cookie=request.getCookies();
				if(cookie!=null && cookie.length>0) {
					for(Cookie cookies:cookie) {
						if(cookies.getName().equalsIgnoreCase("username")||cookies.getName().equalsIgnoreCase("password")) {
							cookies.setMaxAge(0);
							response.addCookie(cookies);
						}
					}
				}
			}
			session.setAttribute("loginUser", userinfo);
			request.getRequestDispatcher("/main.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}
	
}
