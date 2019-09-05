package com.xhn.Servelt;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xhn.DAO.BaseDAO;
import com.xhn.Service.ICategoryService;
import com.xhn.Service.impel.ICategoryServiceImpel;
import com.xhn.model.Book;
import com.xhn.model.Category;
import com.xhn.model.userInfo;
@WebServlet("/categoryServlet")
public class CategoryServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ICategoryService categoryService=new ICategoryServiceImpel();
	private BaseDAO baseDao=new BaseDAO();
	
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
		String categoryName = request.getParameter("categoryName");
		String id = request.getParameter("id");
		
		
		if(type.equals("getAll")) {
			getAll(request, response);
		}else if(type.equals("add")) {
			add(request, response, categoryName);
		}else if(type.equals("delete")) {
			delete(request, response, id);
		}else if(type.equals("get")) {
			get(request, response, id);
		}else if(type.equals("updatecategory")) {
			update(request, response, categoryName, id);
		}
		
	}
	private void update(HttpServletRequest request, HttpServletResponse response, String categoryName, String id)
			throws ServletException, IOException {
		Category category = new Category(categoryName);
		category.setId(Integer.parseInt(id));
		this.categoryService.update(category);
		request.getRequestDispatcher("/categoryServlet?type=getAll").forward(request, response);
	}
	private void get(HttpServletRequest request, HttpServletResponse response, String id)
			throws ServletException, IOException {
		Category category = this.categoryService.get(Integer.parseInt(id));
		request.setAttribute("obj", category);
		request.getRequestDispatcher("/jsp/category/editCategory.jsp").forward(request, response);
	}
	private void delete(HttpServletRequest request, HttpServletResponse response, String id) throws IOException {
		this.categoryService.delete(Integer.parseInt(id));
		response.sendRedirect(request.getContextPath()+"/categoryServlet?type=getAll");
	}
	private void add(HttpServletRequest request, HttpServletResponse response, String categoryName) throws IOException {
		Category category = new Category(categoryName);
		int res = this.categoryService.add(category);
		if(res>0) {
			response.sendRedirect(request.getContextPath()+"/categoryServlet?type=getAll");
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

		List<Category> categoryList = this.categoryService.getAll(page,pageSizes);

		String sql="SELECT COUNT(*) FROM category where 1=1";
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
		request.setAttribute("categoryList", categoryList);
		request.getRequestDispatcher("/jsp/category/categorylist.jsp").forward(request, response);
	}
	
	
}
