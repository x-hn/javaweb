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
	//private IBookDao book =new IBookDaoImpel();
	private IBookService bookService=new IBookServiceImpel();
	
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
		String bookName = request.getParameter("bookName");
		String bookNumber = request.getParameter("bookNumber");
		String categoryId = request.getParameter("categoryId");
		String author = request.getParameter("author");
		String publisher = request.getParameter("publisher");
		
		
		if(type.equals("getAll")) {
			getAll(request, response);
		}else if(type.equals("add")) {
			add(request, response, bookName, bookNumber, categoryId, author, publisher);
		}else if(type.equals("delete")) {
			Integer id = Integer.parseInt(request.getParameter("id"));
			this.bookService.delete(id);
			response.sendRedirect(request.getContextPath()+"/userServlet?type=getAll");
		}
		
	}
	private void add(HttpServletRequest request, HttpServletResponse response, String bookName, String bookNumber,
			String categoryId, String author, String publisher) throws IOException {
		Book book = new Book(bookName, Integer.parseInt(bookNumber), Integer.parseInt(categoryId), author, publisher);
		int res = this.bookService.add(book);
		if(res>0) {
			response.sendRedirect(request.getContextPath()+"/bookServlet?type=getAll");
		}
	}
	private void getAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Book> bookList = this.bookService.getAll();
		request.setAttribute("bookList", bookList);
		request.getRequestDispatcher("/jsp/book/bookList.jsp").forward(request, response);
	}
	
	
}
