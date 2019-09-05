package com.xhn.Servelt;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xhn.DAO.BaseDAO;
import com.xhn.Service.IBookService;
import com.xhn.Service.ILendService;
import com.xhn.Service.IUserService;
import com.xhn.Service.impel.IBookServiceImpel;
import com.xhn.Service.impel.ILendServiceImpel;
import com.xhn.Service.impel.IUserServiceImpel;
import com.xhn.model.Book;
import com.xhn.model.Lend;
import com.xhn.model.userInfo;
@WebServlet("/lendServlet")
public class lendServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private ILendService lendService=new ILendServiceImpel();
	private IUserService userService=new IUserServiceImpel();
	private IBookService bookService=new IBookServiceImpel();
	private BaseDAO baseDao = new BaseDAO();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//将需要显示的用户信息放到session中
		//HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String type = request.getParameter("type");
		String id = request.getParameter("id");
		String userId = request.getParameter("userId");
		String bookId = request.getParameter("bookId");
		
		
		if(type.equals("toLend")) {
			if(id!=null && !id.equals("")) {
				//获取用户基本信息
				userInfo user = this.userService.get(Integer.parseInt(id));
				List<Book> bookList=this.bookService.getAll();
		
				String sql="SELECT COUNT(*) FROM category where 1=1";
				Object[] obj=new Object[] {};
				//总记录数
				int totalRecords=baseDao.count(sql,obj);
				if(user.getUsername()!=null) {
					request.setAttribute("totalRecords", totalRecords);
					request.setAttribute("user", user);
					request.setAttribute("bookList", bookList);
					request.getRequestDispatcher("/jsp/lend/toLend.jsp").forward(request, response);
				}else {
					request.setAttribute("message", "查无此人！！！");
					request.getRequestDispatcher("/jsp/lend/toLend.jsp").forward(request, response);
				}
				
			}
		}else if(type.equals("lend")) {
			Lend lend = new Lend();
			lend.setUserId(Integer.parseInt(userId));
			lend.setBookId(Integer.parseInt(bookId));
			lend.setLendDateTime(new Date());
			int res = this.lendService.add(lend);
			if(res>0) {
				request.setAttribute("message", "借阅成功");
				request.getRequestDispatcher("/jsp/lend/lendResult.jsp").forward(request, response);
			}
		}
		
	}
	
}
