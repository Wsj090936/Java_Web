package login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class doLogin extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		String name = req.getParameter("userName");//得到用户名
		String pwd = req.getParameter("pwd");//得到密码
		String code = req.getParameter("code");//得到用户验证码的值
		String rcode = (String) req.getSession().getAttribute("rcode");//得到正确的验证码的值
		if("jerry".equals(name) && "123".equals(pwd)){
			if(!rcode.equalsIgnoreCase(code)){//验证码不正确
				req.setAttribute("msg", "验证码输入有误");
				req.getRequestDispatcher("/index.jsp").forward(req, resp);
			}else{
				out.print("登陆成功");
			}
			
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
