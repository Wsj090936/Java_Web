package ServletDemo2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.dsna.util.images.ValidateCode;
/**
 * ��֤��
 * @author wushijia
 *
 */
public class Test_ValidateCode extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ValidateCode vc = new ValidateCode(110, 25, 4, 5);//�ĸ���֤���֣�5��Ӱ����
		vc.write(resp.getOutputStream());
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
