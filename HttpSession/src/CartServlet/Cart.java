package CartServlet;

import java.io.IOException;
import java.io.PrintWriter;
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
 * 购物车
 * @author wushijia
 *
 */
public class Cart extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		//得到Session对象,并且得到购物车清单
		List<Book> books = (List<Book>) req.getSession().getAttribute("cart");
		PrintWriter out = resp.getWriter();
		out.print("购物车有以下商品:<br/>");
		if(books == null){//如果购物车中没有商品
			out.print("你还未购买任何商品");
			resp.setHeader("refresh", "2;url="+req.getContextPath()+"/Session/cartindex");
//			resp.sendRedirect(req.getContextPath()+"/Session/cartindex");//重定向
		}else{
			
			for (Book book : books) {//列出购物车中的书
				out.write(book.getName()+"<br/>");
			}
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}
