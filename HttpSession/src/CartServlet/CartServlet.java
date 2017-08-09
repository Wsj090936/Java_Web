package CartServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBUtils.DBUtils;
import Product.Book;

/**
 * ���ﳵ������ҳ
 * @author wushijia
 *
 */
public class CartServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.write("����վ�������鼮:<br/>");
		Map<String, Book> books = DBUtils.getBooks();
		for (Map.Entry<String, Book> book : books.entrySet()) {
			out.write("<a href='"+req.getContextPath()+"/Session/addcart?id="+book.getKey()+"' target='_blank'>"+book.getValue().getName()+"</a><br/>");
		}
		out.write("<a href='"+req.getContextPath()+"/Session/showcart' target='_blank'>�鿴���ﳵ</a>");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}
