package com.xhn.Servelt;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xhn.DAO.BaseDAO;
import com.xhn.Service.IBookService;
import com.xhn.Service.IUserService;
import com.xhn.Service.impel.IBookServiceImpel;
import com.xhn.Service.impel.IUserServiceImpel;
import com.xhn.model.Book;
import com.xhn.model.userInfo;
@WebServlet("/lendServlet")
public class lendServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	//private ILendService lendService=new ILendServiceImpel();
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
		
		if(type.equals("toLend")) {
			if(id!=null && !id.equals("")) {
				//获取用户基本信息
				userInfo user = this.userService.get(Integer.parseInt(id));
				List<Book> bookList=this.bookService.getAll();
		
				String sql="SELECT COUNT(*) FROM book where 1=1";
				Object[] obj=new Object[] {};
				//总记录数
				int totalRecords=baseDao.count(sql,obj);
				
				request.setAttribute("totalRecords", totalRecords);
				
				
				request.setAttribute("obj", user);
				request.setAttribute("bookList", bookList);
				request.getRequestDispatcher("/jsp/lend/toLend.jsp").forward(request, response);
			}
		}
		
	}
	
}
