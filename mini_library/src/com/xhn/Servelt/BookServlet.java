package com.xhn.Servelt;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xhn.DAO.IBookDao;
import com.xhn.DAO.impel.IBookDaoImpel;
import com.xhn.Service.IBookService;
import com.xhn.Service.IUserService;
import com.xhn.Service.impel.IBookServiceImpel;
import com.xhn.Service.impel.IUserServiceImpel;
import com.xhn.model.Book;
import com.xhn.model.userInfo;
@WebServlet("/bookServlet")
public class BookServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private IBookDao book =new IBookDaoImpel();
	private IBookService bookService=new IBookServiceImpel();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//将需要显示的用户信息放到session中
		HttpSession session = request.getSession();
		String type = request.getParameter("type");
		
		if(type.equals("getAll")) {
			List<Book> bookList = this.bookService.getAll();
			request.setAttribute("bookList", bookList);
			
		}
		
	}
	
	
}
