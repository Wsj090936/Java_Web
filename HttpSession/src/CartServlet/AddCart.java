package CartServlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DBUtils.DBUtils;
import Product.Book;
/**
 * 添加购物车
 * @author wushijia
 *
 */
public class AddCart extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//根据表单中的id得到书
		String id = req.getParameter("id");
		Book book = DBUtils.findBookById(id);
		HttpSession session = req.getSession();//得到session对象
		//取出购物车
		List<Book> list = (List<Book>) session.getAttribute("cart");
		if(list == null){
			list = new ArrayList<>();
		}
		list.add(book);
		session.setAttribute("cart", list);//更新session
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}
