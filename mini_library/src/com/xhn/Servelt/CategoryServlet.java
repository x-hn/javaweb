package com.xhn.Servelt;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xhn.Service.ICategoryService;
import com.xhn.Service.impel.ICategoryServiceImpel;
import com.xhn.model.Category;
@WebServlet("/categoryServlet")
public class CategoryServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ICategoryService categoryService=new ICategoryServiceImpel();
	
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
		List<Category> categoryList = this.categoryService.getAll();
		request.setAttribute("categoryList", categoryList);
		request.getRequestDispatcher("/jsp/category/categorylist.jsp").forward(request, response);
	}
	
	
}
