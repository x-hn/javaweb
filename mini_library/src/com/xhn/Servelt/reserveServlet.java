package com.xhn.Servelt;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xhn.DAO.BaseDAO;
import com.xhn.Service.ILendService;
import com.xhn.Service.IUserService;
import com.xhn.Service.impel.ILendServiceImpel;
import com.xhn.Service.impel.IUserServiceImpel;
import com.xhn.model.Lend;
import com.xhn.model.userInfo;

@WebServlet("/reserveServlet")
public class reserveServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ILendService lendservice = new ILendServiceImpel();
	private IUserService userService=new IUserServiceImpel();
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
		 
		
		if(type.equals("toReserve")) {
			userInfo user = this.userService.get(Integer.parseInt(id));
			List<Lend> lendlist = this.lendservice.get(Integer.parseInt(id));
			
			String sql="SELECT COUNT(*) FROM reserve where 1=1";
			Object[] obj=new Object[] {};
			//总记录数
			int totalRecords=baseDao.count(sql,obj);
			if(user.getUsername()!=null) {
				request.setAttribute("totalRecords", totalRecords);
				request.setAttribute("user", user);
				request.setAttribute("lendlist", lendlist);
				request.getRequestDispatcher("/jsp/reserve/toReserve.jsp").forward(request, response);
			}else {
				request.setAttribute("message", "查无此人！！！");
				request.getRequestDispatcher("/jsp/lend/toLend.jsp").forward(request, response);
			}
		}
	}
	
}
