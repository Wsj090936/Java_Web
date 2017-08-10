package login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.dsna.util.images.ValidateCode;
/**
 * 验证码
 * @author wushijia
 *
 */
public class code extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ValidateCode code = new ValidateCode(100, 25, 4, 7);
		req.getSession().setAttribute("rcode", code.getCode());//向session中保存验证码
		code.write(resp.getOutputStream());
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
