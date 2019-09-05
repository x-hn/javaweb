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
import com.xhn.Service.IRecordService;
import com.xhn.Service.IUserService;
import com.xhn.Service.impel.IBookServiceImpel;
import com.xhn.Service.impel.ILendServiceImpel;
import com.xhn.Service.impel.IRecordServiceImpel;
import com.xhn.Service.impel.IUserServiceImpel;
import com.xhn.model.Book;
import com.xhn.model.Lend;
import com.xhn.model.Record;
import com.xhn.model.userInfo;

@WebServlet("/recordServlet")
public class RecordServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ILendService lendservice = new ILendServiceImpel();
	private IUserService userService = new IUserServiceImpel();
	private IRecordService recordService = new IRecordServiceImpel(); 
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
		String userid = request.getParameter("userId");
		String bookid = request.getParameter("bookId");
		 
		
		if(type.equals("toRecord")) {
			userInfo user = this.userService.get(Integer.parseInt(id));
			List<Lend> lendlist = this.lendservice.get(Integer.parseInt(id));
			
			String sql="SELECT COUNT(*) FROM lend where 1=1";
			Object[] obj=new Object[] {};
			//总记录数
			int totalRecords=baseDao.count(sql,obj);
			if(user.getUsername()!=null) {
				request.setAttribute("totalRecords", totalRecords);
				request.setAttribute("user", user);
				request.setAttribute("lendlist", lendlist);
				request.getRequestDispatcher("/jsp/record/toRecord.jsp").forward(request, response);
			}else {
				request.setAttribute("message", "查无此人！！！");
				request.getRequestDispatcher("/jsp/record/toRecord.jsp").forward(request, response);
			}
		}else if(type.equals("record")) {
			Record record = new Record();
			userInfo user = this.userService.get(Integer.parseInt(userid));
			Book book = this.bookService.get(Integer.parseInt(bookid));
			Lend lend = this.lendservice.getLend(Integer.parseInt(bookid));
			record.setUserId(Integer.parseInt(userid));
			record.setRealname(user.getRealname());
			record.setBookId(Integer.parseInt(bookid));
			record.setBookName(book.getBookName());
			record.setLendDateTime(lend.getLendDateTime());
			record.setActualReturnTime(new Date());
			int res = this.recordService.add(record);
			if(res>0) {
				int result = this.lendservice.delete(lend.getId());
				if(result>0) {
					request.getRequestDispatcher("/jsp/record/toRecord.jsp").forward(request, response);
				}
			}
		}
	}
	
}
