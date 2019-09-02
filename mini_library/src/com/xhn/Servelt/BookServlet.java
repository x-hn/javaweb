package com.xhn.Servelt;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xhn.DAO.BaseDAO;
import com.xhn.DAO.IBookDao;
import com.xhn.DAO.impel.IBookDaoImpel;
import com.xhn.Service.IBookService;
import com.xhn.Service.IUserService;
import com.xhn.Service.impel.IBookServiceImpel;
import com.xhn.Service.impel.IUserServiceImpel;
import com.xhn.constans.UserConstant;
import com.xhn.model.Book;
import com.xhn.model.userInfo;
@WebServlet("/bookServlet")
public class BookServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	//private IBookDao book =new IBookDaoImpel();
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
		String bookName = request.getParameter("bookName");
		String bookNumber = request.getParameter("bookNumber");
		String categoryId = request.getParameter("categoryId");
		String author = request.getParameter("author");
		String publisher = request.getParameter("publisher");
		String id = request.getParameter("id");
		
		
		if(type.equals("getAll")) {
			getAll(request, response);
		}else if(type.equals("add")) {
			add(request, response, bookName, bookNumber, categoryId, author, publisher);
		}else if(type.equals("delete")) {
			delete(request, response, id);
		}else if(type.equals("get")) {
			Book book = this.bookService.get(Integer.parseInt(id));
			request.setAttribute("obj", book);
			request.getRequestDispatcher("/jsp/book/editBookInfo.jsp").forward(request, response);
		}else if(type.equals("updateBook")) {
			Book book = new Book(bookName, Integer.parseInt(bookNumber), Integer.parseInt(categoryId), author, publisher);
			book.setId(Integer.parseInt(id));
			this.bookService.update(book);
			request.getRequestDispatcher("/bookServlet?type=getAll").forward(request, response);
		}
		
	}
	private void delete(HttpServletRequest request, HttpServletResponse response, String id) throws IOException {
		this.bookService.delete(Integer.parseInt(id));
		response.sendRedirect(request.getContextPath()+"/bookServlet?type=getAll");
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

		List<Book> bookList = this.bookService.getAll(page,pageSizes);

		String sql="SELECT COUNT(*) FROM book where 1=1";
		Object[] obj=new Object[] {};
		//总记录数
		int totalRecords=baseDao.count(sql,obj);
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
		//请求转发（在请求中保存数据）
		request.setAttribute("bookList", bookList);
		request.getRequestDispatcher("/jsp/book/bookList.jsp").forward(request, response);
	}
	
	
}
