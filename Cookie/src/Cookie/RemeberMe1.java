package Cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RemeberMe1 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		//获取表单数据
		String username = req.getParameter("userName");
		String pwd = req.getParameter("pwd");
		String remeber = req.getParameter("remeber");//当多选框和单选框没有被选中时，其返回值为null
		Cookie ck = new Cookie("userName",username);
		ck.setPath("/");//设置路径
		//处理业务逻辑
		//转发和定向
		if("tom".equals(username) && "123".equals(pwd)){
			if(remeber != null){
				ck.setMaxAge(60*60);//设置保存一个小时
			}else{
				ck.setMaxAge(0);//删除Cookie
			}
			resp.addCookie(ck);//将Cookie写入缓存
			out.write("登陆成功！");
		}else{
			out.write("登陆失败，请检查您的用户名或密码是否正确");
			//设置两秒跳回登陆界面
			resp.setHeader("refresh", "2;url="+req.getContextPath()+"/cookie/remeberme");
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
